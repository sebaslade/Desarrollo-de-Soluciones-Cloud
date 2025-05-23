package pe.com.rapidosyfuriosos.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import pe.com.rapidosyfuriosos.entity.TipoDocumentoEntity;

public interface TipoDocumentoRepository {
	//agregamos un query personalizado
	@Query("select td from TipoDocumentoEntity td where td.estado=true")
	List<TipoDocumentoEntity> findAllCustom();
}