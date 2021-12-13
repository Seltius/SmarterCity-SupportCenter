import axios from 'axios';
import { AnalyseRefundRequestContext } from './analyse-refund-request.model';

const baseApiUrl = 'api/support-process/analyse-refund-request';

export default class AnalyseRefundRequestService {
  public loadContext(taskId: number): Promise<AnalyseRefundRequestContext> {
    return new Promise<AnalyseRefundRequestContext>((resolve, reject) => {
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

  public claim(taskId: number): Promise<AnalyseRefundRequestContext> {
    return new Promise<AnalyseRefundRequestContext>((resolve, reject) => {
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

  public complete(analyseRefundRequestContext: AnalyseRefundRequestContext): Promise<any> {
    return new Promise<any>((resolve, reject) => {
      axios
        .post(`${baseApiUrl}/complete`, analyseRefundRequestContext)
        .then(res => {
          resolve(res);
        })
        .catch(err => {
          reject(err);
        });
    });
  }
}
