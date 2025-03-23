INSERT INTO students (student_name, email, phone_number) VALUES
     ('John Doe', 'john.doe@example.com', '123-456-7890'),
     ('Jane Smith', 'jane.smith@example.com', '987-654-3210'),
     ('Alice Johnson', 'alice.johnson@example.com', '555-555-5555'),
     ('Bob Brown', 'bob.brown@example.com', 'N/A'),
     ('Charlie Davis', 'charlie.davis@example.com', '111-222-3333'),
     ('Diana Evans', 'diana.evans@example.com', '444-444-4444'),
     ('Ethan Harris', 'ethan.harris@example.com', 'N/A'),
     ('Fiona Clark', 'fiona.clark@example.com', '777-888-9999'),
     ('George Lewis', 'george.lewis@example.com', '222-333-4444'),
     ('Hannah Walker', 'hannah.walker@example.com', 'N/A');

INSERT INTO instructors (instructor_name, email) VALUES
     ('Dr. Emily Carter', 'emily.carter@example.com'),
     ('Prof. Michael Brown', 'michael.brown@example.com'),
     ('Dr. Sarah Lee', 'sarah.lee@example.com'),
     ('Prof. David Wilson', 'david.wilson@example.com'),
     ('Dr. Laura Martinez', 'laura.martinez@example.com');

INSERT INTO courses (course_name, description, instructor_id) VALUES
    ('Introduction to Programming', 'Learn the basics of programming using Python.', 1),
    ('Advanced Mathematics', 'A deep dive into calculus and linear algebra.', 2),
    ('Data Structures and Algorithms', 'Master the fundamentals of data structures and algorithms.', 3),
    ('Machine Learning Basics', 'An introductory course on machine learning concepts.', 4),
    ('Web Development Fundamentals', 'Learn how to build modern web applications.', 5);

INSERT INTO student_courses (course_id, student_id) VALUES
    (1, 1), -- John Doe enrolled in Introduction to Programming
    (1, 2), -- Jane Smith enrolled in Introduction to Programming
    (2, 3), -- Alice Johnson enrolled in Advanced Mathematics
    (3, 4), -- Bob Brown enrolled in Data Structures and Algorithms
    (4, 5), -- Charlie Davis enrolled in Machine Learning Basics
    (5, 6), -- Diana Evans enrolled in Web Development Fundamentals
    (1, 7), -- Ethan Harris enrolled in Introduction to Programming
    (2, 8), -- Fiona Clark enrolled in Advanced Mathematics
    (3, 9), -- George Lewis enrolled in Data Structures and Algorithms
    (4, 10); -- Hannah Walker enrolled in Machine Learning Basics

DELETE FROM student_courses WHERE course_id = 1;

    SELECT * FROM student_courses