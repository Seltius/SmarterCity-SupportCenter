import { Component, Vue, Inject } from 'vue-property-decorator';

import { IRefundProcess } from '@/shared/model/refund-process.model';
import RefundProcessService from './refund-process.service';

@Component
export default class RefundProcessDetailsComponent extends Vue {
  @Inject('refundProcessService') private refundProcessService: () => RefundProcessService;
  public refundProcess: IRefundProcess = {};

  public isFetching: boolean = false;

  beforeRouteEnter(to, from, next) {
    next(vm => {
      if (to.params.processInstanceId) {
        vm.retrieveRefundProcess(to.params.processInstanceId);
      }
    });
  }

  public retrieveRefundProcess(refundProcessId) {
    this.isFetching = true;
    this.refundProcessService()
      .find(refundProcessId)
      .then(
        res => {
          this.refundProcess = res;
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
