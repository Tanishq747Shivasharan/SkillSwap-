import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { User, CreateUserRequest } from '../models/user.model';
import { Skill, CreateSkillRequest, MatchResult } from '../models/skill.model';

@Injectable({
  providedIn: 'root'
})
export class ApiService {
  private baseUrl = 'http://localhost:8082/api';

  constructor(private http: HttpClient) {}

  // User endpoints
  getUsers(): Observable<User[]> {
    return this.http.get<User[]>(`${this.baseUrl}/users`);
  }

  getUser(id: number): Observable<User> {
    return this.http.get<User>(`${this.baseUrl}/users/${id}`);
  }

  createUser(user: CreateUserRequest): Observable<User> {
    return this.http.post<User>(`${this.baseUrl}/users`, user);
  }

  // Skills endpoints
  getSkills(): Observable<Skill[]> {
    return this.http.get<Skill[]>(`${this.baseUrl}/skills`);
  }

  createSkill(skill: CreateSkillRequest): Observable<Skill> {
    return this.http.post<Skill>(`${this.baseUrl}/skills`, skill);
  }

  // Offered skills
  getOfferedSkills(): Observable<Skill[]> {
    return this.http.get<Skill[]>(`${this.baseUrl}/skills/offered`);
  }

  createOfferedSkill(skill: CreateSkillRequest): Observable<Skill> {
    return this.http.post<Skill>(`${this.baseUrl}/skills/offered`, skill);
  }

  getUserOfferedSkills(userId: number): Observable<Skill[]> {
    return this.http.get<Skill[]>(`${this.baseUrl}/skills/offered/user/${userId}`);
  }

  // Requested skills
  getRequestedSkills(): Observable<Skill[]> {
    return this.http.get<Skill[]>(`${this.baseUrl}/skills/requested`);
  }

  createRequestedSkill(skill: CreateSkillRequest): Observable<Skill> {
    return this.http.post<Skill>(`${this.baseUrl}/skills/requested`, skill);
  }

  getUserRequestedSkills(userId: number): Observable<Skill[]> {
    return this.http.get<Skill[]>(`${this.baseUrl}/skills/requested/user/${userId}`);
  }

  // Matching
  getMutualMatches(userId: number): Observable<MatchResult[]> {
    return this.http.get<MatchResult[]>(`${this.baseUrl}/skills/match/${userId}`);
  }
}