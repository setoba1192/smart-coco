package co.com.coco.service;

import java.util.List;

import co.com.coco.dto.core.AreaDto;

public interface AreaService {

	public void crear(AreaDto area);

	public List<AreaDto> consultar();
}
