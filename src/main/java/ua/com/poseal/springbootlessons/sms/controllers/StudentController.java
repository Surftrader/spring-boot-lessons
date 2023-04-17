package ua.com.poseal.springbootlessons.sms.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ua.com.poseal.springbootlessons.sms.models.Student;
import ua.com.poseal.springbootlessons.sms.services.StudentService;

@Controller
@RequestMapping("students")
public class StudentController {
    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public String students(Model model) {
        model.addAttribute("students", studentService.getAllStudents());
        return "sms/students";
    }

    @GetMapping("new")
    public String addStudents(Model model) {
        Student student = new Student();
        model.addAttribute("student", student);
        return "sms/new_student";
    }

    @PostMapping("students")
    public String saveStudent(@ModelAttribute Student student) {
        studentService.saveStudent(student);
        return "redirect:/students";
    }

//    @DeleteMapping("delete/{id}") It does not work from html page
    @GetMapping("delete/{id}")
    public String deleteStudentById(@PathVariable Long id) {
        studentService.deleteStudentById(id);
        return "redirect:/students";
    }
}
