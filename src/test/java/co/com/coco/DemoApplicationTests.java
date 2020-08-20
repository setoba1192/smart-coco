package co.com.coco;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import co.com.coco.dao.AreaDaoImpl;
import co.com.coco.dto.core.AreaDto;
import co.com.coco.util.JsonTransformer;

@SpringBootTest
class DemoApplicationTests {

	@Autowired
	private AreaDaoImpl areaDao;

	@Test
	void contextLoads() {
	}

	@Test
	public void test() {

		AreaDto area = new AreaDto();
		area.setNombre("Test");
		area.setDescripcion("Description");

		areaDao.crear(area);
	}

	@Test
	public void test2() {

		List<AreaDto> areas = areaDao.consultar();

		Assertions.assertTrue(!areas.isEmpty());

		System.out.println(areas.size());

		System.out.println(JsonTransformer.toJson(areas));

	}

}
