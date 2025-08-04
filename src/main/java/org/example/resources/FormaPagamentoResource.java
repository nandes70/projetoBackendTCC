package org.example.resources;

import org.example.entities.FormaPagamento;
import org.example.services.FormaPagamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping(value = "/formaPagamento")
public class FormaPagamentoResource {

    @Autowired
    private FormaPagamentoService formaPagamentoService;

    @GetMapping
    public ResponseEntity<List<FormaPagamento>> getAll() {
        List<FormaPagamento> formasPagamento = formaPagamentoService.getAll();
        return ResponseEntity.ok(formasPagamento);
    }

    @GetMapping("/{id}")
    public ResponseEntity<FormaPagamento> findById(@PathVariable Long id) {
        FormaPagamento obj = formaPagamentoService.findById(id);
        return ResponseEntity.ok().body(obj);
    }

    @PostMapping
    public ResponseEntity<FormaPagamento> insert(@RequestBody FormaPagamento formaPagamento) {
        FormaPagamento createdFormaPagamento = formaPagamentoService.insert(formaPagamento);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdFormaPagamento);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody FormaPagamento formaPagamento) {
        if (formaPagamentoService.update(id, formaPagamento)) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        formaPagamentoService.delete(id);
        return ResponseEntity.noContent().build();
    }
}