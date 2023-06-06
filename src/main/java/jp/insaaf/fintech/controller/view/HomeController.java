package jp.insaaf.fintech.controller.view;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
public class HomeController {

    @RequestMapping("/")
    public String home(Model model, HttpSession session){
        return session.getAttribute("loggedIn") != null && (Boolean) session.getAttribute("loggedIn") ? "index" : "redirect:/login";
    }
}
