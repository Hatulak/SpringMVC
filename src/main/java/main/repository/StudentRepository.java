package main.repository;

import main.model.Student;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends CrudRepository<Student, Integer> {
    List<Student> findAll();

    Student getByIndex(Integer index);

    Student save(Student student);
}
