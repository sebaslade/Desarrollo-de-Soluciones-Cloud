package pe.com.rapidosyfuriosos.service.impl;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.com.rapidosyfuriosos.entity.TipoDocumentoEntity;
import pe.com.rapidosyfuriosos.repository.TipoDocumentoRepository;
import pe.com.rapidosyfuriosos.service.TipoDocumentoService;

@Service
public class TipoDocumentoServiceImpl implements TipoDocumentoService{
	@Autowired
	private TipoDocumentoRepository repositorio;
	@Override
	public List<TipoDocumentoEntity> findAll() {
		return repositorio.findAll();
	}

	@Override
	public List<TipoDocumentoEntity> findAllCustom() {
		return repositorio.findAllCustom();
	}

	@Override
	public TipoDocumentoEntity findById(Long id) {
		return repositorio.findById(id).get();
	}

	@Override
	public TipoDocumentoEntity add(TipoDocumentoEntity obj) {
		return repositorio.save(obj);
	}

	@Override
	public TipoDocumentoEntity update(TipoDocumentoEntity obj, Long id) {
		TipoDocumentoEntity objdis = repositorio.findById(id).get();
		BeanUtils.copyProperties(obj, objdis);
		return repositorio.save(obj);
	}

	@Override
	public TipoDocumentoEntity delete(Long id) {
		TipoDocumentoEntity objdis=repositorio.findById(id).get();
		objdis.setEstado(false);
		return repositorio.save(objdis);
	}

	@Override
	public TipoDocumentoEntity enable(Long id) {
		TipoDocumentoEntity objdis=repositorio.findById(id).get();
		objdis.setEstado(true);
		return repositorio.save(objdis);
	}

}
