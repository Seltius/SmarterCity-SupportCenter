export interface IMessage {
  id?: number;
  supportId?: number | null;
  date?: Date | null;
  messageType?: string | null;
  value?: string | null;
}

export class Message implements IMessage {
  constructor(
    public id?: number,
    public supportId?: number | null,
    public date?: Date | null,
    public messageType?: string | null,
    public value?: string | null
  ) {}
}
