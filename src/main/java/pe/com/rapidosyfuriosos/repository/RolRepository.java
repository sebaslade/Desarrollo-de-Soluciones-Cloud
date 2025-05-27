package pe.com.rapidosyfuriosos.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import pe.com.rapidosyfuriosos.entity.RolEntity;

public interface RolRepository extends JpaRepository<RolEntity, Long>{
	@Query("select c from RolEntity c where c.estado=true")
	List<RolEntity> findAllCustom();
}
