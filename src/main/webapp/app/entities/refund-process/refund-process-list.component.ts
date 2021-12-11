import { Component, Vue, Inject } from 'vue-property-decorator';
import { IRefundProcess } from '@/shared/model/refund-process.model';

import { ProcessDefinition, ProcessDefinitionService } from 'akip-vue-community';

import RefundProcessService from './refund-process.service';

@Component
export default class RefundProcessListComponent extends Vue {
  @Inject('refundProcessService') private refundProcessService: () => RefundProcessService;

  private processDefinitionService: ProcessDefinitionService = new ProcessDefinitionService();

  public bpmnProcessDefinitionId: string = 'SupportProcess';
  public processDefinition: ProcessDefinition = new ProcessDefinition();
  public refundProcessList: IRefundProcess[] = [];

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
    this.refundProcessService()
      .retrieve()
      .then(
        res => {
          this.refundProcessList = res.data;
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
