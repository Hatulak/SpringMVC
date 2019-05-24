package main.services;

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
        List<Student> students = new LinkedList<>();
        studentRepository.findAll().forEach(s -> students.add(s));
        return students;
    }

    @Override
    public Student getByIndex(Integer index) {
        return studentRepository.getByIndex(index);
    }

    @Override
    public void addStudent(Student student) {
        studentRepository.save(student);
    }

}
