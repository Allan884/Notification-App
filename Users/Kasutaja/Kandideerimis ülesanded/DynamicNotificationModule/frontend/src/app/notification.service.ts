import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class NotificationService {

  private apiUrl = 'http://localhost:8080/api/notification';

  constructor(private http: HttpClient) {}

  getNotification(): Observable<any> {
    console.log("Calling backend...")
    return this.http.get(this.apiUrl);
  }
}