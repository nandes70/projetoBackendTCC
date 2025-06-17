package org.example.resources;

import dto.FornecedorDTO;
import org.example.entities.Fornecedor;
import org.example.services.FornecedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping(value = "/fornecedor")
public class FornecedorResource {

    @Autowired
    private FornecedorService service;

    @GetMapping
    public ResponseEntity<List<FornecedorDTO>> findAll() {
        List<Fornecedor> list = service.findAll();
        List<FornecedorDTO> listDto = list.stream().map(service::toNewDTO).collect(Collectors.toList());
        return ResponseEntity.ok().body(listDto);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<FornecedorDTO> findById(@PathVariable Long id) {
        Fornecedor obj = service.findById(id);
        FornecedorDTO dto = service.toNewDTO(obj);
        return ResponseEntity.ok().body(dto);
    }

    @PostMapping
    public ResponseEntity<Void> insert(@Valid @RequestBody FornecedorDTO objDto) {
        Fornecedor obj = service.fromDTO(objDto);
        obj = service.insert(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}").buildAndExpand(obj.getForId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Void> update(@Valid @RequestBody FornecedorDTO objDto, @PathVariable Long id) {
        service.update(id, objDto);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.deleteFornecedor(id);
        return ResponseEntity.noContent().build();
    }
}