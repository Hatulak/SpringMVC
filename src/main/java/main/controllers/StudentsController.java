package main.controllers;

import main.model.Student;
import main.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class StudentsController {
    @Autowired
    StudentRepository studentRepository;

    @RequestMapping(value = "/test")
    public String test() {
        return "test";
    }

    @RequestMapping(value = "/student/{index}")
    public String getStudentByIndex(@PathVariable int index, Model model) {
        Student student = studentRepository.getByIndex(index);
        model.addAttribute("student", student);
        return "student";
    }

    @RequestMapping(value = "/allStudents")
    public String getStudents(Model model) {
        model.addAttribute("students", studentRepository.getAll());
        return "allStudents";
    }

    @RequestMapping(value = "/addNewStudent", method = RequestMethod.GET)
    public String addNewStudent(Model model) {
        model.addAttribute("student", new Student());
        return "addNewStudent";
    }

    @RequestMapping(value = "/createStudent", method = RequestMethod.POST)
    public String createStudent(@ModelAttribute("student") Student student, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "addNewStudent";
        } else {
            studentRepository.add(student);
            return "redirect:/allStudents";
        }
    }

}