import { Component, Vue, Inject } from 'vue-property-decorator';

import AnalyseRefundRequestService from './analyse-refund-request.service';
import { AnalyseRefundRequestContext } from './analyse-refund-request.model';

const validations: any = {
  taskContext: {
    supportProcess: {
      support: {
        supportId: {},
        createDate: {},
        name: {},
        email: {},
        issue: {},
        isValid: {},
      },
    },
  },
};

@Component({
  validations,
})
export default class AnalyseRefundRequestExecuteComponent extends Vue {
  private analyseRefundRequestService: AnalyseRefundRequestService = new AnalyseRefundRequestService();
  private taskContext: AnalyseRefundRequestContext = {};
  public isSaving = false;

  beforeRouteEnter(to, from, next) {
    next(vm => {
      if (to.params.taskInstanceId) {
        vm.claimTaskInstance(to.params.taskInstanceId);
      }
    });
  }

  public claimTaskInstance(taskInstanceId) {
    this.analyseRefundRequestService.claim(taskInstanceId).then(res => {
      this.taskContext = res;
    });
  }

  public previousState() {
    this.$router.go(-1);
  }

  public complete() {
    this.analyseRefundRequestService.complete(this.taskContext).then(res => {
      this.$router.go(-1);
    });
  }

  public initRelationships(): void {}
}
