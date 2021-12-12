import { Component, Vue, Inject } from 'vue-property-decorator';

import { IMessageProcess } from '@/shared/model/message-process.model';
import MessageProcessService from './message-process.service';

@Component
export default class MessageProcessDetailsComponent extends Vue {
  @Inject('messageProcessService') private messageProcessService: () => MessageProcessService;
  public messageProcess: IMessageProcess = {};

  public isFetching: boolean = false;

  beforeRouteEnter(to, from, next) {
    next(vm => {
      if (to.params.processInstanceId) {
        vm.retrieveMessageProcess(to.params.processInstanceId);
      }
    });
  }

  public retrieveMessageProcess(messageProcessId) {
    this.isFetching = true;
    this.messageProcessService()
      .find(messageProcessId)
      .then(
        res => {
          this.messageProcess = res;
          this.isFetching = false;
        },
        err => {
          this.isFetching = false;
        }
      );
  }

  public previousState() {
    this.$router.go(-1);
  }
}
