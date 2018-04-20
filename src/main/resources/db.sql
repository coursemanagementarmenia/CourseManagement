create table students (
  id int not null auto_increment primary key,
  firstName varchar(30) not null ,
  lastName varchar(30) not null ,
  age int not null,
  email varchar(100) not null,
  phoneNumber varchar(30) default null
)
  ENGINE = InnoDB;

create table courses (
  id int not null auto_increment primary key,
  name varchar(30),
  duration int,
  description text,
  price double
)
  ENGINE = InnoDB;

create table student_courses_scores (
  id int auto_increment not null primary key,
  score double not null,
  student_id int not null,
  course_id int not null,
  FOREIGN KEY (student_id) REFERENCES students (id),
  FOREIGN KEY (course_id) REFERENCES courses (id)
)
  engine = InnoDB;