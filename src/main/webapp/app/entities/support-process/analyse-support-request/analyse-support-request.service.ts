import axios from 'axios';
import { AnalyseSupportRequestContext } from './analyse-support-request.model';

const baseApiUrl = 'api/support-process/analyse-support-request';

export default class AnalyseSupportRequestService {
  public loadContext(taskId: number): Promise<AnalyseSupportRequestContext> {
    return new Promise<AnalyseSupportRequestContext>((resolve, reject) => {
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

  public claim(taskId: number): Promise<AnalyseSupportRequestContext> {
    return new Promise<AnalyseSupportRequestContext>((resolve, reject) => {
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

  public complete(analyseSupportRequestContext: AnalyseSupportRequestContext): Promise<any> {
    return new Promise<any>((resolve, reject) => {
      axios
        .post(`${baseApiUrl}/complete`, analyseSupportRequestContext)
        .then(res => {
          resolve(res);
        })
        .catch(err => {
          reject(err);
        });
    });
  }
}
