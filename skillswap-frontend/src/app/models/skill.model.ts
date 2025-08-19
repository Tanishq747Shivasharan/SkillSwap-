export interface Skill {
  id?: number;
  skillName: string;
  description?: string;
  userId?: number;
  user?: {
    id: number;
    name: string;
    email: string;
    location?: string;
  };
}

export interface CreateSkillRequest {
  skillName: string;
  description?: string;
  userId: number;
}

export interface MatchResult {
  userAId: number;
  userBId: number;
  skillAOffers_BWants: string;
  skillBOffers_AWants: string;
}