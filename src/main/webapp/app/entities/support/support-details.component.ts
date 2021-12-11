import { Component, Vue, Inject } from 'vue-property-decorator';

import { ISupport } from '@/shared/model/support.model';
import SupportService from './support.service';

@Component
export default class SupportDetails extends Vue {
  @Inject('supportService') private supportService: () => SupportService;
  public support: ISupport = {};

  beforeRouteEnter(to, from, next) {
    next(vm => {
      if (to.params.supportId) {
        vm.retrieveSupport(to.params.supportId);
      }
    });
  }

  public retrieveSupport(supportId) {
    this.supportService()
      .find(supportId)
      .then(res => {
        this.support = res;
      });
  }

  public previousState() {
    this.$router.go(-1);
  }
}
