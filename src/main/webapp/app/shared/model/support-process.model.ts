import { ISupport } from '@/shared/model/support.model';

export interface ISupportProcess {
  id?: number;
  processInstance?: any | null;
  support?: ISupport | null;
}

export class SupportProcess implements ISupportProcess {
  constructor(public id?: number, public processInstance?: any | null, public support?: ISupport | null) {}
}
