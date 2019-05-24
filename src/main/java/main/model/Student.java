package main.model;


import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Entity
public class Student {

    @NotNull(message = "{index.notnull}")
    @Min(value = 10000000, message = "{index.characters}")
    @Max(value = 99999999, message = "{index.characters}")
    @Id
    private Integer index;

    @NotBlank(message = "{name.notblank}")
    @Length(min = 2, max = 20, message = "{name.length}")
    @Pattern(regexp = "^[A-Z]([a-z])+$", message = "{name.capital}")
    private String name;

    @NotBlank(message = "{surname.notblank}")
    @Length(min = 2, max = 30, message = "{surname.length}")
    @Pattern(regexp = "^[A-Z]([a-z])+$", message = "{surname.capital}")
    private String surname;

    @NotNull(message = "{age.notnull}")
    @Min(value = 18, message = "{age.value}")
    @Max(value = 30, message = "{age.value}")
    private Integer age;

    public Student(String name, String surname, Integer age) {
        this.name = name;
        this.surname = surname;
        this.age = age;
    }

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
