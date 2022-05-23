# Organisational News Portal

Organisational News Portal is a REST API for querying and retrieving scoped news and information.
There should be news/articles/posts that are available to all employees without navigating
into any department, and others that are housed/classified within departments.

## Author
* GIFT KEMUNTO
## Prerequisites

- Basic Git knowledge, including an installed version of Git.
- Your application must run on the OpenJDK version 11.

## Setup Installations Requirements
* To run the application, in your terminal:

    1. Clone or download the Repository
    2. cd into directory then run `cd news`
    3. Rebuild the Project Using Intellij IDEA or ...
    4. Open terminal command line then navigate to the root folder of the application.
    5. Run `gradle run` command.
    6. Navigate to `http://localhost:4567/` in your browser.
## Setup Requirements for Database
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
# Routes 
## POST /departments/new 
### Response
{
"id": 7,
"name": "Warehouse",
"description": "Stores function",
"totalEmployees": 0
}
## GET /departments
### Response 
Returns all
## In order to run locally
* Go to App.class in main/java folder and guided by the comments make necessary changes
* Go to all the tests in test/java folder and guided by the comments make necessary changes

## API documentation


## Technologies Used
* Java
* Gradle
* Postman

### Development

To fix a bug or enhance an existing module, follow these steps:

- Fork the repo
- Create a new branch (`git checkout -b improve-feature`)
- Make the appropriate changes in the files
- Add changes to reflect the changes made
- Commit your changes (`git commit -am 'Improve feature'`)
- Push to the branch (`git push origin improve-feature`)
- Create a Pull Request

## Known Bugs

If you find a bug, kindly open an issue [here](https://github.com/Kemuntogift/NewsPortal/issues/new) by including your search query and the expected result.

If you'd like to request a new function, feel free to do so by opening an issue [here](https://github.com/Kemuntogift/NewsPortal/issues/new). Please include sample queries and their corresponding results.

### License

*MIT*
Copyright (c) 2022 **Gift Kemunto**

Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
