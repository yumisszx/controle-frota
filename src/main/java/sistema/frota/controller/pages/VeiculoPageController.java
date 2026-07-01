package sistema.frota.controller.pages;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import sistema.frota.entidades.veiculo.TipoVeiculo;
import sistema.frota.entidades.veiculo.Veiculo;

@Controller
@RequestMapping("veiculo")
public class VeiculoPageController {

    @GetMapping("/cadastro-veiculo")
    public String getTipoVeiculo(Model model) {

        model.addAttribute("veiculo", new Veiculo());
        model.addAttribute("tiposVeiculo", TipoVeiculo.values());

        return "veiculo";
    }
}
