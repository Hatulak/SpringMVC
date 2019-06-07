package main.controllers;

import main.exceptions.NoSuchStudentInDBException;
import main.exceptions.StudentAlreadyExistsInDBException;
import main.model.Student;
import main.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "restStudent")
public class StudentRestController {
    @Autowired
    StudentService studentService;

    @GetMapping(produces = {"application/json", "application/xml"})
    @ResponseStatus(HttpStatus.OK)
    public List<Student> getAll() {
        return studentService.getAll();
    }

    @GetMapping(value = "/{index}", produces = {"application/json", "application/xml"})
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<?> getById(@PathVariable Integer index) {
        Student student = null;
        try {
            student = studentService.getByIndex(index);
        } catch (NoSuchStudentInDBException e) {
            e.printStackTrace();
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(student, HttpStatus.OK);
    }

    @PostMapping(value = "/create", produces = {"application/json", "application/xml"})
    public ResponseEntity<?> save(@RequestBody Student student) {
        try {
            studentService.addStudent(student);
        } catch (StudentAlreadyExistsInDBException e) {
            e.printStackTrace();
            return new ResponseEntity<>(e.getMessage(), HttpStatus.CONFLICT);
        }
        return new ResponseEntity<>("Student has been added", HttpStatus.OK);
    }

    @PostMapping(value = "/update", produces = {"application/json", "application/xml"})
    public ResponseEntity<?> update(@RequestBody Student student) {
        try {
            studentService.updateStudent(student);
        } catch (NoSuchStudentInDBException e) {
            e.printStackTrace();
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>("Student has been updated", HttpStatus.OK);
    }


    @PostMapping(value = "/delete", produces = {"application/json", "application/xml"})
    public ResponseEntity<?> delete(@RequestBody Student student) {
        try {
            studentService.delete(student);
        } catch (NoSuchStudentInDBException e) {
            e.printStackTrace();
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>("Student has been removed", HttpStatus.OK);
    }

}
