import { Component, Vue, Inject } from 'vue-property-decorator';

import ReadSupportResponseService from './read-support-response.service';
import { ReadSupportResponseContext } from './read-support-response.model';

@Component
export default class ReadSupportResponseDetailsComponent extends Vue {
  private readSupportResponseService: ReadSupportResponseService = new ReadSupportResponseService();
  private taskContext: ReadSupportResponseContext = {};

  beforeRouteEnter(to, from, next) {
    next(vm => {
      if (to.params.taskInstanceId) {
        vm.retrieveContext(to.params.taskInstanceId);
      }
    });
  }

  public retrieveContext(taskInstanceId) {
    this.readSupportResponseService.loadContext(taskInstanceId).then(res => {
      this.taskContext = res;
    });
  }

  public previousState() {
    this.$router.go(-1);
  }
}
