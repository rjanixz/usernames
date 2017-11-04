import { Component, EventEmitter, Input, Output } from '@angular/core';
import { User } from '../user';

@Component({
  selector: 'app-user-list',
  templateUrl: './user-list.component.html',
  styleUrls: ['./user-list.component.css']
})
export class UserListComponent {

  @Input()
  users: User[];

  @Input()
  suggestions: string[];

  @Output()
  remove: EventEmitter<User> = new EventEmitter();

  constructor() { }

  onRemoveUser(user: User) {
    this.remove.emit(user);
  }

}
