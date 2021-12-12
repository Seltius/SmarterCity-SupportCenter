import { Component, Vue, Inject } from 'vue-property-decorator';

import AnalyseSupportRequestService from './analyse-support-request.service';
import { AnalyseSupportRequestContext } from './analyse-support-request.model';

const validations: any = {
  taskContext: {
    supportProcess: {
      support: {
        supportId: {},
        createDate: {},
        name: {},
        email: {},
        issue: {},
        isRefund: {},
      },
    },
  },
};

@Component({
  validations,
})
export default class AnalyseSupportRequestExecuteComponent extends Vue {
  private analyseSupportRequestService: AnalyseSupportRequestService = new AnalyseSupportRequestService();
  private taskContext: AnalyseSupportRequestContext = {};
  public isSaving = false;

  beforeRouteEnter(to, from, next) {
    next(vm => {
      if (to.params.taskInstanceId) {
        vm.claimTaskInstance(to.params.taskInstanceId);
      }
    });
  }

  public claimTaskInstance(taskInstanceId) {
    this.analyseSupportRequestService.claim(taskInstanceId).then(res => {
      this.taskContext = res;
    });
  }

  public previousState() {
    this.$router.go(-1);
  }

  public complete() {
    this.analyseSupportRequestService.complete(this.taskContext).then(res => {
      this.$router.go(-1);
    });
  }

  public initRelationships(): void {}
}
