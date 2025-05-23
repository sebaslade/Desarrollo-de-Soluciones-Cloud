package pe.com.rapidosyfuriosos.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;

import pe.com.rapidosyfuriosos.entity.MarcaEntity;

public interface MarcaRepository {
	@Query("select c from MarcaEntity c where c.estado=true")
	List<MarcaEntity> findAllCustom();
}
