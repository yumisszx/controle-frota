package sistema.frota.entidades.cidades;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class NominatimResponseDTO {
    private String display_name;
    private Address address;

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Address {
        private String city;
        private String town;
        private String village;
        private String municipality;
        private String state;
        private String country;
    }

}
