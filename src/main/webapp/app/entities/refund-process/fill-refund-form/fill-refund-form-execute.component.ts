import { Component, Vue, Inject } from 'vue-property-decorator';

import FillRefundFormService from './fill-refund-form.service';
import { FillRefundFormContext } from './fill-refund-form.model';

const validations: any = {
  taskContext: {
    refundProcess: {
      refund: {
        amount: {},
        method: {},
      },
    },
  },
};

@Component({
  validations,
})
export default class FillRefundFormExecuteComponent extends Vue {
  private fillRefundFormService: FillRefundFormService = new FillRefundFormService();
  private taskContext: FillRefundFormContext = {};
  public isSaving = false;

  beforeRouteEnter(to, from, next) {
    next(vm => {
      if (to.params.taskInstanceId) {
        vm.claimTaskInstance(to.params.taskInstanceId);
      }
    });
  }

  public claimTaskInstance(taskInstanceId) {
    this.fillRefundFormService.claim(taskInstanceId).then(res => {
      this.taskContext = res;
    });
  }

  public previousState() {
    this.$router.go(-1);
  }

  public complete() {
    this.fillRefundFormService.complete(this.taskContext).then(res => {
      this.$router.go(-1);
    });
  }

  public initRelationships(): void {}
}
