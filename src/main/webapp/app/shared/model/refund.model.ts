export interface IRefund {
  id?: number;
  refundId?: number | null;
  amount?: number | null;
  method?: string | null;
}

export class Refund implements IRefund {
  constructor(public id?: number, public refundId?: number | null, public amount?: number | null, public method?: string | null) {}
}
