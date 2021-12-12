import { Component, Vue, Inject } from 'vue-property-decorator';

import ReadSupportResponseService from './read-support-response.service';
import { ReadSupportResponseContext } from './read-support-response.model';

const validations: any = {
  taskContext: {
    supportProcess: {
      support: {
        supportId: {},
        createDate: {},
        issue: {},
        userReply: {},
        isResolved: {},
      },
    },
  },
};

@Component({
  validations,
})
export default class ReadSupportResponseExecuteComponent extends Vue {
  private readSupportResponseService: ReadSupportResponseService = new ReadSupportResponseService();
  private taskContext: ReadSupportResponseContext = {};
  public isSaving = false;

  beforeRouteEnter(to, from, next) {
    next(vm => {
      if (to.params.taskInstanceId) {
        vm.claimTaskInstance(to.params.taskInstanceId);
      }
    });
  }

  public claimTaskInstance(taskInstanceId) {
    this.readSupportResponseService.claim(taskInstanceId).then(res => {
      this.taskContext = res;
    });
  }

  public previousState() {
    this.$router.go(-1);
  }

  public complete() {
    this.readSupportResponseService.complete(this.taskContext).then(res => {
      this.$router.go(-1);
    });
  }

  public initRelationships(): void {}
}
