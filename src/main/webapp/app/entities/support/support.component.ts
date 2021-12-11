import { mixins } from 'vue-class-component';

import { Component, Vue, Inject } from 'vue-property-decorator';
import Vue2Filters from 'vue2-filters';
import { ISupport } from '@/shared/model/support.model';

import SupportService from './support.service';

@Component({
  mixins: [Vue2Filters.mixin],
})
export default class Support extends Vue {
  @Inject('supportService') private supportService: () => SupportService;
  private removeId: number = null;

  public supports: ISupport[] = [];

  public isFetching = false;

  public mounted(): void {
    this.retrieveAllSupports();
  }

  public clear(): void {
    this.retrieveAllSupports();
  }

  public retrieveAllSupports(): void {
    this.isFetching = true;

    this.supportService()
      .retrieve()
      .then(
        res => {
          this.supports = res.data;
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
