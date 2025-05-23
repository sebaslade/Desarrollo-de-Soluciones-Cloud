package pe.com.rapidosyfuriosos.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;

import pe.com.rapidosyfuriosos.entity.DistritoEntity;

public interface DistritoRepository {
	@Query("select d DistritoEntity d where d.estado=true")
	List<DistritoEntity> findAllCustom();
}
