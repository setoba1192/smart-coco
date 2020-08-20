package co.com.coco.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.com.coco.dto.core.AreaDto;
import co.com.coco.dto.core.Respuesta;
import co.com.coco.service.AreaService;
import co.com.coco.service.Messages;

@RequestMapping("api/area")
@RestController
public class AreaApi {

    @Autowired
    private AreaService areaService;

    @Autowired
    private Messages messages;

    @PostMapping()
    public Respuesta crear(@RequestBody AreaDto area) {

        areaService.crear(area);

        Respuesta respuesta = new Respuesta();
        respuesta.setMensaje(messages.get("api.area.crear"));
        respuesta.setData(area);

        return respuesta;
    }

    @GetMapping("/list")
    public Respuesta consultar() {

        Respuesta respuesta = new Respuesta();
        respuesta.setMensaje("Areas");
        respuesta.setData(areaService.consultar());

        return respuesta;
    }
}
