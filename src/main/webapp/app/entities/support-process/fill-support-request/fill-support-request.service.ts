import axios from 'axios';
import { FillSupportRequestContext } from './fill-support-request.model';

const baseApiUrl = 'api/support-process/fill-support-request';

export default class FillSupportRequestService {
  public loadContext(taskId: number): Promise<FillSupportRequestContext> {
    return new Promise<FillSupportRequestContext>((resolve, reject) => {
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

  public claim(taskId: number): Promise<FillSupportRequestContext> {
    return new Promise<FillSupportRequestContext>((resolve, reject) => {
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

  public complete(fillSupportRequestContext: FillSupportRequestContext): Promise<any> {
    return new Promise<any>((resolve, reject) => {
      axios
        .post(`${baseApiUrl}/complete`, fillSupportRequestContext)
        .then(res => {
          resolve(res);
        })
        .catch(err => {
          reject(err);
        });
    });
  }
}
