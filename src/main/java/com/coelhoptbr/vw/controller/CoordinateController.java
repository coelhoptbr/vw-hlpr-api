package com.coelhoptbr.vw.controller;

import com.coelhoptbr.vw.dto.InCoordinateDTO;
import com.coelhoptbr.vw.service.ICoordinateService;
import com.coelhoptbr.vw.util.Util;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.concurrent.ExecutionException;

@RestController
@RequestMapping("/coordinates")
public class CoordinateController {

    private ICoordinateService serv;

    public CoordinateController(ICoordinateService serv) {
        this.serv = serv;
    }

    @GetMapping("/{plate}")
    public ResponseEntity get(@PathVariable String plate) throws ExecutionException, InterruptedException {
        if (serv.get(plate) == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(serv.get(plate));
        }
    }

    @DeleteMapping("/{plate}")
    public ResponseEntity delete(@PathVariable String plate) throws ExecutionException, InterruptedException {
        Boolean coordsExists = (serv.get(plate) != null);

        if (coordsExists) {
            serv.delete(plate);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity create(@Valid @RequestBody InCoordinateDTO coords) throws ExecutionException, InterruptedException {
        serv.create(coords);

        return ResponseEntity
                .created(Util.obterURI("/coordinates/{plate}", "plate", coords.getPlate()))
                .build();
    }

    @PutMapping
    public ResponseEntity update(@Valid @RequestBody InCoordinateDTO coords) throws ExecutionException, InterruptedException {
        Boolean coordsExists = (serv.get(coords.getPlate()) != null);

        if (coordsExists) {
            serv.create(coords);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
