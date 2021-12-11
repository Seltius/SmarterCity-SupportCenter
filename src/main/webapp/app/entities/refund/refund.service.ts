import axios from 'axios';

import { IRefund } from '@/shared/model/refund.model';

const baseApiUrl = 'api/refunds';

export default class RefundService {
  public find(id: number): Promise<IRefund> {
    return new Promise<IRefund>((resolve, reject) => {
      axios
        .get(`${baseApiUrl}/${id}`)
        .then(res => {
          resolve(res.data);
        })
        .catch(err => {
          reject(err);
        });
    });
  }

  public retrieve(): Promise<any> {
    return new Promise<any>((resolve, reject) => {
      axios
        .get(baseApiUrl)
        .then(res => {
          resolve(res);
        })
        .catch(err => {
          reject(err);
        });
    });
  }
}
