package main.repository;

import main.model.Student;
import org.springframework.stereotype.Repository;

import java.util.LinkedList;
import java.util.List;

@Repository
public class StudentRepository {
    private List<Student> studentList;

    public StudentRepository() {
        studentList = new LinkedList<>();
        studentList.add(new Student(1, "testname", "testsurname", 111));
        studentList.add(new Student(2, "testname2", "testsurname2", 222));
        studentList.add(new Student(3, "testname3", "testsurname3", 333));
    }

    public Student add(Student student) {
        studentList.add(student);
        return student;
    }

    public List<Student> getAll() {
        return studentList;
    }

    public Student getByIndex(Integer index) {
        for (Student student : studentList) {
            if (student.getIndex().intValue() == index.intValue()) {
                return student;
            }
        }
        return null;
    }
}
