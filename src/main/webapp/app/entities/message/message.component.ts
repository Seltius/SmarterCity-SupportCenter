import { mixins } from 'vue-class-component';

import { Component, Vue, Inject } from 'vue-property-decorator';
import Vue2Filters from 'vue2-filters';
import { IMessage } from '@/shared/model/message.model';

import MessageService from './message.service';

@Component({
  mixins: [Vue2Filters.mixin],
})
export default class Message extends Vue {
  @Inject('messageService') private messageService: () => MessageService;
  private removeId: number = null;

  public messages: IMessage[] = [];

  public isFetching = false;

  public mounted(): void {
    this.retrieveAllMessages();
  }

  public clear(): void {
    this.retrieveAllMessages();
  }

  public retrieveAllMessages(): void {
    this.isFetching = true;

    this.messageService()
      .retrieve()
      .then(
        res => {
          this.messages = res.data;
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
