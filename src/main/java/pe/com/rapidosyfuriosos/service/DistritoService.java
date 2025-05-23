package pe.com.rapidosyfuriosos.service;

import java.util.List;

import pe.com.rapidosyfuriosos.entity.DistritoEntity;

public interface DistritoService {
	List<DistritoEntity> findAll();
	List<DistritoEntity> findAllCustom();
	DistritoEntity findById();
	DistritoEntity add(DistritoEntity obj);
	DistritoEntity update(DistritoEntity obj, Long id);
	DistritoEntity delete(Long id);
	DistritoEntity enable(Long id);
}
