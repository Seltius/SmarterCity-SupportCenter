export interface ISupport {
  id?: number;
  supportId?: number | null;
  createDate?: Date | null;
  endDate?: Date | null;
  name?: string | null;
  email?: string | null;
  issue?: string | null;
  isRefund?: boolean | null;
  isValid?: boolean | null;
  refundId?: number | null;
  isResolved?: boolean | null;
  status?: string | null;
  userReply?: string | null;
  supportReply?: string | null;
}

export class Support implements ISupport {
  constructor(
    public id?: number,
    public supportId?: number | null,
    public createDate?: Date | null,
    public endDate?: Date | null,
    public name?: string | null,
    public email?: string | null,
    public issue?: string | null,
    public isRefund?: boolean | null,
    public isValid?: boolean | null,
    public refundId?: number | null,
    public isResolved?: boolean | null,
    public status?: string | null,
    public userReply?: string | null,
    public supportReply?: string | null
  ) {
    this.isRefund = this.isRefund ?? false;
    this.isValid = this.isValid ?? false;
    this.isResolved = this.isResolved ?? false;
  }
}
