import axios from 'axios';

import { IMessage } from '@/shared/model/message.model';

const baseApiUrl = 'api/messages';

export default class MessageService {
  public find(id: number): Promise<IMessage> {
    return new Promise<IMessage>((resolve, reject) => {
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
