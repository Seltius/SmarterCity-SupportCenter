export interface ISupport {
  id?: number;
  supportId?: number | null;
  startDate?: Date | null;
  endDate?: Date | null;
  userName?: string | null;
  email?: string | null;
  message?: string | null;
  isRefund?: boolean | null;
  isValid?: boolean | null;
  refundId?: number | null;
  isResolved?: boolean | null;
  status?: string | null;
  supportMessage?: string | null;
}

export class Support implements ISupport {
  constructor(
    public id?: number,
    public supportId?: number | null,
    public startDate?: Date | null,
    public endDate?: Date | null,
    public userName?: string | null,
    public email?: string | null,
    public message?: string | null,
    public isRefund?: boolean | null,
    public isValid?: boolean | null,
    public refundId?: number | null,
    public isResolved?: boolean | null,
    public status?: string | null,
    public supportMessage?: string | null
  ) {
    this.isRefund = this.isRefund ?? false;
    this.isValid = this.isValid ?? false;
    this.isResolved = this.isResolved ?? false;
  }
}
