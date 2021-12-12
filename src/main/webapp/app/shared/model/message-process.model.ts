import { IMessage } from '@/shared/model/message.model';

export interface IMessageProcess {
  id?: number;
  processInstance?: any | null;
  message?: IMessage | null;
}

export class MessageProcess implements IMessageProcess {
  constructor(public id?: number, public processInstance?: any | null, public message?: IMessage | null) {}
}
