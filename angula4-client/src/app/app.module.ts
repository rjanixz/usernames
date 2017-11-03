import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { HttpModule } from '@angular/http';

import { AppComponent } from './app.component';
import { UserListHeaderComponent } from './user-list-header/user-list-header.component';
import { UserListComponent } from './user-list/user-list.component';
import { UserListItemComponent } from './user-list-item/user-list-item.component';
import { UserListFooterComponent } from './user-list-footer/user-list-footer.component';

import { UserDataService } from './user-data.service';
import { ApiService } from './api.service';

@NgModule({
  declarations: [
    AppComponent,
    UserListHeaderComponent,
    UserListComponent,
    UserListItemComponent,
    UserListFooterComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpModule
  ],
  providers: [UserDataService, ApiService],
  bootstrap: [AppComponent]
})
export class AppModule { }
