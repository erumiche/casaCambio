package pe.com.bcp.casacambio.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pe.com.bcp.casacambio.domain.TipoCambio;

@Repository
public interface TipoCambioRepository extends CrudRepository<TipoCambio,Long> {

}
