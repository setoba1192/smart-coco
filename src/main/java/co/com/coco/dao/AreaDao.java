package co.com.coco.dao;

import java.util.List;

import co.com.coco.dto.core.AreaDto;

public interface AreaDao {

	public void crear(AreaDto area);

	public List<AreaDto> consultar();

}
