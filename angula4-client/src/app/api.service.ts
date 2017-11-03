import { Injectable } from '@angular/core';
import { User } from './user';

@Injectable()
export class ApiService {

  // placeholder for last id to simulate automatic incremnting of id's
  lastId: number = 0;

  // placeholder for users
  users: User[] = [];

  constructor() { }

  addUser(user: User): ApiService {
    if (!user.id) {
      user.id = ++this.lastId;
    }
    this.users.push(user);
    return this;
  }
  
  deleteUserById(id: number, values: Object = {}): User {
    let user =  this.getUserById(id);
    if(!user) {
      return null;
    }
    Object.assign(user, values);
    return user;
  }

  getAllUsers(): User[] {
    return this.users;
  }

  getUserById(id: number): User {
    return this.users
      .filter(user => user.id === id)
      .pop();
  }
}
