import { Component } from '@angular/core';
import { ApiService } from './api.service';
import { User } from './user';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css'],
  providers: []
})
export class AppComponent {

  constructor(
    private apiService: ApiService
  ) {

  }

  onAddUser(user: User) {
    this.apiService.addUser(user);
  }

  onRemoveUser(user) {
    this.apiService.deleteUserById(user.id);
  }

  get users() {
    return this.apiService.getAllUsers();
  }
}
