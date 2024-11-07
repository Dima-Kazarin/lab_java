package com.example.studentapp.model;

import javafx.beans.property.*;

import java.time.LocalDate;


public class Person {
    private final StringProperty firstName;
    private final StringProperty lastName;
    private final IntegerProperty groupCode;
    private final ObjectProperty<LocalDate> birthday;
    private final StringProperty email;
    private final IntegerProperty studentId;
    private final DoubleProperty average_grade;

    public Person() {
        this(null, null);
    }

    public Person(String firstName, String lastName) {
        this.firstName = new SimpleStringProperty(firstName);
        this.lastName = new SimpleStringProperty(lastName);

        this.groupCode = new SimpleIntegerProperty(1747);
        this.birthday = new SimpleObjectProperty<LocalDate>(LocalDate.of(2000, 2, 21));
        this.email = new SimpleStringProperty("example@gmail.com");
        this.studentId = new SimpleIntegerProperty(0);
        this.average_grade = new SimpleDoubleProperty(0.0);

    }

    public String getFirstName() {
        return firstName.get();
    }

    public void setFirstName(String firstName) {
        this.firstName.set(firstName);
    }

    public StringProperty firstNameProperty() {
        return firstName;
    }

    public String getLastName() {
        return lastName.get();
    }

    public void setLastName(String lastName) {
        this.lastName.set(lastName);
    }

    public StringProperty lastNameProperty() {
        return lastName;
    }

    public int getGroupCode() {
        return groupCode.get();
    }

    public void setGroupCode(int groupCode) {
        this.groupCode.set(groupCode);
    }

    public IntegerProperty groupCodeProperty() {
        return groupCode;
    }

    public LocalDate getBirthday() {
        return birthday.get();
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday.set(birthday);
    }

    public ObjectProperty<LocalDate> birthdayProperty() {
        return birthday;
    }

    public String getEmail() {
        return email.get();
    }

    public void setEmail(String email) {
        this.email.set(email);
    }

    public StringProperty emailProperty() {
        return email;
    }

    public int getStudentId() {
        return studentId.get();
    }

    public void setStudentId(int studentId) {
        this.studentId.set(studentId);
    }

    public IntegerProperty studentIdProperty() {
        return studentId;
    }

    public double getAverageGrade() {
        return average_grade.get();
    }

    public void setAverageGrade(double average_grade) {
        this.average_grade.set(average_grade);
    }

    public DoubleProperty averageGradeProperty() {
        return average_grade;
    }

}
