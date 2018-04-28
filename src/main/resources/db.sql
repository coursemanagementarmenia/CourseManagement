create table Student (
  id int not null auto_increment primary key,
  firstName varchar(30) not null ,
  lastName varchar(30) not null ,
  age int not null,
  email varchar(100) not null,
  phoneNumber varchar(30) default null
)
  ENGINE = InnoDB;

create table Course (
  id int not null auto_increment primary key,
  name varchar(30),
  duration int,
  description text,
  price double
)
  ENGINE = InnoDB;

create table StudentCourse(
  id int not null auto_increment primary key,
  studentID int not null,
  courseID int not null,
  mark double default 0,
  foreign key (studentID) references Student(id),
  foreign key (courseID) references Course(id)
)
ENGINE = InnoDB;