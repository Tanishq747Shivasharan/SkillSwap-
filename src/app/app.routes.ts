import { Routes } from '@angular/router';
import { UserListComponent } from './components/user-list/user-list';
import { UserProfileComponent } from './components/user-profile/user-profile';
import { SkillMarketplaceComponent } from './components/skill-marketplace/skill-marketplace';
import { MatchesComponent } from './components/matches/matches';

export const routes: Routes = [
  { path: '', redirectTo: '/users', pathMatch: 'full' },
  { path: 'users', component: UserListComponent },
  { path: 'users/:id', component: UserProfileComponent },
  { path: 'marketplace', component: SkillMarketplaceComponent },
  { path: 'matches/:userId', component: MatchesComponent }
];
