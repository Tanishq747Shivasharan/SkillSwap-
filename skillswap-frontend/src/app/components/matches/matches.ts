import { Component, OnInit, signal } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ActivatedRoute, RouterLink } from '@angular/router';
import { ApiService } from '../../services/api.service';
import { MatchResult } from '../../models/skill.model';
import { User } from '../../models/user.model';

@Component({
  selector: 'app-matches',
  imports: [CommonModule, RouterLink],
  templateUrl: './matches.html',
  styleUrl: './matches.scss'
})
export class MatchesComponent implements OnInit {
  matches = signal<MatchResult[]>([]);
  user = signal<User | null>(null);
  users = signal<User[]>([]);
  loading = signal(true);
  error = signal<string | null>(null);

  constructor(
    private route: ActivatedRoute,
    private apiService: ApiService
  ) {}

  ngOnInit() {
    const userId = Number(this.route.snapshot.paramMap.get('userId'));
    if (userId) {
      this.loadMatches(userId);
      this.loadUser(userId);
      this.loadAllUsers();
    }
  }

  loadMatches(userId: number) {
    this.loading.set(true);
    this.error.set(null);
    this.apiService.getMutualMatches(userId).subscribe({
      next: (matches) => {
        this.matches.set(matches);
        this.loading.set(false);
      },
      error: (error) => {
        this.error.set('Error loading matches.');
        this.loading.set(false);
      }
    });
  }

  loadUser(userId: number) {
    this.apiService.getUser(userId).subscribe({
      next: (user) => this.user.set(user),
      error: (error) => this.error.set('Error loading user.')
    });
  }

  loadAllUsers() {
    this.apiService.getUsers().subscribe({
      next: (users) => this.users.set(users),
      error: (error) => this.error.set('Error loading users.')
    });
  }

  getUserById(id: number): User | undefined {
    return this.users().find(user => user.id === id);
  }

  contactUser(userId: number) {
    const user = this.getUserById(userId);
    if (user?.email) {
      window.location.href = `mailto:${user.email}?subject=SkillSwap: Let's exchange skills!&body=Hi ${user.name},%0D%0A%0D%0AI found your profile on SkillSwap and I think we could help each other learn new skills!`;
    }
  }
}