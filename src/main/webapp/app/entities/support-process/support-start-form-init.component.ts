import { Component, Vue, Inject } from 'vue-property-decorator';

import { ISupportProcess, SupportProcess } from '@/shared/model/support-process.model';

import { ProcessInstance, ProcessDefinitionService } from 'akip-vue-community';

import { Support } from '@/shared/model/support.model';
import SupportProcessService from './support-process.service';

const validations: any = {
  supportProcess: {
    support: {},
  },
};

@Component({
  validations,
})
export default class SupportStartFormInitComponent extends Vue {
  @Inject('supportProcessService') private supportProcessService: () => SupportProcessService;

  private processDefinitionService: ProcessDefinitionService = new ProcessDefinitionService();

  public bpmnProcessDefinitionId: string = 'SupportProcess';
  public supportProcess: ISupportProcess = new SupportProcess();

  public isSaving = false;
  public currentLanguage = '';

  beforeRouteEnter(to, from, next) {
    next(vm => {
      vm.initSupportStartForm();
      vm.initRelationships();
    });
  }

  created(): void {
    this.currentLanguage = this.$store.getters.currentLanguage;
    this.$store.watch(
      () => this.$store.getters.currentLanguage,
      () => {
        this.currentLanguage = this.$store.getters.currentLanguage;
      }
    );
  }

  public save(): void {
    this.isSaving = true;

    this.supportProcessService()
      .create(this.supportProcess)
      .then(param => {
        this.isSaving = false;
        this.$router.go(-1);
        const message = this.$t('smarterCitySupportCenterApp.supportStartForm.created', { param: param.id });
        this.$root.$bvToast.toast(message.toString(), {
          toaster: 'b-toaster-top-center',
          title: 'Success',
          variant: 'success',
          solid: true,
          autoHideDelay: 5000,
        });
      });
  }

  public initSupportStartForm(): void {
    this.supportProcess.support = new Support();
  }

  public previousState(): void {
    this.$router.go(-1);
  }

  public initRelationships(): void {
    this.processDefinitionService.find(this.bpmnProcessDefinitionId).then(res => {
      this.supportProcess.processInstance = new ProcessInstance();
      this.supportProcess.processInstance.processDefinition = res;
    });
  }
}
