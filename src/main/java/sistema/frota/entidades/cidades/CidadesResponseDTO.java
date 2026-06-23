package sistema.frota.entidades.cidades;

public record CidadesResponseDTO(Integer id_cidade, String cidade, String estado, String pais) {
    public CidadesResponseDTO(Cidades cidades){
        this(cidades.getId_cidade(), cidades.getCidade(), cidades.getEstado(), cidades.getPais());
    }
}
