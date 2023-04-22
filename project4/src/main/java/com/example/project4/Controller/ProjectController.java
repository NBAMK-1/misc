package com.example.project4.Controller;

import com.example.project4.Entities.Employee;
import com.example.project4.Entities.Project;
import com.example.project4.Repository.employeeRepository;
import com.example.project4.Repository.projectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/projects")
public class ProjectController {

    @Autowired
    projectRepository proRepo;

    @Autowired
    employeeRepository empRepo;

    @GetMapping("/new")
    public String displayProjectForm(Model model){
        Project aProject = new Project();
        List<Employee> employees = empRepo.findAll();
        model.addAttribute("project",aProject);
        model.addAttribute("allEmployees",employees);
        return "new-project";
    }

    @PostMapping("/save")
    public String createProject(Model model,  Project project){

        proRepo.save(project);

        return "redirect:/projects/new";
    }
}
