import { Component, Vue, Inject } from 'vue-property-decorator';

import { ISupportProcess } from '@/shared/model/support-process.model';
import SupportProcessService from './support-process.service';

@Component
export default class SupportProcessDetailsComponent extends Vue {
  @Inject('supportProcessService') private supportProcessService: () => SupportProcessService;
  public supportProcess: ISupportProcess = {};

  public isFetching: boolean = false;

  beforeRouteEnter(to, from, next) {
    next(vm => {
      if (to.params.processInstanceId) {
        vm.retrieveSupportProcess(to.params.processInstanceId);
      }
    });
  }

  public retrieveSupportProcess(supportProcessId) {
    this.isFetching = true;
    this.supportProcessService()
      .find(supportProcessId)
      .then(
        res => {
          this.supportProcess = res;
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
