import { Component, Vue, Inject } from 'vue-property-decorator';

import AnalyseRefundRequestService from './analyse-refund-request.service';
import { AnalyseRefundRequestContext } from './analyse-refund-request.model';

@Component
export default class AnalyseRefundRequestDetailsComponent extends Vue {
  private analyseRefundRequestService: AnalyseRefundRequestService = new AnalyseRefundRequestService();
  private taskContext: AnalyseRefundRequestContext = {};

  beforeRouteEnter(to, from, next) {
    next(vm => {
      if (to.params.taskInstanceId) {
        vm.retrieveContext(to.params.taskInstanceId);
      }
    });
  }

  public retrieveContext(taskInstanceId) {
    this.analyseRefundRequestService.loadContext(taskInstanceId).then(res => {
      this.taskContext = res;
    });
  }

  public previousState() {
    this.$router.go(-1);
  }
}
