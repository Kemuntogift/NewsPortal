CREATE DATABASE news_portal;
\c news_portal
CREATE TABLE users (id serial primary key, name varchar, role varchar, department varchar);
CREATE TABLE news (id serial primary key, title varchar, description varchar, type varchar, author varchar);
CREATE TABLE departments (id serial primary key, name varchar, description varchar, totalemployees int);
CREATE TABLE departments_users (id serial primary key, deptid int, userid int);
CREATE TABLE departments_news (id serial primary key, deptid int, newsid int, userid int);
CREATE DATABASE news_portal_test WITH TEMPLATE news_portal;



--SET MODE PostgreSQL;
--
--CREATE TABLE IF NOT EXISTS departments (
--  id int PRIMARY KEY auto_increment,
--  name VARCHAR,
--  description VARCHAR,
--  totalemployees int
--);
--
--CREATE TABLE IF NOT EXISTS users (
--  id int PRIMARY KEY auto_increment,
--  name VARCHAR,
--  role VARCHAR,
--  department VARCHAR
--);
--
--CREATE TABLE IF NOT EXISTS news (
--  id int PRIMARY KEY auto_increment,
--  title VARCHAR,
--  description VARCHAR,
--  type VARCHAR,
--  author VARCHAR
--);
--
--CREATE TABLE IF NOT EXISTS departments_users (
--  id int PRIMARY KEY auto_increment,
--  deptid int,
--  userid int
--);
--
--CREATE TABLE IF NOT EXISTS departments_news (
--  id int PRIMARY KEY auto_increment,
--  deptid int,
--  newsid int,
--  userid int
--);


