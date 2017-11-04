import { Injectable } from '@angular/core';
import { User } from './user';
import { Result } from './result';
import { ApiService } from './api.service';
import { Observable } from 'rxjs/Observable';

@Injectable()
export class UserDataService {

  constructor(
    private api: ApiService
  ) { }

  addUser(user: User): Observable<Result> {
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
