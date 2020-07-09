package edu.mc.javabootcamp.DemoTimeSheet.web;

import edu.mc.javabootcamp.DemoTimeSheet.model.Employee;
import edu.mc.javabootcamp.DemoTimeSheet.model.User;
import edu.mc.javabootcamp.DemoTimeSheet.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
public class HomeController {

    @Autowired
    UserRepository userRepository;

    @GetMapping("/login")
    public String login(Model model) {
        User user = new User();
        model.addAttribute(user);
        return "login";
    }

    @PostMapping("/login")
    public String processLogin() {
        System.out.println("You are being logged in");
        return null;
    }

    @GetMapping("/register")
    public String register(Model model) {
        model.addAttribute(new User());
        System.out.println("You are registering");
        return "registration";
    }

    @PostMapping("/register")
    public String processRegsitration(@Valid User user, BindingResult result) {
        if (result.hasErrors()) {
            System.out.println("There are some errors with registration.");
            return "registration";
        }
        return "index";
    }
}
