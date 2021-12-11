import axios from 'axios';

import { ISupport } from '@/shared/model/support.model';

const baseApiUrl = 'api/supports';

export default class SupportService {
  public find(id: number): Promise<ISupport> {
    return new Promise<ISupport>((resolve, reject) => {
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
