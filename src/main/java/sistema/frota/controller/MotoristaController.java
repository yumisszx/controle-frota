package sistema.frota.controller;

import org.springframework.web.bind.annotation.*;
import sistema.frota.entidades.motorista.Motorista;
import sistema.frota.entidades.motorista.MotoristaRepository;
import sistema.frota.entidades.motorista.MotoristaRequestDTO;
import sistema.frota.entidades.motorista.MotoristaResponseDTO;

import java.util.List;

@RestController
@RequestMapping("motorista")
public class MotoristaController {

    private final MotoristaRepository repository;

    public MotoristaController(MotoristaRepository repository) {
        this.repository = repository;
    }

    @PostMapping
    public String newMotorista(@RequestBody MotoristaRequestDTO data){
        Motorista motoristaData = new Motorista(data);
        repository.save(motoristaData);
        return "Motorista adicionado com sucesso";
    }

    @DeleteMapping("/{id}")
    public String deleteMotorista(@PathVariable String CPF){
        repository.deleteById(CPF);
        return "Motorista removido com sucesso";
    }

    @GetMapping
    public List<MotoristaResponseDTO> listMotoristaAll(){
        List<MotoristaResponseDTO> motoristaList =
                repository.findAll().stream().map(MotoristaResponseDTO::new).toList();
        return motoristaList;
    }

    //@PutMapping("/{id}")

}
