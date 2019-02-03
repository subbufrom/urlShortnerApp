import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable()
export class CommonService {
  apiURL: string = 'http://localhost:8080/eatable/data/short?url=';
  getUrl: string = 'http://localhost:8080/eatable/data/';

  constructor(private httpClient: HttpClient) {}

  public sendData(data) {
    return this.httpClient.post(this.apiURL+data.url,{});
  }

  public getUrlData() {
    return this.httpClient.get(this.getUrl);
  }
}