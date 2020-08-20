package co.com.coco.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.com.coco.dao.AreaDao;
import co.com.coco.dto.core.AreaDto;
import co.com.coco.exception.ServiceException;
import co.com.coco.util.Validacion;

@Service
public class AreaServiceImpl implements AreaService {

	@Autowired
	private AreaDao areaDao;

	@Autowired
	private Messages messages;

	@Override
	public void crear(AreaDto area) {

		if (Validacion.emptyString(area.getNombre()))
			throw new ServiceException(messages.get("service.area.name.empty"));

		if (area.getNombre().length() > 20)
			throw new ServiceException("El nombre no debe exceder los 20 caracteres");

		if (Validacion.emptyString(area.getDescripcion()))
			throw new ServiceException(messages.get("service.area.description.empty"));

		if (area.getDescripcion().length() > 100)
			throw new ServiceException("El nombre no debe exceder los 100 caracteres");

		areaDao.crear(area);
	}

	@Override
	public List<AreaDto> consultar() {

		return areaDao.consultar();
	}
}
