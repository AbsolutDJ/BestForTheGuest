package projektarbete.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import projektarbete.demo.House;
import projektarbete.demo.User;
import projektarbete.demo.service.HouseService;
import projektarbete.demo.service.UserService;

import java.util.Map;

@Controller
public class LoginController {

    @Autowired
    private UserService userService;

    @RequestMapping("/login")
    public String Login(Model model){
        return "loginview";
    }

    @RequestMapping("/register")
    public String Register(Model model){
        return "registerview";
    }

    @PostMapping(path = "/login/register")
    public String addUser (@ModelAttribute("User") User user, @RequestParam Map<String, String> allFormRequestParams){
        userService.addUser(user);
        return "redirect:/login";
    }
}
