import { Component, Input } from '@angular/core';
import { User } from '../user';

@Component({
  selector: 'app-user-list-footer',
  templateUrl: './user-list-footer.component.html',
  styleUrls: ['./user-list-footer.component.css']
})
export class UserListFooterComponent {

  @Input()
  users: User[];

  constructor() { }

}
