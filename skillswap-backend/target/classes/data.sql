INSERT INTO users (name, email, location) VALUES
('Telusko', 'tel.usko@example.com', 'New York'),
('Eren', 'eren.eagar@example.com', 'San Francisco'),
('Tanishq', 'tanishq.shiv@example.com', 'London');

INSERT INTO skill_offered (user_id, skill_name, description) VALUES
(1, 'Java Programming', 'Expert in Spring Boot and microservices.'),
(1, 'Database Design', 'Experienced with PostgreSQL and MySQL.'),
(2, 'React Development', 'Proficient in modern React and Redux.'),
(3, 'Cloud Computing', 'AWS certified, experienced with EC2 and S3.');

INSERT INTO skill_requested (user_id, skill_name, description) VALUES
(1, 'Python for Data Science', 'Looking to learn data analysis with Python.'),
(2, 'Backend Development', 'Seeking mentorship in Node.js or Java backend.'),
(3, 'Mobile App Development', 'Interested in learning Flutter or React Native.');
