# SkillSwap

A modern skill-sharing platform where users can offer their expertise and find learning opportunities through mutual skill exchanges.

## Features

- **User Management**: Create and manage user profiles with skills and locations
- **Skill Marketplace**: Browse skills offered and requested by the community
- **Smart Matching**: Find mutual learning opportunities where you can teach and learn
- **Real-time Updates**: Modern Angular frontend with responsive design
- **RESTful API**: Spring Boot backend with comprehensive API documentation

## Architecture

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

## Getting Started

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

## API Documentation

Once the backend is running, visit:
- **Swagger UI**: http://localhost:8082/swagger-ui/index.html
- **H2 Console**: http://localhost:8082/h2-console (development only)

## Core Functionality

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

## Development

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

### Springboot Created pom.xml file dependancies
```
<dependencies>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-data-jpa</artifactId>
		</dependency>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-web</artifactId>
		</dependency>
		<!-- Used to Automatically validate request bodies or DTO's -->
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-validation</artifactId>
		</dependency>

		<dependency>
			<groupId>org.postgresql</groupId>
			<artifactId>postgresql</artifactId>
			<scope>runtime</scope>
		</dependency>
		<!-- H2 Database for development -->
		<dependency>
			<groupId>com.h2database</groupId>
			<artifactId>h2</artifactId>
			<scope>runtime</scope>
		</dependency>
		<!-- Used to test API without using Postman
		 Used Swagger UI instead -->
		<dependency>
			<groupId>org.springdoc</groupId>
			<artifactId>springdoc-openapi-starter-webmvc-ui</artifactId>
			<version>2.8.9</version>
		</dependency>

		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-test</artifactId>
			<scope>test</scope>
		</dependency>
	</dependencies>
```

### Sample Data
The application includes sample users and skills for development:
- Telusko (Java, Database Design) ↔ (Python Data Science)
- Eren (React Development) ↔ (Backend Development)
- Tanishq (Cloud Computing) ↔ (Mobile App Development)

## Deployment

### Backend
- Configure PostgreSQL connection in `application.properties`
- Set `spring.profiles.active=production`
- Build with `./mvnw clean package`

### Frontend
- Build with `ng build --configuration production`
- Deploy `dist/` folder to web server
- Update API base URL for production

## ScreenShots

### Main UI
#### Onboarding new user instructions for using the web application...
![Onboarding](https://github.com/Tanishq747Shivasharan/SkillSwap-/blob/main/SkillSwap%20images/Screenshot%202025-08-19%20094022.png)
#### Users section
![Users](https://github.com/Tanishq747Shivasharan/SkillSwap-/blob/main/SkillSwap%20images/Screenshot%202025-08-19%20094424.png)
#### Marketplace section
![Market place](https://github.com/Tanishq747Shivasharan/SkillSwap-/blob/main/SkillSwap%20images/Screenshot%202025-08-19%20094444.png)
#### Adding new skill to sample user Eren
![Sample user Eren](https://github.com/Tanishq747Shivasharan/SkillSwap-/blob/main/SkillSwap%20images/Screenshot%202025-08-19%20095120.png)
#### As you can see new skill has been added successfully on the add skill section of the sample user Eren now adding new skill request to the sample user Eren...
![Added new skill to Eren](https://github.com/Tanishq747Shivasharan/SkillSwap-/blob/main/SkillSwap%20images/Screenshot%202025-08-19%20095215.png)
#### No user is teaching Swift so no mutual finding for that perticular skill...
![Skill finder](https://github.com/Tanishq747Shivasharan/SkillSwap-/blob/main/SkillSwap%20images/Screenshot%202025-08-19%20095256.png)
#### Added new skill by Eren reflected to marketplace, in skill offered section
![Added new skill by Eren reflected to marketplace, in skill offered section](https://github.com/Tanishq747Shivasharan/SkillSwap-/blob/main/SkillSwap%20images/Screenshot%202025-08-19%20095330.png)
#### Request skill by Eren reflected to marketplace, in skill requested section
![Request skill by Eren reflected to marketplace, in skill requested section](https://github.com/Tanishq747Shivasharan/SkillSwap-/blob/main/SkillSwap%20images/Screenshot%202025-08-19%20095341.png)
#### Creating a new user
![Creating a new user](https://github.com/Tanishq747Shivasharan/SkillSwap-/blob/main/SkillSwap%20images/Screenshot%202025-08-19%20095402.png)
#### Adding new user Nami
![Adding new user Nami](https://github.com/Tanishq747Shivasharan/SkillSwap-/blob/main/SkillSwap%20images/Screenshot%202025-08-19%20095456.png)
#### Added Nami as a new user
![Added Nami as a new user](https://github.com/Tanishq747Shivasharan/SkillSwap-/blob/main/SkillSwap%20images/Screenshot%202025-08-19%20095510.png)
#### Nither skill and nor requested skill by Nami...
![No skill and no requested skill by Nami](https://github.com/Tanishq747Shivasharan/SkillSwap-/blob/main/SkillSwap%20images/Screenshot%202025-08-19%20095526.png)
#### Deletion privilages are only to the admin of the website....


## Contributing

1. Fork the repository
2. Create a feature branch (`git checkout -b feature/amazing-feature`)
3. Commit your changes (`git commit -m 'Add amazing feature'`)
4. Push to the branch (`git push origin feature/amazing-feature`)
5. Open a Pull Request

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

## Acknowledgments

- Spring Boot team for the excellent framework
- Angular team for the modern frontend framework

- H2 Database for easy development setup

## Final Project done !

### Issue Reporting
#####If you encounter any bugs, issues, or have feature requests related to SkillSwap, please feel free to open an issue in this repository. When reporting an issue, kindly include:

- A clear and descriptive title.
- Detailed steps to reproduce the problem or describe the feature request.
- Screenshots or error messages, if applicable.
- Information about your environment (e.g., operating system, browser, versions).

I appreciate your feedback and will strive to respond and resolve issues promptly

