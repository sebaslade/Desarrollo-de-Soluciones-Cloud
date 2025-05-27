package pe.com.rapidosyfuriosos.service.impl;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.com.rapidosyfuriosos.entity.RolEntity;
import pe.com.rapidosyfuriosos.repository.RolRepository;
import pe.com.rapidosyfuriosos.service.RolService;

@Service
public class RolServiceImpl implements RolService{
	@Autowired
	private RolRepository repositorio;
	@Override
	public List<RolEntity> findAll() {
		return repositorio.findAll();
	}

	@Override
	public List<RolEntity> findAllCustom() {
		return repositorio.findAllCustom();
	}

	@Override
	public RolEntity findById(Long id) {
		return repositorio.findById(id).get();
	}

	@Override
	public RolEntity add(RolEntity obj) {
		return repositorio.save(obj);
	}

	@Override
	public RolEntity update(RolEntity obj, Long id) {
		RolEntity objdis = repositorio.findById(id).get();
		BeanUtils.copyProperties(obj, objdis);
		return repositorio.save(obj);
	}

	@Override
	public RolEntity delete(Long id) {
		RolEntity objdis=repositorio.findById(id).get();
		objdis.setEstado(false);
		return repositorio.save(objdis);
	}

	@Override
	public RolEntity enable(Long id) {
		RolEntity objdis=repositorio.findById(id).get();
		objdis.setEstado(true);
		return repositorio.save(objdis);
	}

}
