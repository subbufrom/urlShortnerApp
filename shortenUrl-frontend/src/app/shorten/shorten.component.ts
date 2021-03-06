import { Component } from '@angular/core';
import {CommonService} from "../common.service";


@Component({
  selector: 'app-about',
  templateUrl: './shorten.component.html',
  styleUrls: ['./shorten.component.css']
})
export class ShortenComponent {

  isavailable = false;
  constructor(
    private todoService: CommonService,
  ) { }
  resultData;
  createUrl(id:String) {
    let value = JSON.stringify(id);
    let shortUrl = JSON.parse(value).url;
    if(!shortUrl) {
      this.resultData = "Please enter the url...."
      this.isavailable = true;
    } else {
      this.todoService.sendData(id).toPromise()
      .then(response => {
        let value = JSON.stringify(response);
        let shortUrl = JSON.parse(value).url;
        this.resultData = shortUrl;
        this.isavailable = true;
      }).catch(errors => {
        console.log(errors);
      });
    }
  }

  copyToClipboard(element) {
    console.log(element);
    
  }
  
}
