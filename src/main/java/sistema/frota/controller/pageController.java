package sistema.frota.controller;

import jakarta.persistence.Column;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class pageController {

    @GetMapping("/cadastroMotorista")
    public String cadastroMotorista(){
        return "cadastroMotorista";
    }
}
