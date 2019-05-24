package main.controllers;

import main.model.Student;
import main.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
public class StudentsController {
    @Autowired
    StudentService studentService;

    @RequestMapping(value = "/test")
    public String test() {
        return "test";
    }

    @RequestMapping(value = "/student/{index}")
    public String getStudentByIndex(@PathVariable int index, Model model) {
        Student student = studentService.getByIndex(index);
        model.addAttribute("student", student);
        return "student";
    }

    @RequestMapping(value = "/allStudents")
    public ModelAndView getStudents(Model model) {
        model.addAttribute("students", studentService.getAll());
        return new ModelAndView("allStudents").addObject("students", studentService.getAll());
    }

    @RequestMapping(value = "/addNewStudent", method = RequestMethod.GET)
    public String addNewStudent(Model model) {
        model.addAttribute("student", new Student());
        return "addNewStudent";
    }

    @RequestMapping(value = "/createStudent", method = RequestMethod.POST)
    public String createStudent(@ModelAttribute("student") @Valid Student student, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "addNewStudent";
        } else {
            studentService.addStudent(student);
            return "redirect:/allStudents";
        }
    }

}