USE edu_central_extension;

-- Insert users (10 students, 2 admins)
INSERT INTO users (id, username, password, full_name, avatar, gender) VALUES
(1, 'student1',  '$2a$10$Q7YVWsUIFK3qzGgL2.TtSuQQ/POJ4pIKNCm6J5GrbQLU1rdQGsVVW', 'John Doe', 'avatar1.png', 1),
(2, 'student2',  '$2a$10$Q7YVWsUIFK3qzGgL2.TtSuQQ/POJ4pIKNCm6J5GrbQLU1rdQGsVVW', 'Jane Smith', 'avatar2.png', 2),
(3, 'student3',  '$2a$10$Q7YVWsUIFK3qzGgL2.TtSuQQ/POJ4pIKNCm6J5GrbQLU1rdQGsVVW', 'Alice Brown', 'avatar3.png', 1),
(4, 'student4',  '$2a$10$Q7YVWsUIFK3qzGgL2.TtSuQQ/POJ4pIKNCm6J5GrbQLU1rdQGsVVW', 'Bob Johnson', 'avatar4.png', 2),
(5, 'student5',  '$2a$10$Q7YVWsUIFK3qzGgL2.TtSuQQ/POJ4pIKNCm6J5GrbQLU1rdQGsVVW', 'Charlie White', 'avatar5.png', 1),
(6, 'student6',  '$2a$10$Q7YVWsUIFK3qzGgL2.TtSuQQ/POJ4pIKNCm6J5GrbQLU1rdQGsVVW', 'David Black', 'avatar6.png', 2),
(7, 'student7',  '$2a$10$Q7YVWsUIFK3qzGgL2.TtSuQQ/POJ4pIKNCm6J5GrbQLU1rdQGsVVW', 'Emma Watson', 'avatar7.png', 1),
(8, 'student8',  '$2a$10$Q7YVWsUIFK3qzGgL2.TtSuQQ/POJ4pIKNCm6J5GrbQLU1rdQGsVVW', 'Frank Green', 'avatar8.png', 2),
(9, 'lecture1',  '$2a$10$Q7YVWsUIFK3qzGgL2.TtSuQQ/POJ4pIKNCm6J5GrbQLU1rdQGsVVW', 'Grace Hall', 'avatar9.png', 1),
(10, 'lecture2', '$2a$10$Q7YVWsUIFK3qzGgL2.TtSuQQ/POJ4pIKNCm6J5GrbQLU1rdQGsVVW', 'Hannah Lewis', 'avatar10.png', 2),
(11, 'admin1',  '$2a$10$Q7YVWsUIFK3qzGgL2.TtSuQQ/POJ4pIKNCm6J5GrbQLU1rdQGsVVW', 'Admin One', 'admin_avatar1.png', 1),
(12, 'admin2',  '$2a$10$Q7YVWsUIFK3qzGgL2.TtSuQQ/POJ4pIKNCm6J5GrbQLU1rdQGsVVW', 'Admin Two', 'admin_avatar2.png', 2);

-- Insert periods
INSERT INTO periods (id, name, description, start_date, due_date, state) VALUES
(1, 'Spring 2024', 'Spring semester of 2024', '2024-01-10', '2024-05-25', 1),
(2, 'Summer 2024', 'Summer semester of 2024', '2024-06-05', '2024-08-20', 1),
(3, 'Fall 2024', 'Fall semester of 2024', '2024-09-01', '2024-12-15', 1);

-- Insert lecturer_schedulers
INSERT INTO lecturer_schedulers (id, lecturer_id, course_id, period_id) VALUES
(1, 9, 1, 1),
(2, 10, 3, 1),
(3, 9, 2, 2),
(4, 10, 4, 2),
(5, 9, 5, 3),
(6, 10, 6, 3);

