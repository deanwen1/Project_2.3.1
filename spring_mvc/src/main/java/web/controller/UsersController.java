package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import web.model.User;
import web.service.UserService;

import java.util.List;

@Controller
@RequestMapping("/")
public class UsersController {

    private final UserService userService;

    public UsersController(UserService userService) {
        this.userService = userService;
    }


    @RequestMapping
    public String getAllUsers(Model model) {

        List<User> user = userService.getAllUsers();
        model.addAttribute("get", user);
        return "users";
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public ModelAndView editPage(@PathVariable("id") int id) {
        User userEdit = userService.getUserId(id);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("editUser");
        modelAndView.addObject("userEdit", userEdit);
        return modelAndView;
    }

    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public ModelAndView editUser(@ModelAttribute("userEdit") User user) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("editUser");
        userService.editUser(user);
        return modelAndView;
    }

    @RequestMapping(path = "/delete/{id}")
    public String deleteUser(Model model, @PathVariable("id") Long id) {

        userService.deleteUser(id);
        return "redirect:/";
    }

    @RequestMapping(path = "/create", method = RequestMethod.POST)
    public String addUser(User user) {

        userService.addUser(user);
        return "redirect:/";
    }
}

