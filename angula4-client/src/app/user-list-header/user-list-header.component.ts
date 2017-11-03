import { Component, Output, EventEmitter } from '@angular/core';
import { User } from '../user';

@Component({
  selector: 'app-user-list-header',
  templateUrl: './user-list-header.component.html',
  styleUrls: ['./user-list-header.component.css']
})
export class UserListHeaderComponent {

  newUser: User = new User();

  @Output()
  add: EventEmitter<User> = new EventEmitter();

  constructor() { }

  addUser() {
    this.add.emit(this.newUser);
    this.newUser = new User();
  }
}
