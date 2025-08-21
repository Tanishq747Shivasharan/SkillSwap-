# Contributing to SkillSwap

Thank you for your interest in contributing to SkillSwap! This document provides guidelines and information for contributors.

## Current Contributors.
1. Vedant Vallal

## 🚀 Getting Started

### Prerequisites
- Java 17+
- Node.js 18+
- Maven 3.6+
- Git

### Development Setup

1. **Fork and Clone**
   ```bash
   git clone https://github.com/YOUR_USERNAME/skillswap.git
   cd skillswap
   ```

2. **Backend Setup**
   ```bash
   cd skillswap-backend
   ./mvnw spring-boot:run
   ```

3. **Frontend Setup**
   ```bash
   cd skillswap-frontend
   npm install
   ng serve
   ```

## 🛠️ Development Guidelines

### Code Style
- **Backend**: Follow Java conventions, use meaningful variable names
- **Frontend**: Follow Angular style guide, use TypeScript strict mode
- **Commits**: Use conventional commit messages

### Branch Naming
- `feature/description` - New features
- `bugfix/description` - Bug fixes
- `docs/description` - Documentation updates
- `refactor/description` - Code refactoring

### Commit Messages
```
feat: add user skill matching algorithm
fix: resolve CORS issue in API endpoints
docs: update README with deployment instructions
refactor: optimize database queries
```

## 🧪 Testing

### Backend Tests
```bash
cd skillswap-backend
./mvnw test
```

### Frontend Tests
```bash
cd skillswap-frontend
ng test
ng e2e
```

## 📝 Pull Request Process

1. **Create Feature Branch**
   ```bash
   git checkout -b feature/your-feature-name
   ```

2. **Make Changes**
   - Write clean, documented code
   - Add tests for new functionality
   - Update documentation as needed

3. **Test Your Changes**
   - Run all tests
   - Test manually in browser
   - Check API endpoints with Swagger

4. **Submit Pull Request**
   - Clear title and description
   - Reference any related issues
   - Include screenshots for UI changes

## 🐛 Bug Reports

When reporting bugs, please include:
- Steps to reproduce
- Expected vs actual behavior
- Browser/OS information
- Console errors (if any)
- Screenshots (if applicable)

## 💡 Feature Requests

For new features:
- Describe the problem it solves
- Provide use cases
- Consider implementation complexity
- Discuss with maintainers first

## 📚 Areas for Contribution

### Backend
- [ ] User authentication & authorization
- [ ] Email notifications for matches
- [ ] Advanced search and filtering
- [ ] Skill categories and tags
- [ ] User ratings and reviews

### Frontend
- [ ] Real-time notifications
- [ ] Advanced UI components
- [ ] Mobile responsiveness improvements
- [ ] Accessibility enhancements
- [ ] Progressive Web App features

### DevOps
- [ ] Docker containerization
- [ ] CI/CD pipeline setup
- [ ] Production deployment guides
- [ ] Monitoring and logging

## 🤝 Community

- Be respectful and inclusive
- Help others learn and grow
- Share knowledge and best practices
- Follow our Code of Conduct

## 📞 Getting Help

- Create an issue for bugs or questions
- Join discussions in pull requests
- Check existing documentation first


Thank you for contributing to SkillSwap! 🎉

