import axios from 'axios';
import { FillRefundFormContext } from './fill-refund-form.model';

const baseApiUrl = 'api/refund-process/fill-refund-form';

export default class FillRefundFormService {
  public loadContext(taskId: number): Promise<FillRefundFormContext> {
    return new Promise<FillRefundFormContext>((resolve, reject) => {
      axios
        .get(`${baseApiUrl}/${taskId}`)
        .then(res => {
          resolve(res.data);
        })
        .catch(err => {
          reject(err);
        });
    });
  }

  public claim(taskId: number): Promise<FillRefundFormContext> {
    return new Promise<FillRefundFormContext>((resolve, reject) => {
      axios
        .get(`${baseApiUrl}/${taskId}/claim`)
        .then(res => {
          resolve(res.data);
        })
        .catch(err => {
          reject(err);
        });
    });
  }

  public complete(fillRefundFormContext: FillRefundFormContext): Promise<any> {
    return new Promise<any>((resolve, reject) => {
      axios
        .post(`${baseApiUrl}/complete`, fillRefundFormContext)
        .then(res => {
          resolve(res);
        })
        .catch(err => {
          reject(err);
        });
    });
  }
}
