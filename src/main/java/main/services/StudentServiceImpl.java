package main.services;

import main.exceptions.NoSuchStudentInDBException;
import main.exceptions.StudentAlreadyExistsInDBException;
import main.model.Student;
import main.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public List<Student> getAll() {
        return new LinkedList<>(studentRepository.findAll());
    }

    @Override
    public Student getByIndex(Integer index) throws NoSuchStudentInDBException {
        Student student = studentRepository.getByIndex(index);
        if (student == null) {
            String message = "There is no student with id: " + index.toString();
            throw new NoSuchStudentInDBException(message);
        }
        return student;
    }

    @Override
    public Student addStudent(Student student) throws StudentAlreadyExistsInDBException {
        Student byIndex = studentRepository.getByIndex(student.getIndex());
        if (byIndex != null) {
            String message = "There is already student with id : " + student.getIndex().toString();
            throw new StudentAlreadyExistsInDBException(message);
        }
        Student save = studentRepository.save(student);
        return save;
    }

    @Override
    public Student updateStudent(Student student) throws NoSuchStudentInDBException {
        Student byIndex = studentRepository.getByIndex(student.getIndex());
        if (byIndex == null) {
            String message = "There is no student with id: " + student.getIndex().toString();
            throw new NoSuchStudentInDBException(message);
        }
        Student save = studentRepository.save(student);
        return save;
    }

    @Override
    public void delete(Integer integer) throws NoSuchStudentInDBException {
        Student byIndex = studentRepository.getByIndex(integer);
        if (byIndex == null) {
            String message = "There is no student with id: " + integer.toString();
            throw new NoSuchStudentInDBException(message);
        }
        studentRepository.delete(integer);
    }

    @Override
    public void delete(Student student) throws NoSuchStudentInDBException {
        Student byIndex = studentRepository.getByIndex(student.getIndex());
        if (byIndex == null) {
            String message = "There is no student with id: " + student.getIndex().toString();
            throw new NoSuchStudentInDBException(message);
        }
        studentRepository.delete(student);
    }


}
