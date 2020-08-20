package co.com.coco.dao;

import java.math.BigDecimal;
import java.sql.Types;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;

import co.com.coco.dto.core.AreaDto;
import co.com.coco.model.Area;

@Repository
public class AreaDaoImpl implements AreaDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Autowired
	private DataSource dataSource;

	@Override
	public void crear(AreaDto area) {

		SimpleJdbcCall call = new SimpleJdbcCall(jdbcTemplate);

		call.withSchemaName("public").withFunctionName("crear_area");
		call.withoutProcedureColumnMetaDataAccess();

		call.declareParameters(new SqlParameter("nombre", Types.CHAR), new SqlParameter("descripcion", Types.CHAR),
				new SqlOutParameter("id", Types.BIGINT), new SqlOutParameter("resultado", Types.INTEGER));

		MapSqlParameterSource in = new MapSqlParameterSource();
		in.addValue("nombre", area.getNombre());
		in.addValue("descripcion", area.getDescripcion());

		Map<String, Object> result = call.execute(in);

		area.setId(new BigDecimal(result.get("id").toString()));

	}

	@Override
	public List<AreaDto> consultar() {

		SimpleJdbcCall call = new SimpleJdbcCall(jdbcTemplate);
		call.withSchemaName("public").withFunctionName("consultar_areas");
		call.declareParameters(new SqlOutParameter("REF", Types.OTHER));
		call.withoutProcedureColumnMetaDataAccess();

		call.returningResultSet("REF", (rs, i) -> {
			Area area = new Area();
			area.setId(rs.getBigDecimal("are_id"));
			area.setNombre(rs.getString("are_descripcion"));
			area.setDescripcion(rs.getString("are_descripcion"));
			return area;
		});

		Map<String, Object> result = call.execute();

		return (List<AreaDto>) result.get("REF");

	}

}
