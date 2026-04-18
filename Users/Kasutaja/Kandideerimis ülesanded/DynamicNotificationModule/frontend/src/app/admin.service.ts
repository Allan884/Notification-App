import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

export interface Notification {
  id?: number;
  title: string;
  content: string;
  active: boolean;
}

@Injectable({
  providedIn: 'root',
})
export class AdminService {

  private baseUrl = 'http://localhost:8080/api/admin/notification';

  constructor(private http: HttpClient) {}

  getAll(): Observable<Notification[]> {
    return this.http.get<Notification[]>(this.baseUrl);
  }
  
  create(notification: Notification): Observable<Notification> {
    return this.http.post<Notification>(this.baseUrl, notification);
  }

  update(id: number, notification: Notification): Observable<Notification> {
    return this.http.put<Notification>(`${this.baseUrl}/${id}`, notification);
  }

  delete(id: number): Observable<void> {
    return this.http.delete<void>(`${this.baseUrl}/${id}`);
  }

  activate(id: number): Observable<void> {
    return this.http.post<void>(`${this.baseUrl}/${id}/activate`, {});
  }
}