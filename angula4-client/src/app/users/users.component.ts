import { Component, OnInit } from '@angular/core';
import { UserDataService } from '../user-data.service';
import { User } from '../user';

@Component({
  selector: 'app-users',
  templateUrl: './users.component.html',
  styleUrls: ['./users.component.css'],
  providers: [UserDataService]
})
export class UsersComponent implements OnInit {

  users: User[] = [];

  constructor(
    private userDataService: UserDataService
  ) { }

  public ngOnInit() {
    this.userDataService
      .getAllUsers()
      .subscribe(
        (users) => {
          this.users = users;
        }
      );
  }

  onAddUser(user) {
    this.userDataService
      .addUser(user)
      .subscribe(
        (newUser) => {
          this.users = this.users.concat(newUser)
        }
      );
  }

  onRemoveUser(user) {
    this.userDataService
      .deleteUserById(user.id)
      .subscribe(
        (_) => {
          this.users = this.users.filter((u) => u.id !== user.id);
        }
      );
  }
}
