package pe.com.rapidosyfuriosos.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;

import pe.com.rapidosyfuriosos.entity.VehiculoEntity;

public interface VehiculoRepository {
	@Query("select c from VehiculoEntity c where c.estado=true")
	List<VehiculoEntity> findAllCustom();
}
