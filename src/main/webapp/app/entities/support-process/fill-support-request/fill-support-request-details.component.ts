import { Component, Vue, Inject } from 'vue-property-decorator';

import FillSupportRequestService from './fill-support-request.service';
import { FillSupportRequestContext } from './fill-support-request.model';

@Component
export default class FillSupportRequestDetailsComponent extends Vue {
  private fillSupportRequestService: FillSupportRequestService = new FillSupportRequestService();
  private taskContext: FillSupportRequestContext = {};

  beforeRouteEnter(to, from, next) {
    next(vm => {
      if (to.params.taskInstanceId) {
        vm.retrieveContext(to.params.taskInstanceId);
      }
    });
  }

  public retrieveContext(taskInstanceId) {
    this.fillSupportRequestService.loadContext(taskInstanceId).then(res => {
      this.taskContext = res;
    });
  }

  public previousState() {
    this.$router.go(-1);
  }
}
