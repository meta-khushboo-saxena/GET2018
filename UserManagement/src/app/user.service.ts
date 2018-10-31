import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';

import { Observable, of } from 'rxjs';
import { catchError, map, tap } from 'rxjs/operators';

import { User } from './user';

const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};

@Injectable({
  providedIn: 'root'
})

export class UserService {

  private usersUrl: string = 'http://localhost:3000/users/';

  constructor(private http: HttpClient) { }

  /** GET users from the server */
  getUsers(): Observable<User[]> {
    return this.http.get<User[]>(this.usersUrl);
  }

  /** PUT: update the hero on the server */
  updateUser(user: User): Observable<any> {
    return this.http.put(`${this.usersUrl}/${user.id}`, user, httpOptions);
  }

  /** POST: add a new user to the server */
  addUser(user: User): Observable<User> {
    return this.http.post<User>(this.usersUrl, user, httpOptions);
  }

  /* GET heroes whose name contains search term */
  searchUsers(term: string): Observable<User[]> {
    //alert(term);
    if (!term.trim()) {
      // if not search term, return empty hero array.
      return this.http.get<User[]>(this.usersUrl);
    }
    return this.http.get<User[]>(`${this.usersUrl}/?name=${term}`);
  }

  getUserById(id: number): Observable<User> {
    return this.http.get<User>(`${this.usersUrl}/${id}`);
  }


}
