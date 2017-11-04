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
import { RestrictedWordDataService } from './restricted-word-data.service';
import { ApiService } from './api.service';
import { RestrictedWordListComponent } from './restricted-word-list/restricted-word-list.component';
import { AppRoutingModule } from './app-routing.module';
import { UsersComponent } from './users/users.component';
import { RestrictedWordListFooterComponent } from './restricted-word-list-footer/restricted-word-list-footer.component';
import { RestrictedWordListHeaderComponent } from './restricted-word-list-header/restricted-word-list-header.component';
import { RestrictedWordListItemComponent } from './restricted-word-list-item/restricted-word-list-item.component';
import { RestrictedWordsComponent } from './restricted-words/restricted-words.component';
import { SuggestionListComponent } from './suggestion-list/suggestion-list.component';

@NgModule({
  declarations: [
    AppComponent,
    // Users components
    UserListComponent,
    UserListItemComponent,
    UserListHeaderComponent,
    UserListFooterComponent,
    UsersComponent,
    // Restricted Words components
    RestrictedWordListComponent,
    RestrictedWordListItemComponent,
    RestrictedWordListHeaderComponent,
    RestrictedWordListFooterComponent,
    RestrictedWordsComponent,
    SuggestionListComponent
  ],
  imports: [
    AppRoutingModule,
    BrowserModule,
    FormsModule,
    HttpModule
  ],
  providers: [UserDataService, RestrictedWordDataService, ApiService],
  bootstrap: [AppComponent]
})
export class AppModule { }
