package pe.com.rapidosyfuriosos.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import pe.com.rapidosyfuriosos.entity.ServicioEntity;

public interface ServicioRepository extends JpaRepository<ServicioEntity, Long>{
	@Query("select d from ServicioEntity d where d.estado=true")
	List<ServicioEntity> findAllCustom();
}
