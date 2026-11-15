package com.luv2code.hibernate.demo;

import com.luv2code.hibernate.demo.entity.Course;
import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;
import com.luv2code.hibernate.demo.entity.Student;
import org.hibernate.cfg.Configuration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public final class DemoDatabase {
    private DemoDatabase() {
    }

    static Configuration configuration() {
        return new Configuration()
                .configure()
                .addAnnotatedClass(Course.class)
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .addAnnotatedClass(Student.class)
                .setProperty("hibernate.connection.url", environment("TRAINING_DB_URL"))
                .setProperty("hibernate.connection.username", environment("TRAINING_DB_USERNAME"))
                .setProperty("hibernate.connection.password", environment("TRAINING_DB_PASSWORD"));
    }

    public static Connection connect() throws SQLException {
        return DriverManager.getConnection(
                environment("TRAINING_DB_URL"),
                environment("TRAINING_DB_USERNAME"),
                environment("TRAINING_DB_PASSWORD"));
    }

    private static String environment(String name) {
        String value = System.getenv(name);
        if (value == null) {
            throw new IllegalStateException("Set the " + name + " environment variable");
        }
        return value;
    }
}
