import axios from 'axios';
import { ProvideSupportResponseContext } from './provide-support-response.model';

const baseApiUrl = 'api/support-process/provide-support-response';

export default class ProvideSupportResponseService {
  public loadContext(taskId: number): Promise<ProvideSupportResponseContext> {
    return new Promise<ProvideSupportResponseContext>((resolve, reject) => {
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

  public claim(taskId: number): Promise<ProvideSupportResponseContext> {
    return new Promise<ProvideSupportResponseContext>((resolve, reject) => {
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

  public complete(provideSupportResponseContext: ProvideSupportResponseContext): Promise<any> {
    return new Promise<any>((resolve, reject) => {
      axios
        .post(`${baseApiUrl}/complete`, provideSupportResponseContext)
        .then(res => {
          resolve(res);
        })
        .catch(err => {
          reject(err);
        });
    });
  }
}
