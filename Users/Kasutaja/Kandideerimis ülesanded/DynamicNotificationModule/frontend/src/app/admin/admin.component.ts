import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { AdminService, Notification } from '../admin.service';

@Component({
  selector: 'app-admin',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './admin.html',
  styleUrl: './admin.css',
})
export class AdminComponent implements OnInit {

  notifications: Notification[] = [];

  notification: Notification = {
    title: '',
    content: '',
    active: false
  };

  errorMessage: string = '';

  constructor(private adminService: AdminService) {}

  ngOnInit(): void {
    this.load();
  }

  load() {
    this.adminService.getAll().subscribe({next: (data) => {
      this.notifications = data;
    },
    error: (err) => {
      console.error('LOAD FAILED', err);
    }
    });
  }

  createOrUpdate() {

    if (!this.notification.title || this.notification.title.trim() === '') {
      this.errorMessage = 'Title is required';
      return;
    }

    const request = this.notification.id
      ? this.adminService.update(this.notification.id, this.notification)
      : this.adminService.create(this.notification);

    request.subscribe({
      next: () => {
        this.errorMessage = '';
        this.resetForm();
        this.load();
      },
      error: err => {
        console.error(err);
        this.errorMessage = err.error?.message || 'Error occurred';
      }
    });
  }


  edit(n: Notification) {
    this.notification = { ...n };
  }

  delete(id: number) {
    this.adminService.delete(id).subscribe(() => this.load());
  }

  setActive(id: number) {
    this.adminService.activate(id).subscribe(() => this.load());
  }

  deactivate(id: number) {
  this.adminService.deactivate(id).subscribe(() => this.load());
}

  resetForm() {
    this.notification = {
      title: '',
      content: '',
      active: false,
      id: undefined
    };
  }
}