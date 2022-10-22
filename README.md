## 中信23届秋招技术考察_金融市场板块_财务管理域技术考察二群_课题

题目: 基于 springboot 编写接口服务, 连接 mysql 数据库并使用 postman 模拟请求.

### 搭建

Environment: Windows 10, IntelliJ IDEA 2022.2, MySQL 8.0, Postman.

- **Generate project** on [start.spring.io](https://start.spring.io/), by following
  ```
  Project: Gradle Project
  Language: Java 17
  Spring Boot: 2.7.5
  Dependencies: Spring Web, Spring Data JPA, Rest Repositories, Lombok, MySQL Driver
  ```
- Implement **application properties** for server side.
  ```java
  #datasource
  spring.datasource.url=jdbc:mysql://localhost:3306/db_user?userUnicode=true&useLegacyDatetimeCode=false&serverTimezone=UTC&createDatabaseIfNotExist=true&allowPublicKeyRetrieval=true&useSSL=true
  #credentials
  ...
  spring.jpa.hibernate.ddl-auto=update
  ```
- **Create model class** for users. See [user class](https://github.com/fomiuna/spring-boot-mysql-demo/blob/master/src/main/java/com/sha/springbootmysqldemo/model/User.java).
- **Create repository class** for user model class. See [user repository interface](https://github.com/fomiuna/spring-boot-mysql-demo/blob/master/src/main/java/com/sha/springbootmysqldemo/repository/IUserRepository.java).  
  User repository will extend jpa repository, which is an abstract class implemented by spring jpa repository. With jpa repository, spring will handle basic database operations automatically, 
  like save, update, find by id, etc.
- **Create user service class**. See [user service implementation class](https://github.com/fomiuna/spring-boot-mysql-demo/blob/master/src/main/java/com/sha/springbootmysqldemo/service/UserService.java) under service package.  
  Here we implement `saveUser`, `findByUsername` and `findAll` methods for instance.
- **Create user controller**. See [user controller class](https://github.com/fomiuna/spring-boot-mysql-demo/blob/master/src/main/java/com/sha/springbootmysqldemo/controller/UserController.java).  
  To describe user controller as a rest controller class, we will add rest controller annotation to it. And we use `Autowired` for the dependency injection.

### 测试

- Start application from main class and we can get
  ```
    Tomcat started on port(s): 8080 (http)
  ```
- Test `saveUser`. Postman manipulation:
  ```
  POST http://localhost:8080/api/user
  Body: raw, JSON,
  {
    "name": "user-1",
    "username": "un-1"
  }
  ```
  Then send the JSON above we can get
  ```
  {
    "id": 1,
    "name": "user-1",
    "username": "un-1",
    'createTime": ...
  }
  ```
- Test `getAllUsers`. First we create the second user.
  ```
  {
    "name": "user-1",
    "username": "un-1"
  }
  ```
  Then Postman manipulation is like
  ```
  GET http://localhost:8080/api/user
  Body: none
  ```
  Call it we can get
  ```
  {
    "id": 1,
    "name": "user-1",
    "username": "un-1",
    'createTime": ...
  },
  {
    "id": 2,
    "name": "user-2",
    "username": "un-2",
    'createTime": ...
  }
  ```
