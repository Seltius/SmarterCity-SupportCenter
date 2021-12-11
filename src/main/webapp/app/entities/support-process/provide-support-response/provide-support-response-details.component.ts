import { Component, Vue, Inject } from 'vue-property-decorator';

import ProvideSupportResponseService from './provide-support-response.service';
import { ProvideSupportResponseContext } from './provide-support-response.model';

@Component
export default class ProvideSupportResponseDetailsComponent extends Vue {
  private provideSupportResponseService: ProvideSupportResponseService = new ProvideSupportResponseService();
  private taskContext: ProvideSupportResponseContext = {};

  beforeRouteEnter(to, from, next) {
    next(vm => {
      if (to.params.taskInstanceId) {
        vm.retrieveContext(to.params.taskInstanceId);
      }
    });
  }

  public retrieveContext(taskInstanceId) {
    this.provideSupportResponseService.loadContext(taskInstanceId).then(res => {
      this.taskContext = res;
    });
  }

  public previousState() {
    this.$router.go(-1);
  }
}
