import axios from 'axios';
import { ReadSupportResponseContext } from './read-support-response.model';

const baseApiUrl = 'api/support-process/read-support-response';

export default class ReadSupportResponseService {
  public loadContext(taskId: number): Promise<ReadSupportResponseContext> {
    return new Promise<ReadSupportResponseContext>((resolve, reject) => {
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

  public claim(taskId: number): Promise<ReadSupportResponseContext> {
    return new Promise<ReadSupportResponseContext>((resolve, reject) => {
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

  public complete(readSupportResponseContext: ReadSupportResponseContext): Promise<any> {
    return new Promise<any>((resolve, reject) => {
      axios
        .post(`${baseApiUrl}/complete`, readSupportResponseContext)
        .then(res => {
          resolve(res);
        })
        .catch(err => {
          reject(err);
        });
    });
  }
}
