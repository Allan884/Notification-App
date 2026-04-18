import { Component, signal, inject } from '@angular/core';
import { CommonModule, DatePipe } from '@angular/common';
import { RouterOutlet, RouterLink } from '@angular/router';
import { NotificationService } from './notification.service';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [CommonModule, DatePipe, RouterOutlet, RouterLink],
  templateUrl: './app.html',
  styleUrl: './app.css'
})
export class App {
  private service = inject(NotificationService);

  notification = signal<any>(null);

  constructor() {
    this.service.getNotification().subscribe(data => {
      this.notification.set(data);
    });
  }
}