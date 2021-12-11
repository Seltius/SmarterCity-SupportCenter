import { Component, Vue, Inject } from 'vue-property-decorator';

import { IRefund } from '@/shared/model/refund.model';
import RefundService from './refund.service';

@Component
export default class RefundDetails extends Vue {
  @Inject('refundService') private refundService: () => RefundService;
  public refund: IRefund = {};

  beforeRouteEnter(to, from, next) {
    next(vm => {
      if (to.params.refundId) {
        vm.retrieveRefund(to.params.refundId);
      }
    });
  }

  public retrieveRefund(refundId) {
    this.refundService()
      .find(refundId)
      .then(res => {
        this.refund = res;
      });
  }

  public previousState() {
    this.$router.go(-1);
  }
}
