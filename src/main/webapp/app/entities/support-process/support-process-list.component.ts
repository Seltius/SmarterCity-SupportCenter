import { Component, Vue, Inject } from 'vue-property-decorator';
import { ISupportProcess } from '@/shared/model/support-process.model';

import { ProcessDefinition, ProcessDefinitionService } from 'akip-vue-community';

import SupportProcessService from './support-process.service';

@Component
export default class SupportProcessListComponent extends Vue {
  @Inject('supportProcessService') private supportProcessService: () => SupportProcessService;

  private processDefinitionService: ProcessDefinitionService = new ProcessDefinitionService();

  public bpmnProcessDefinitionId: string = 'SupportProcess';
  public processDefinition: ProcessDefinition = new ProcessDefinition();
  public supportProcessList: ISupportProcess[] = [];

  public isFetchingProcessDefinition = false;
  public isFetchingProcessInstances = false;

  public mounted(): void {
    this.init();
  }

  public init(): void {
    this.retrieveProcessDefinition();
    this.retrieveProcessInstances();
  }

  public retrieveProcessDefinition() {
    this.isFetchingProcessDefinition = true;
    this.processDefinitionService.find(this.bpmnProcessDefinitionId).then(
      res => {
        this.processDefinition = res;
        this.isFetchingProcessDefinition = false;
      },
      err => {
        this.isFetchingProcessDefinition = false;
      }
    );
  }

  public retrieveProcessInstances(): void {
    this.isFetchingProcessInstances = true;
    this.supportProcessService()
      .retrieve()
      .then(
        res => {
          this.supportProcessList = res.data;
          this.isFetchingProcessInstances = false;
        },
        err => {
          this.isFetchingProcessInstances = false;
        }
      );
  }

  get isFetching(): boolean {
    return this.isFetchingProcessDefinition && this.isFetchingProcessInstances;
  }

  public handleSyncList(): void {
    this.retrieveProcessInstances();
  }

  public previousState(): void {
    this.$router.go(-1);
  }
}
