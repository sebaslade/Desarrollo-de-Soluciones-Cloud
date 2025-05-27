package pe.com.rapidosyfuriosos.service.impl;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.com.rapidosyfuriosos.entity.DistritoEntity;
import pe.com.rapidosyfuriosos.repository.DistritoRepository;
import pe.com.rapidosyfuriosos.service.DistritoService;

//@Service -> Implementacion del Servicio
@Service
public class DistritoServiceImpl implements DistritoService{

	//@Autowired -> inyeccion de dependencia
	@Autowired
	private DistritoRepository repositorio;
	@Override
	public List<DistritoEntity> findAll() {
		return repositorio.findAll();
	}

	@Override
	public List<DistritoEntity> findAllCustom() {
		return repositorio.findAllCustom();
	}

	@Override
	public DistritoEntity findById(Long id) {
		return repositorio.findById(id).get();
	}

	@Override
	public DistritoEntity add(DistritoEntity obj) {
		return repositorio.save(obj);
	}

	@Override
	public DistritoEntity update(DistritoEntity obj, Long id) {
		DistritoEntity objdis = repositorio.findById(id).get();
		BeanUtils.copyProperties(obj, objdis);
		return repositorio.save(obj);
	}

	@Override
	public DistritoEntity delete(Long id) {
		DistritoEntity objdis=repositorio.findById(id).get();
		objdis.setEstado(false);
		return repositorio.save(objdis);
	}

	@Override
	public DistritoEntity enable(Long id) {
		DistritoEntity objdis=repositorio.findById(id).get();
		objdis.setEstado(true);
		return repositorio.save(objdis);
	}

}
