import { Component, OnInit, signal } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ActivatedRoute, RouterLink } from '@angular/router';
import { FormsModule } from '@angular/forms';
import { ApiService } from '../../services/api.service';
import { User } from '../../models/user.model';
import { Skill, CreateSkillRequest } from '../../models/skill.model';

@Component({
  selector: 'app-user-profile',
  imports: [CommonModule, RouterLink, FormsModule],
  templateUrl: './user-profile.html',
  styleUrl: './user-profile.scss'
})
export class UserProfileComponent implements OnInit {
  user = signal<User | null>(null);
  offeredSkills = signal<Skill[]>([]);
  requestedSkills = signal<Skill[]>([]);
  showAddOffered = signal(false);
  showAddRequested = signal(false);
  loading = signal(false);
  error = signal<string | null>(null);

  newOfferedSkill = signal<CreateSkillRequest>({
    skillName: '',
    description: '',
    userId: 0
  });

  newRequestedSkill = signal<CreateSkillRequest>({
    skillName: '',
    description: '',
    userId: 0
  });

  constructor(
    private route: ActivatedRoute,
    private apiService: ApiService
  ) {}

  ngOnInit() {
    const userId = Number(this.route.snapshot.paramMap.get('id'));
    if (userId) {
      this.loadUserProfile(userId);
    }
  }

  loadUserProfile(userId: number) {
    this.loading.set(true);
    this.error.set(null);
    this.apiService.getUser(userId).subscribe({
      next: (user) => {
        this.user.set(user);
        this.newOfferedSkill.update(skill => ({ ...skill, userId }));
        this.newRequestedSkill.update(skill => ({ ...skill, userId }));
        this.loading.set(false);
      },
      error: (error) => {
        this.error.set('Error loading user profile.');
        this.loading.set(false);
      }
    });

    this.apiService.getUserOfferedSkills(userId).subscribe({
      next: (skills) => this.offeredSkills.set(skills),
      error: (error) => this.error.set('Error loading offered skills.')
    });

    this.apiService.getUserRequestedSkills(userId).subscribe({
      next: (skills) => this.requestedSkills.set(skills),
      error: (error) => this.error.set('Error loading requested skills.')
    });
  }

  addOfferedSkill() {
    if (!this.newOfferedSkill().skillName) {
      this.error.set('Skill name is required.');
      return;
    }
    this.loading.set(true);
    this.apiService.createOfferedSkill(this.newOfferedSkill()).subscribe({
      next: () => {
        this.loadUserProfile(this.user()!.id!);
        this.resetOfferedForm();
        this.loading.set(false);
      },
      error: (error) => {
        this.error.set('Error adding offered skill.');
        this.loading.set(false);
      }
    });
  }

  addRequestedSkill() {
    if (!this.newRequestedSkill().skillName) {
      this.error.set('Skill name is required.');
      return;
    }
    this.loading.set(true);
    this.apiService.createRequestedSkill(this.newRequestedSkill()).subscribe({
      next: () => {
        this.loadUserProfile(this.user()!.id!);
        this.resetRequestedForm();
        this.loading.set(false);
      },
      error: (error) => {
        this.error.set('Error adding requested skill.');
        this.loading.set(false);
      }
    });
  }

  resetOfferedForm() {
    this.newOfferedSkill.update(skill => ({ 
      ...skill, 
      skillName: '', 
      description: '' 
    }));
    this.showAddOffered.set(false);
  }

  resetRequestedForm() {
    this.newRequestedSkill.update(skill => ({ 
      ...skill, 
      skillName: '', 
      description: '' 
    }));
    this.showAddRequested.set(false);
  }
}