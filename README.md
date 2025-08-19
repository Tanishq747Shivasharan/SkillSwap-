# SkillSwap

A modern skill-sharing platform where users can offer their expertise and find learning opportunities through mutual skill exchanges.

## 🚀 Features

- **User Management**: Create and manage user profiles with skills and locations
- **Skill Marketplace**: Browse skills offered and requested by the community
- **Smart Matching**: Find mutual learning opportunities where you can teach and learn
- **Real-time Updates**: Modern Angular frontend with responsive design
- **RESTful API**: Spring Boot backend with comprehensive API documentation

## 🏗️ Architecture

### Backend (Spring Boot)
- **Framework**: Spring Boot 3.5.4 with Java 17
- **Database**: H2 (development) / PostgreSQL (production)
- **API Documentation**: OpenAPI 3 with Swagger UI
- **Features**: JPA repositories, validation, CORS support

### Frontend (Angular)
- **Framework**: Angular 19 with TypeScript
- **Styling**: SCSS with modern responsive design
- **State Management**: Angular Signals (zoneless)
- **HTTP Client**: Angular HttpClient with RxJS

## 🛠️ Getting Started

### Prerequisites
- Java 17+
- Node.js 18+
- Maven 3.6+

### Backend Setup
```bash
cd skillswap-backend
./mvnw spring-boot:run
```
The backend will start on `http://localhost:8082`

### Frontend Setup
```bash
cd skillswap-frontend
npm install
ng serve
```
The frontend will start on `http://localhost:4200`

## 📚 API Documentation

Once the backend is running, visit:
- **Swagger UI**: http://localhost:8082/swagger-ui/index.html
- **H2 Console**: http://localhost:8082/h2-console (development only)

## 🎯 Core Functionality

### Skill Matching Algorithm
The platform features a sophisticated mutual matching system:
- User A offers Skill X and wants Skill Y
- User B offers Skill Y and wants Skill X
- System identifies this as a perfect mutual match

### Key Endpoints
- `GET /api/users` - List all users
- `POST /api/users` - Create new user
- `GET /api/skills/offered` - Browse offered skills
- `GET /api/skills/requested` - Browse skill requests
- `GET /api/skills/match/{userId}` - Find mutual matches

## 🔧 Development

### Database Schema
```sql
-- Users table
CREATE TABLE users (
    id BIGSERIAL PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    email VARCHAR(150) NOT NULL UNIQUE,
    location VARCHAR(100)
);

-- Skills offered by users
CREATE TABLE skill_offered (
    id BIGSERIAL PRIMARY KEY,
    user_id BIGINT NOT NULL,
    skill_name VARCHAR(100) NOT NULL,
    description TEXT,
    FOREIGN KEY (user_id) REFERENCES users(id)
);

-- Skills requested by users
CREATE TABLE skill_requested (
    id BIGSERIAL PRIMARY KEY,
    user_id BIGINT NOT NULL,
    skill_name VARCHAR(100) NOT NULL,
    description TEXT,
    FOREIGN KEY (user_id) REFERENCES users(id)
);
```

### Sample Data
The application includes sample users and skills for development:
- Alice Smith (Java, Database Design) ↔ (Python Data Science)
- Bob Johnson (React Development) ↔ (Backend Development)
- Charlie Brown (Cloud Computing) ↔ (Mobile App Development)

## 🚀 Deployment

### Backend
- Configure PostgreSQL connection in `application.properties`
- Set `spring.profiles.active=production`
- Build with `./mvnw clean package`

### Frontend
- Build with `ng build --configuration production`
- Deploy `dist/` folder to web server
- Update API base URL for production

## 🤝 Contributing

1. Fork the repository
2. Create a feature branch (`git checkout -b feature/amazing-feature`)
3. Commit your changes (`git commit -m 'Add amazing feature'`)
4. Push to the branch (`git push origin feature/amazing-feature`)
5. Open a Pull Request

## 📝 License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

## 🙏 Acknowledgments

- Spring Boot team for the excellent framework
- Angular team for the modern frontend framework
- H2 Database for easy development setup