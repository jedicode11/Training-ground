# Training Ground

Practice exercises for Java, Spring, Hibernate, and Python.

## Spring Boot and Thymeleaf

[Employee directory with form validation](thymeleafdemo-employees-validation) is the final exercise in the Luv2Code Spring Boot and Thymeleaf employee directory tutorial sequence. It retains the original `com.luv2code.springboot` package names. The exercise lists employees, creates and edits records, validates submitted fields, and deletes records.

Use Java 8 and Maven from the module directory. To run the application, set up a local MySQL `employee_directory` database with the `employee` table described by the [Employee entity](thymeleafdemo-employees-validation/src/main/java/com/luv2code/springboot/thymeleafdemo/entity/Employee.java). Configure the connection in [application.properties](thymeleafdemo-employees-validation/src/main/resources/application.properties) or set the corresponding `SPRING_DATASOURCE_URL`, `SPRING_DATASOURCE_USERNAME`, and `SPRING_DATASOURCE_PASSWORD` environment variables.

```sh
cd thymeleafdemo-employees-validation
mvn spring-boot:run
```

Open [the employee list](http://localhost:8080/employees/list).

## Other exercises

- Spring Boot starters and a command-line example in [mycoolapp](01-spring-boot-demo%20%28in%20mycoolapp%29) and [command-line demo](04-command-line-demo).
- [Hibernate CRUD](hibernate-basic-cruddemo), [Spring Data REST](spring-data-rest-cruddemo), and [Jackson data binding](jackson-databinding-json-demo) Maven exercises.
- Hibernate relationship, Spring annotation, aspect-oriented programming, and Spring MVC exercises. The legacy projects use their local `lib/` or `WebContent/WEB-INF/lib/` directories for their classpaths.
- [Python data science practice](PycharmProjects/DataScience).
