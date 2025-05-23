package pe.com.rapidosyfuriosos.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;

import pe.com.rapidosyfuriosos.entity.ClienteEntity;

public interface ClienteRepository {
	//agregamos un query personalizado
	@Query("select c from ClienteEntity c where c.estado=true")
	List<ClienteEntity> findAllCustom();
}