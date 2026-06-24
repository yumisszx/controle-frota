package sistema.frota.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import sistema.frota.entidades.cidades.Cidades;
import sistema.frota.service.CidadesService;

import java.util.List;

@RestController
@RequestMapping("cidades")
@RequiredArgsConstructor
public class CidadesController {

    private final CidadesService service;

    @GetMapping
    public List<Cidades> buscarCidades(@RequestParam String nome) {
        return service.buscarCidades(nome);
    }
}
