import { Component, Vue, Inject } from 'vue-property-decorator';
import { IMessageProcess } from '@/shared/model/message-process.model';

import { ProcessDefinition, ProcessDefinitionService } from 'akip-vue-community';

import MessageProcessService from './message-process.service';

@Component
export default class MessageProcessListComponent extends Vue {
  @Inject('messageProcessService') private messageProcessService: () => MessageProcessService;

  private processDefinitionService: ProcessDefinitionService = new ProcessDefinitionService();

  public bpmnProcessDefinitionId: string = 'MessageProcess';
  public processDefinition: ProcessDefinition = new ProcessDefinition();
  public messageProcessList: IMessageProcess[] = [];

  public isFetchingProcessDefinition = false;
  public isFetchingProcessInstances = false;

  public mounted(): void {
    this.init();
  }

  public init(): void {
    this.retrieveProcessDefinition();
    this.retrieveProcessInstances();
  }

  public retrieveProcessDefinition() {
    this.isFetchingProcessDefinition = true;
    this.processDefinitionService.find(this.bpmnProcessDefinitionId).then(
      res => {
        this.processDefinition = res;
        this.isFetchingProcessDefinition = false;
      },
      err => {
        this.isFetchingProcessDefinition = false;
      }
    );
  }

  public retrieveProcessInstances(): void {
    this.isFetchingProcessInstances = true;
    this.messageProcessService()
      .retrieve()
      .then(
        res => {
          this.messageProcessList = res.data;
          this.isFetchingProcessInstances = false;
        },
        err => {
          this.isFetchingProcessInstances = false;
        }
      );
  }

  get isFetching(): boolean {
    return this.isFetchingProcessDefinition && this.isFetchingProcessInstances;
  }

  public handleSyncList(): void {
    this.retrieveProcessInstances();
  }

  public previousState(): void {
    this.$router.go(-1);
  }
}
