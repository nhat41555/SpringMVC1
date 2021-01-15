package com.codegym.controller;

import com.codegym.model.Student;
import com.codegym.service.StudentService;
import com.codegym.service.impl.StudentServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.List;

@Controller
public class StudentController {
    private final StudentService studentService = new StudentServiceImpl();
    @GetMapping(value = "/student")
    public  String index(Model model)
    {
        List<Student> studentList = studentService.findAll();
        model.addAttribute("student",studentList);
        return "student";
    }
    @GetMapping("/student/create")
    public String create(Model model) {
        model.addAttribute("student", new Student());
        return "/Student/create";
    }
    @PostMapping("/student/save")
    public String save(Student student,RedirectAttributes redirect) {
        student.setId((int)(Math.random() * 10000));
        studentService.save(student);
        redirect.addFlashAttribute("success","Added student success");
        return "redirect:/student";
    }
    @GetMapping("/student/{id}/edit")
    public String edit(@PathVariable int id, Model model) {
        model.addAttribute("student", studentService.findById(id));
        return "/Student/edit";
    }
    @PostMapping("/student/update")
    public String update(Student student) {
        studentService.update(student.getId(), student);
        return "redirect:/student";
    }
    @GetMapping("/student/delete/{id}")
    public String delete(@PathVariable int id, Model model) {
        model.addAttribute("student", studentService.findById(id));
        return "/Student/delete";
    }
    @PostMapping("/student/delete")
    public String delete(Student student, RedirectAttributes redirect) {
        studentService.remove(student.getId());
        redirect.addFlashAttribute("success", "Removed student successfully!");
        return "redirect:/student";
    }
    @GetMapping("/student/{id}/view")
    public String view(@PathVariable int id, Model model) {
        model.addAttribute("student", studentService.findById(id));
        return "/Student/view";
    }

    @PostMapping("student/search")
    public String search(@RequestParam String search,Model model){
        List<Student> students = studentService.findAll();
        List<Student> studentList = new ArrayList<>();
        for (int i =0; i<students.size(); i++) {
            if(students.get(i).getName().toLowerCase().contains(search.toLowerCase())) {
                studentList.add(students.get(i));
            }
        }
        model.addAttribute("student",studentList);
        return "student";
    }

}
