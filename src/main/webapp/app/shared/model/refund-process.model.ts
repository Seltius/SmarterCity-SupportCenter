import { IRefund } from '@/shared/model/refund.model';

export interface IRefundProcess {
  id?: number;
  processInstance?: any | null;
  refund?: IRefund | null;
}

export class RefundProcess implements IRefundProcess {
  constructor(public id?: number, public processInstance?: any | null, public refund?: IRefund | null) {}
}
