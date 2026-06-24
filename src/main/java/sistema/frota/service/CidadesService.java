package sistema.frota.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import sistema.frota.entidades.cidades.Cidades;
import sistema.frota.entidades.cidades.CidadesRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CidadesService {

    private final CidadesRepository repository;
    private final NominatimService service;

    public List<Cidades> buscarCidades(String texto){
        List<Cidades> cidades = repository.findByCidadeContainingIgnoreCase(texto);

        if(!cidades.isEmpty()){
            return cidades;
        }

        cidades = service.buscarCidades(texto);

        if (cidades.isEmpty()){
            repository.saveAll(cidades);
        }

        return cidades;
    }
}

