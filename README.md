# Training Ground

Practice exercises for Java, Spring, Hibernate, and Python.

The Java examples use JDK 17 and Maven 3.9 or later. Run `mvn -f <module>/pom.xml verify` from the repository root to build one module.

## Spring Boot and Thymeleaf

[Employee directory with form validation](thymeleafdemo-employees-validation) is the final exercise in the Luv2Code Spring Boot and Thymeleaf employee directory tutorial sequence. It retains the original `com.luv2code.springboot` package names. The exercise lists employees, creates and edits records, validates submitted fields, and deletes records.

To run the application, create a local MySQL 8.4 database with the `employee` table described by the [Employee entity](thymeleafdemo-employees-validation/src/main/java/com/luv2code/springboot/thymeleafdemo/entity/Employee.java). Set `SPRING_DATASOURCE_URL`, `SPRING_DATASOURCE_USERNAME`, and `SPRING_DATASOURCE_PASSWORD` in your environment. The same variables configure the Hibernate CRUD and Spring Data REST web examples.

```sh
cd thymeleafdemo-employees-validation
mvn spring-boot:run
```

Open [the employee list](http://localhost:8080/employees/list).

## Other exercises

- Spring Boot starters and a command-line example in [mycoolapp](01-spring-boot-demo%20%28in%20mycoolapp%29) and [command-line demo](04-command-line-demo).
- [Hibernate CRUD](hibernate-basic-cruddemo), [Spring Data REST](spring-data-rest-cruddemo), and [Jackson data binding](jackson-databinding-json-demo) Maven exercises.
- Run a standalone Spring example with `mvn -f spring-demo-annotations/pom.xml compile exec:java`. The AOP samples run the same way with their own POMs. Use `-Dexec.mainClass=<fully-qualified-name>` to select another launcher.
- The Hibernate relationship demos use `TRAINING_DB_URL`, `TRAINING_DB_USERNAME`, and `TRAINING_DB_PASSWORD`. Set them for your local database, then run the chosen main class from your IDE after importing its POM. The existing [one-to-one](hb-01-one-to-one-uni/sql-scripts/create-db.sql), [one-to-many](hb-03-one-to-many/hb-03-one-to-many/create-db.sql), and [many-to-many](hb-05-many-to-many/sql-scripts/create-db.sql) SQL files recreate their schemas. Run them only against a disposable database.
- [Spring MVC forms](spring-mvc-crud-demo) and the [customer tracker](web-customer-tracker-aop) build as WARs. Deploy them to a local Apache Tomcat 11.0.29 or later. The tracker uses the same `TRAINING_DB_*` variables and its [customer table script](web-customer-tracker-aop/sql-scripts/create-table.sql).
- [Python data science practice](PycharmProjects/DataScience).
