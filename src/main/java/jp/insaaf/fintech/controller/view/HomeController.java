package jp.insaaf.fintech.controller.view;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import springfox.documentation.annotations.ApiIgnore;

import javax.servlet.http.HttpSession;

@ApiIgnore
@Controller
public class HomeController {

    @RequestMapping("/")
    public String home(Model model, HttpSession session){
        return session.getAttribute("loggedIn") != null && (Boolean) session.getAttribute("loggedIn") ? "index" : "redirect:/login";
    }
}
