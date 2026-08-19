import { HttpClient } from '@angular/common/http';
import { inject, Service } from '@angular/core';
import { Observable } from 'rxjs';

@Service()
export class Api {

  private http = inject(HttpClient);

  getUsers(): Observable<any[]> {
    return this.http.get<any[]>(
      'https://jsonplaceholder.typicode.com/users'
    );
  }
}