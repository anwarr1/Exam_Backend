package org.example.exam_backend.controller;

import org.example.exam_backend.models.Affectation;
import org.example.exam_backend.models.Employee;
import org.example.exam_backend.models.Project;
import org.example.exam_backend.models.User;
import org.example.exam_backend.repository.UserRepository;
import org.example.exam_backend.service.AffectationService;
import org.example.exam_backend.service.EmployeeService;
import org.example.exam_backend.service.ProjectService;
import org.example.exam_backend.service.UserDetailsServiceImpl;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller

public class EmployeeController {

    EmployeeService employeeService;
    ProjectService projectService;

    private PasswordEncoder passwordEncoder;

    private UserRepository userRepository;
    private AffectationService affectationService;
    private UserDetailsServiceImpl userService;

    public EmployeeController(EmployeeService employeeService, PasswordEncoder passwordEncoder, UserRepository userRepository
            , UserDetailsServiceImpl userService, ProjectService projectService,AffectationService affectationService) {
        this.employeeService = employeeService;
        this.projectService = projectService;
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.userService = userService;
        this.affectationService = affectationService;
    }

    @GetMapping("/affect")
    public String affect(Model model) {
        List<Employee> employees = employeeService.getAll();
        List<Project> projects = projectService.getAll();
        model.addAttribute("employees", employees);
        model.addAttribute("projects", projects);
        model.addAttribute("affectation", new Affectation());
        String currentUsername = userService.getCurrentUsername();

        model.addAttribute("user", currentUsername);

        return "affectation";
    }

    @PostMapping("/affecter")
    public String affectation(@ModelAttribute("affectation") Affectation affectation, Model model) {
        Employee employee = affectation.getEmployee();
        Project project = affectation.getProject();

        affectation.setEmployee(employee);
        affectation.setProject(project);

        affectationService.save(affectation);

        return "redirect:/index";
    }

    @GetMapping("/index")
    public String hello(Model model) {
        List<Employee> employees = employeeService.getAll();
        model.addAttribute("employees", employees);
        String currentUsername = userService.getCurrentUsername();

        model.addAttribute("user", currentUsername);

        return "index";
    }

    @GetMapping("/create")
    public String create(@RequestParam(required = false) Long id, Model model) {
        System.out.println(id);
        if (id != null) {
            Employee employee = employeeService.findById(id).get();
            model.addAttribute("employee", employee);
        } else {
            model.addAttribute("employee", new Employee());
        }
        return "create";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute Employee employee) {
        employeeService.addPerson(employee);
        return "redirect:/index";
    }

    @PostMapping("/delete")
    public String delete(@RequestParam Long id) {
        employeeService.deletePerson(id);
        return "redirect:/index";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/signup")
    public String signup(Model model) {
        model.addAttribute("user", new User());
        return "signup";
    }

    @PostMapping("/signup")
    public String createUser(@ModelAttribute User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
        return "redirect:/login";
    }
}
