package sistema.frota.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sistema.frota.entidades.motorista.MotoristaRepository;

@RestController
@RequestMapping("motorista")
public class MotoristaController {

    private final MotoristaRepository repository;

    public MotoristaController(MotoristaRepository repository) {
        this.repository = repository;
    }
}
