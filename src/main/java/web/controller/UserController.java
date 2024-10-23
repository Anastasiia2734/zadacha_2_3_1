package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.dao.UserDao;
import web.model.User;
import web.service.UserService;

import java.util.ArrayList;
import java.util.List;

@Controller
public class UserController {


    private final UserDao userDao;

    @Autowired
    private UserService userService;

    @Autowired
    public UserController(UserDao userDao) {
        this.userDao = userDao;
    }

    @GetMapping("/users")
    public String showUsers(@RequestParam(value = "name", required = false) String name, Model model) {
        List<User> users = new ArrayList<>();
        if (name != null && !name.isEmpty()) {
            users = userService.findUsersName(name);
        } else {
            users = userService.getAllUsers();
        }

        model.addAttribute("users", users);
        return "users";
    }

    @GetMapping("/users/new")
    public String newUser(Model model) {
        model.addAttribute("user", new User());

        return "/users/new";
    }

    @PostMapping("/users")
    public String create(@ModelAttribute("user") User user) {
        userService.createUser(user);
        return "redirect:/users";

    }

    @PostMapping("/users/delete")
    public String deleteUser(@RequestParam Long id) {
        userService.deleteUser(id);
        return "redirect:/users";
    }

    @GetMapping("/users/edit")
    private String edit(@RequestParam Long id, Model model) {
        User user = userService.getUser(id);
        model.addAttribute("user", user);
        return "edit";
    }

    @PostMapping("/users/update")
    public String updateUser(@ModelAttribute("user") User user) {
        userService.update(user);
        return "redirect:/users";
    }
}
