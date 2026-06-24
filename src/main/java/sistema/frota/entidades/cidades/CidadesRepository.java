package sistema.frota.entidades.cidades;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface CidadesRepository extends JpaRepository<Cidades, Integer> {
    List<Cidades> findByCidadeContainingIgnoreCase(String cidade);
}
