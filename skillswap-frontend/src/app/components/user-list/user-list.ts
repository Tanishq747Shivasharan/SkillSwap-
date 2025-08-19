import { Component, OnInit, signal } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterLink } from '@angular/router';
import { FormsModule } from '@angular/forms';
import { ApiService } from '../../services/api.service';
import { User, CreateUserRequest } from '../../models/user.model';

@Component({
  selector: 'app-user-list',
  imports: [CommonModule, RouterLink, FormsModule],
  templateUrl: './user-list.html',
  styleUrl: './user-list.scss'
})
export class UserListComponent implements OnInit {
  users = signal<User[]>([]);
  showCreateForm = signal(false);
  newUser = signal<CreateUserRequest>({
    name: '',
    email: '',
    location: ''
  });
  loading = signal(false);
  error = signal<string | null>(null);

  constructor(private apiService: ApiService) {}

  ngOnInit() {
    this.loadUsers();
  }

  loadUsers() {
    this.loading.set(true);
    this.error.set(null);
    this.apiService.getUsers().subscribe({
      next: (users) => {
        this.users.set(users);
        this.loading.set(false);
      },
      error: (error) => {
        this.error.set('Error loading users.');
        this.loading.set(false);
      }
    });
  }

  createUser() {
    if (!this.newUser().name) {
      this.error.set('Name is required.');
      return;
    }
    if (!this.newUser().email) {
      this.error.set('Email is required.');
      return;
    }
    this.loading.set(true);
    this.apiService.createUser(this.newUser()).subscribe({
      next: () => {
        this.loadUsers();
        this.resetForm();
        this.loading.set(false);
      },
      error: (error) => {
        this.error.set('Error creating user.');
        this.loading.set(false);
      }
    });
  }

  resetForm() {
    this.newUser.set({ name: '', email: '', location: '' });
    this.showCreateForm.set(false);
  }
}