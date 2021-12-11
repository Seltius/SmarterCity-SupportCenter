import { Component, Vue, Inject } from 'vue-property-decorator';

import AnalyseSupportRequestService from './analyse-support-request.service';
import { AnalyseSupportRequestContext } from './analyse-support-request.model';

@Component
export default class AnalyseSupportRequestDetailsComponent extends Vue {
  private analyseSupportRequestService: AnalyseSupportRequestService = new AnalyseSupportRequestService();
  private taskContext: AnalyseSupportRequestContext = {};

  beforeRouteEnter(to, from, next) {
    next(vm => {
      if (to.params.taskInstanceId) {
        vm.retrieveContext(to.params.taskInstanceId);
      }
    });
  }

  public retrieveContext(taskInstanceId) {
    this.analyseSupportRequestService.loadContext(taskInstanceId).then(res => {
      this.taskContext = res;
    });
  }

  public previousState() {
    this.$router.go(-1);
  }
}
