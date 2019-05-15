package main.model;


public class Student {
    private Integer index;
    private String name;
    private String surname;
    private Integer age;

    public Student() {
    }

    public Student(Integer index, String name, String surname, Integer age) {
        this.index = index;
        this.name = name;
        this.surname = surname;
        this.age = age;
    }

    public Integer getIndex() {
        return index;
    }

    public void setIndex(Integer index) {
        this.index = index;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
