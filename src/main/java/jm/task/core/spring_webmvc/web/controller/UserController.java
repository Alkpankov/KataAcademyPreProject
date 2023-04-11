package jm.task.core.spring_webmvc.web.controller;

import jm.task.core.spring_webmvc.web.model.User;
import jm.task.core.spring_webmvc.web.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/users")
public class UserController {

    private final UserService userService;
    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public String printUsers(Model model){
        model.addAttribute("list", userService.listUsers());
        return "users";
    }

    @GetMapping("/{id}")
    public String showUser(@PathVariable("id") long id, Model model) {
        model.addAttribute("user", userService.get(id));
        return "user";
    }

    @GetMapping("/new")
    public String newUser(Model model) {
        model.addAttribute("user", new User());
        return "new";
    }
    @PostMapping()
    public String createUser(@ModelAttribute("user") User user) {
        userService.add(user);
        return "redirect:/users";
    }

    @PatchMapping("/{id}")
    public String updateUser(@ModelAttribute("user") User user, @PathVariable("id") long id) {
        userService.update(id, user);
        return "redirect:/users";
    }

    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable("id") long id) {
        userService.delete(id);
        return "redirect:/users";
    }
    @GetMapping("/{id}/edit")
    public String editUser(Model model, @PathVariable("id") long id) {
        model.addAttribute("user", userService.get(id));
        return "edit";
    }

    @GetMapping("/search")
    public String searchUserById(@RequestParam("keyword") long id, Model model){
        User user = userService.get(id);
        if (user != null) {
            model.addAttribute("user", user);
            return "/user";
        }
        return "error_search";
    }
}
