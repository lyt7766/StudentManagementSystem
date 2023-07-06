package studentmanagement.studentmanagement.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import studentmanagement.studentmanagement.entity.Student;
import studentmanagement.studentmanagement.service.StudentService;

@Controller
public class StudentController {
    private StudentService studentService;

    public StudentController(StudentService studentService) {
        super();
        this.studentService = studentService;
    }

    //student lists will be stored in the "students", and return to the students view
    @GetMapping("/students")
    public String listStudents(Model model){
        // pass the info to the rendering view (studnets in this case)
        model.addAttribute("students", studentService.getAllStudents());
        return "students";
    }

    // Create the form when user click on the add student button
    @GetMapping("/students/new")
    // model is to pass data from the controller to view
    public String createStudentForm(Model model){
        // Student object representing a blank student form.
        Student student = new Student();
        // bind the form inputs to the student object.
        // attributeName refer to <form th:object="${student}">
        model.addAttribute("student", student);
        // The view named "create_student" should be rendered.
        return "create_student";
    }

    // after user clicking the save button
    @PostMapping("/students")
    // Model Addtirbute is to bind the form data to the student object
    public String saveStudent(@ModelAttribute("student") Student student){
        studentService.saveStudent(student);
        return "redirect:/students";
    }

    @GetMapping("/students/edit/{id}")
    // id value is extracted from the URL path and assigned to the id parameter
    public String editStudentForm(@PathVariable Long id, Model model){
        model.addAttribute("student", studentService.getStudentById(id));
        return "edit_student";
    }

    @PostMapping("/students/{id}")
    public String updateStudent(@PathVariable Long id, @ModelAttribute("student") Student student,Model model){
        //  retrieves the existing Student object with the specified id
        Student existingStudent =studentService.getStudentById(id);
        existingStudent.setId(id);
        existingStudent.setFirstName(student.getFirstName());
        existingStudent.setLastName(student.getLastName());
        existingStudent.setEmail(student.getEmail());

        studentService.updateStudent(existingStudent);
        return "redirect:/students";
    }


    @GetMapping("/students/{id}")
    public String deleteStudent(@PathVariable Long id){
        studentService.deleteStudentById(id);
        return "redirect:/students";
    }
}
