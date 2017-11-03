import { Injectable } from '@angular/core';
import { User } from './user';
import { ApiService } from './api.service';
import { Observable } from 'rxjs/Observable';

@Injectable()
export class UserDataService {

  // placeholder for last id to simulate automatic incremnting of id's
  lastId: number = 0;

  // placeholder for users
  users: User[] = [];

  constructor(
    private api: ApiService
  ) { }

  addUser(user: User): Observable<User> {
    return this.api.createUser(user);
  }
  
  deleteUserById(id: number): Observable<User> {
    return this.api.deleteUserById(id);
  }

  getAllUsers(): Observable<User[]> {
    return this.api.getAllUsers();
  }

  getUserById(id: number): Observable<User> {
    return this.api.getUserById(id);
  }
}
