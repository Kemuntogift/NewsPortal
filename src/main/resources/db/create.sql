SET MODE PostgreSQL;

CREATE TABLE IF NOT EXISTS departments (
  id int PRIMARY KEY auto_increment,
  name VARCHAR,
  description VARCHAR,
  totalemployees int
);

CREATE TABLE IF NOT EXISTS users (
  id int PRIMARY KEY auto_increment,
  name VARCHAR,
  role VARCHAR,
  department VARCHAR
);

CREATE TABLE IF NOT EXISTS news (
  id int PRIMARY KEY auto_increment,
  title VARCHAR,
  description VARCHAR,
  type VARCHAR,
  author VARCHAR
);

CREATE TABLE IF NOT EXISTS departments_users (
  id int PRIMARY KEY auto_increment,
  deptid int,
  userid int
);

CREATE TABLE IF NOT EXISTS departments_users (
  id int PRIMARY KEY auto_increment,
  deptid int,
  newsid int,
  userid int
);


