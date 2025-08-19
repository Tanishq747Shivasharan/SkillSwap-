export interface User {
  id?: number;
  name: string;
  email: string;
  location?: string;
}

export interface CreateUserRequest {
  name: string;
  email: string;
  location?: string;
}