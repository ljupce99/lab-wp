package mk.ukim.finki.lab.web.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {
    @GetMapping("/login")
    public String loginPage() {
        return "login"; // Името на HTML фајлот (login.html)
    }

}
