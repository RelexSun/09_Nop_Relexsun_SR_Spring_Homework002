create table if not exists students(
    student_id SERIAL primary key,
    student_name varchar(100) not null,
    email varchar(100) unique not null,
    phone_number varchar(12) not null default 'N/A'
);

create table if not exists instructors(
   instructor_id SERIAL primary key,
   instructor_name varchar(100) not null,
   email varchar(100) unique not null
);

create table if not exists courses(
    course_id SERIAL primary key,
    course_name varchar(100) not null,
    description varchar(250) not null,
    instructor_id int not null,
    constraint fk_instructor foreign key (instructor_id) references instructors (instructor_id) on delete cascade on update cascade
);

create table if not exists student_courses(
    course_id int not null,
    student_id int not null,
    primary key (course_id, student_id),
    constraint fk_course foreign key (course_id) references courses (course_id) on delete cascade on update cascade,
    constraint fk_student foreign key (student_id) references students (student_id) on delete cascade on update cascade
);

select * from student_courses sc inner join courses c on c.course_id = sc.course_id where student_id = 3

-- drop table if exists students, courses, instructors, student_courses