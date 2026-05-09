package com.mothersday.mothersday.controller;
import com.mothersday.mothersday.entity.Cupom;
import com.mothersday.mothersday.service.CupomService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cupons")
@CrossOrigin(origins = "*")
@AllArgsConstructor
public class CupomController {

    private final CupomService service;

    @GetMapping("/boasvindas")
    public String boasVindas(){
        return "Olá!";
    }

    @PostMapping("/criar")
    public ResponseEntity<Cupom> create(@RequestBody Cupom cupom) {
        service.createService(cupom);

        return ResponseEntity.status(HttpStatus.CREATED).build();
    }


    @GetMapping("/listar")
    public ResponseEntity<List<Cupom>> listed() {
        return ResponseEntity.ok(service.listedService());
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.deleteService(id);

        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
