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

  constructor(private adminService: AdminService) {}

  ngOnInit(): void {
    this.load();
  }

  load() {
    this.adminService.getAll().subscribe(data => {
      this.notifications = data;
    });
  }

  save() {
    this.adminService.save(this.notification).subscribe(() => {
      this.resetForm();
      this.load();
    });
  }

  edit(n: Notification) {
    this.notification = { ...n };
  }

  delete(id: number) {
    this.adminService.delete(id).subscribe(() => {
      this.load();
    });
  }

  activate(id: number) {
    this.adminService.activate(id).subscribe(() => {
      this.load();
    });
  }

  resetForm() {
    this.notification = {
      title: '',
      content: '',
      active: false
    };
  }
}