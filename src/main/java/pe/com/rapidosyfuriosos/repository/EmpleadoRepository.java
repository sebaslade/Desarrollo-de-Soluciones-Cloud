package pe.com.rapidosyfuriosos.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;

import pe.com.rapidosyfuriosos.entity.EmpleadoEntity;

public interface EmpleadoRepository {
	@Query("select c from EmpleadoEntity c where c.estado=true")
	List<EmpleadoEntity> findAllCustom();
}
