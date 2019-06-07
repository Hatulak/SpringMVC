package main.services;

import main.exceptions.NoSuchStudentInDBException;
import main.exceptions.StudentAlreadyExistsInDBException;
import main.model.Student;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface StudentService {
    List<Student> getAll();

    Student getByIndex(Integer index) throws NoSuchStudentInDBException;

    Student addStudent(Student student) throws StudentAlreadyExistsInDBException;

    Student updateStudent(Student student) throws NoSuchStudentInDBException;

    void delete(Integer integer) throws NoSuchStudentInDBException;

    void delete(Student student) throws NoSuchStudentInDBException;
}
