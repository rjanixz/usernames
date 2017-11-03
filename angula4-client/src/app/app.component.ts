import { Component } from '@angular/core';
import { ApiService } from './api.service';
import { User } from './user';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css'],
  providers: [ApiService]
})
export class AppComponent {

  newUser: User = new User();

  constructor(
    private apiService: ApiService
  ) {

  }

  addUser() {
    this.apiService.addUser(this.newUser);
    this.newUser = new User();
  }

  removeUser(user) {
    this.apiService.deleteUserById(user.id);
  }

  get users() {
    return this.apiService.getAllUsers();
  }
}
