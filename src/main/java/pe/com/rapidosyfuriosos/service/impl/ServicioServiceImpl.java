package pe.com.rapidosyfuriosos.service.impl;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.com.rapidosyfuriosos.entity.ServicioEntity;
import pe.com.rapidosyfuriosos.repository.ServicioRepository;
import pe.com.rapidosyfuriosos.service.ServicioService;

@Service
public class ServicioServiceImpl implements ServicioService{
	@Autowired
	private ServicioRepository repositorio;
	@Override
	public List<ServicioEntity> findAll() {
		return repositorio.findAll();
	}

	@Override
	public List<ServicioEntity> findAllCustom() {
		return repositorio.findAllCustom();
	}

	@Override
	public ServicioEntity findById(Long id) {
		return repositorio.findById(id).get();
	}

	@Override
	public ServicioEntity add(ServicioEntity obj) {
		return repositorio.save(obj);
	}

	@Override
	public ServicioEntity update(ServicioEntity obj, Long id) {
		ServicioEntity objdis = repositorio.findById(id).get();
		BeanUtils.copyProperties(obj, objdis);
		return repositorio.save(obj);
	}

	@Override
	public ServicioEntity delete(Long id) {
		ServicioEntity objdis=repositorio.findById(id).get();
		objdis.setEstado(false);
		return repositorio.save(objdis);
	}

	@Override
	public ServicioEntity enable(Long id) {
		ServicioEntity objdis=repositorio.findById(id).get();
		objdis.setEstado(true);
		return repositorio.save(objdis);
	}
}
