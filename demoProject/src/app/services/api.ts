import { HttpClient } from '@angular/common/http';
import { inject, Service } from '@angular/core';
import { Observable } from 'rxjs';
import { Userr } from '../../modules/Userr';

@Service()
export class Api {

  private http = inject(HttpClient);

  getUsers(): Observable<any[]> {
    return this.http.get<any[]>(
      'https://jsonplaceholder.typicode.com/users'
    );
  }


    url="http://localhost:8080/api/users";

  register(user:Userr){
    return this.http.post(this.url,user);
  }
}