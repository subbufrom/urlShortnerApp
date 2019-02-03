import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { FormsModule }   from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { AppComponent } from './app.component';
import {ShortenComponent} from './shorten/shorten.component';
import {TableViewComponent} from './tableView/tableView.component';
import {  RouterModule } from '@angular/router';
import { ClipboardModule } from 'ngx-clipboard';
import { HeaderComponent } from './header.component';
import { CommonService } from './common.service';
import { MatTableModule } from  '@angular/material';

import { ReactiveFormsModule } from '@angular/forms';

@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    ShortenComponent,
    TableViewComponent
  ],
  imports: [
    BrowserModule,
    ReactiveFormsModule,
    FormsModule,
    HttpClientModule,
    ClipboardModule,
    MatTableModule,
    RouterModule.forRoot([
      {
        path: '',
        component: ShortenComponent
      },
      {
        path: 'search',
        component: ShortenComponent
      },
      {
        path: 'list',
        component: TableViewComponent
      }
    ])
  ],
  providers: [CommonService],
  bootstrap: [AppComponent]
})
export class AppModule {}