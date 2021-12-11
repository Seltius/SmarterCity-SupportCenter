import { mixins } from 'vue-class-component';

import { Component, Vue, Inject } from 'vue-property-decorator';
import Vue2Filters from 'vue2-filters';
import { IRefund } from '@/shared/model/refund.model';

import RefundService from './refund.service';

@Component({
  mixins: [Vue2Filters.mixin],
})
export default class Refund extends Vue {
  @Inject('refundService') private refundService: () => RefundService;
  private removeId: number = null;

  public refunds: IRefund[] = [];

  public isFetching = false;

  public mounted(): void {
    this.retrieveAllRefunds();
  }

  public clear(): void {
    this.retrieveAllRefunds();
  }

  public retrieveAllRefunds(): void {
    this.isFetching = true;

    this.refundService()
      .retrieve()
      .then(
        res => {
          this.refunds = res.data;
          this.isFetching = false;
        },
        err => {
          this.isFetching = false;
        }
      );
  }

  public handleSyncList(): void {
    this.clear();
  }

  public closeDialog(): void {
    (<any>this.$refs.removeEntity).hide();
  }
}
