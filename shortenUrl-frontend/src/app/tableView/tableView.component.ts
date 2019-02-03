import { Component, OnInit } from '@angular/core';
import {CommonService} from "../common.service";

@Component({
  selector: 'app-news',
  templateUrl: './tableView.component.html',
  styleUrls: ['./tableView.component.css']
})
export class TableViewComponent implements OnInit {

  listOfShorUrls;
  displayedColumns: string[] = ['shorUrl','originalUrl', 'hits'];
  dataSource;
  
  constructor(private todoService:CommonService) { }

  ngOnInit() {
    this.todoService.getUrlData().toPromise()
    .then(result => {
      this.dataSource = result;
    })
  }
}
