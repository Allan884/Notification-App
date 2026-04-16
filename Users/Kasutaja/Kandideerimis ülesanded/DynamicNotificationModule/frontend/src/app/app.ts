import { Component, signal, inject } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { NgIf } from '@angular/common';
import { NotificationService } from './notification.service';

@Component({
  selector: 'app-root',
  imports: [RouterOutlet, NgIf],
  templateUrl: './app.html',
  styleUrl: './app.css'
})
export class App {
  private service = inject(NotificationService);

  notification = signal<any>(null);

  constructor() {
    this.service.getNotification().subscribe(data => {
      console.log("Backend response:", data);
      this.notification.set(data);
    });
  }
}
