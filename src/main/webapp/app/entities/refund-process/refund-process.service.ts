import axios from 'axios';

import { IRefundProcess } from '@/shared/model/refund-process.model';

const baseApiUrl = 'api/refund-processes';

export default class RefundProcessService {
  public find(id: number): Promise<IRefundProcess> {
    return new Promise<IRefundProcess>((resolve, reject) => {
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

  public create(entity: IRefundProcess): Promise<IRefundProcess> {
    return new Promise<IRefundProcess>((resolve, reject) => {
      axios
        .post(`${baseApiUrl}`, entity)
        .then(res => {
          resolve(res.data);
        })
        .catch(err => {
          reject(err);
        });
    });
  }
}
