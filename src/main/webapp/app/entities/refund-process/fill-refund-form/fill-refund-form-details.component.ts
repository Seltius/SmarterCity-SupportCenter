import { Component, Vue, Inject } from 'vue-property-decorator';

import FillRefundFormService from './fill-refund-form.service';
import { FillRefundFormContext } from './fill-refund-form.model';

@Component
export default class FillRefundFormDetailsComponent extends Vue {
  private fillRefundFormService: FillRefundFormService = new FillRefundFormService();
  private taskContext: FillRefundFormContext = {};

  beforeRouteEnter(to, from, next) {
    next(vm => {
      if (to.params.taskInstanceId) {
        vm.retrieveContext(to.params.taskInstanceId);
      }
    });
  }

  public retrieveContext(taskInstanceId) {
    this.fillRefundFormService.loadContext(taskInstanceId).then(res => {
      this.taskContext = res;
    });
  }

  public previousState() {
    this.$router.go(-1);
  }
}
