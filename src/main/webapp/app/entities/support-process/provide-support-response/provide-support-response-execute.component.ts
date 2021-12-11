import { Component, Vue, Inject } from 'vue-property-decorator';

import ProvideSupportResponseService from './provide-support-response.service';
import { ProvideSupportResponseContext } from './provide-support-response.model';

const validations: any = {
  taskContext: {
    supportProcess: {
      support: {
        supportId: {},
        startDate: {},
        userName: {},
        email: {},
        message: {},
        supportMessage: {},
      },
    },
  },
};

@Component({
  validations,
})
export default class ProvideSupportResponseExecuteComponent extends Vue {
  private provideSupportResponseService: ProvideSupportResponseService = new ProvideSupportResponseService();
  private taskContext: ProvideSupportResponseContext = {};
  public isSaving = false;

  beforeRouteEnter(to, from, next) {
    next(vm => {
      if (to.params.taskInstanceId) {
        vm.claimTaskInstance(to.params.taskInstanceId);
      }
    });
  }

  public claimTaskInstance(taskInstanceId) {
    this.provideSupportResponseService.claim(taskInstanceId).then(res => {
      this.taskContext = res;
    });
  }

  public previousState() {
    this.$router.go(-1);
  }

  public complete() {
    this.provideSupportResponseService.complete(this.taskContext).then(res => {
      this.$router.go(-1);
    });
  }

  public initRelationships(): void {}
}
