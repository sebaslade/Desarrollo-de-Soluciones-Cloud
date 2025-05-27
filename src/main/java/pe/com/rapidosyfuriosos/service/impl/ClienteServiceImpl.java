package pe.com.rapidosyfuriosos.service.impl;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.com.rapidosyfuriosos.entity.ClienteEntity;
import pe.com.rapidosyfuriosos.repository.ClienteRepository;
import pe.com.rapidosyfuriosos.service.ClienteService;

@Service
public class ClienteServiceImpl implements ClienteService{
	@Autowired
	private ClienteRepository repositorio;
	@Override
	public List<ClienteEntity> findAll() {
		return repositorio.findAll();
	}

	@Override
	public List<ClienteEntity> findAllCustom() {
		return repositorio.findAllCustom();
	}

	@Override
	public ClienteEntity findById(Long id) {
		return repositorio.findById(id).get();
	}

	@Override
	public ClienteEntity add(ClienteEntity obj) {
		return repositorio.save(obj);
	}

	@Override
	public ClienteEntity update(ClienteEntity obj, Long id) {
		ClienteEntity objdis = repositorio.findById(id).get();
		BeanUtils.copyProperties(obj, objdis);
		return repositorio.save(obj);
	}

	@Override
	public ClienteEntity delete(Long id) {
		ClienteEntity objdis=repositorio.findById(id).get();
		objdis.setEstado(false);
		return repositorio.save(objdis);
	}

	@Override
	public ClienteEntity enable(Long id) {
		ClienteEntity objdis=repositorio.findById(id).get();
		objdis.setEstado(true);
		return repositorio.save(objdis);
	}
}
