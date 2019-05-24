package main.services;

import main.model.Student;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface StudentService {
    List<Student> getAll();

    Student getByIndex(Integer index);

    void addStudent(Student student);
}
