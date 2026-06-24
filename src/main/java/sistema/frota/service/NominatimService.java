package sistema.frota.service;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import sistema.frota.entidades.cidades.Cidades;
import sistema.frota.entidades.cidades.NominatimResponseDTO;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class NominatimService {
    private final RestTemplate restTemplate = new RestTemplate();

    public List<Cidades> buscarCidades(String nomeCidade){
        String url =
                "https://nominatim.openstreetmap.org/search" +
                "?q=" +nomeCidade+
                "&format=jsonv2" +
                "&addressdetails=1" +
                "&limit=10";

        HttpHeaders headers = new HttpHeaders();
        headers.set("User-Agent", "controle-frota");

        HttpEntity<Void> entity = new HttpEntity<>(headers);

        ResponseEntity<NominatimResponseDTO[]> response =
                restTemplate.exchange(
                        url,
                        HttpMethod.GET,
                        entity,
                        NominatimResponseDTO[].class);

        List<Cidades> cidades = new ArrayList<>();

        if (response.getBody() == null) {
            return cidades;
        }

        for(NominatimResponseDTO item : response.getBody()){
            Cidades cidade = new Cidades();

            String nome =
                    Optional.ofNullable(item.getAddress().getCity())
                            .orElse(Optional.ofNullable(item.getAddress().getTown())
                                .orElse(Optional.ofNullable(item.getAddress().getVillage())
                                    .orElse(item.getAddress().getMunicipality())
                                )
                            );

            cidade.setCidade(nome);
            cidade.setEstado(item.getAddress().getState());
            cidade.setPais(item.getAddress().getCountry());

            cidades.add(cidade);
        }
        return cidades;
    }
}
