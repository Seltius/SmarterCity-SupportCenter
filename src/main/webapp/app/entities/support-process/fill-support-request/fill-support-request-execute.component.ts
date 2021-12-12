import { Component, Vue, Inject } from 'vue-property-decorator';

import FillSupportRequestService from './fill-support-request.service';
import { FillSupportRequestContext } from './fill-support-request.model';

const validations: any = {
  taskContext: {
    supportProcess: {
      support: {
        name: {},
        email: {},
        issue: {},
      },
    },
  },
};

@Component({
  validations,
})
export default class FillSupportRequestExecuteComponent extends Vue {
  private fillSupportRequestService: FillSupportRequestService = new FillSupportRequestService();
  private taskContext: FillSupportRequestContext = {};
  public isSaving = false;

  beforeRouteEnter(to, from, next) {
    next(vm => {
      if (to.params.taskInstanceId) {
        vm.claimTaskInstance(to.params.taskInstanceId);
      }
    });
  }

  public claimTaskInstance(taskInstanceId) {
    this.fillSupportRequestService.claim(taskInstanceId).then(res => {
      this.taskContext = res;
    });
  }

  public previousState() {
    this.$router.go(-1);
  }

  public complete() {
    this.fillSupportRequestService.complete(this.taskContext).then(res => {
      this.$router.go(-1);
    });
  }

  public initRelationships(): void {}
}
