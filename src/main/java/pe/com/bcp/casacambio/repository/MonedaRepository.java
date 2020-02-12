package pe.com.bcp.casacambio.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pe.com.bcp.casacambio.domain.Moneda;

@Repository
public interface MonedaRepository extends CrudRepository<Moneda, Long> {
}
