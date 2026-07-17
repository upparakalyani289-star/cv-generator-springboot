# CV Generator

## Project Description

A Spring Boot CRUD application to manage resume information using Spring Boot, Spring Data JPA, and MySQL. This project provides REST APIs to create, read, update, and delete resume details.

## Technologies Used

- Java
- Spring Boot
- Spring Data JPA
- MySQL
- Maven

## Features

- Create Resume
- Get All Resumes
- Get Resume By ID
- Update Resume
- Delete Resume

## API Endpoints

### Create Resume

```
POST /api/resumes
```

### Get All Resumes

```
GET /api/resumes
```

### Get Resume By ID

```
GET /api/resumes/{id}
```

### Update Resume

```
PUT /api/resumes/{id}
```

### Delete Resume

```
DELETE /api/resumes/{id}
```

## How to Run

1. Clone the repository.
2. Configure MySQL database.
3. Update `application.properties`.
4. Run `CvGeneratorApplication.java`.
5. Test APIs using Postman.

## Screenshots

### POST API

![POST API](screenshots/create.png)

### GET ALL API

![GET ALL API](screenshots/get-all.png)

### GET BY ID API

![GET BY ID API](screenshots/get-by-id.png)

### PUT API

![PUT API](screenshots/update.png)

### DELETE API

![DELETE API](screenshots/delete.png)

### Spring Boot Application Running

![Application Running](screenshots/application-running.png)
