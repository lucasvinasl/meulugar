package com.lagom.meulugar.controller;

import com.lagom.meulugar.model.table.Tables;
import com.lagom.meulugar.service.table.TableService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/table")
public class TableController {

    @Autowired
    private TableService tableService;

    @GetMapping
    public ResponseEntity<List<Tables>> findAll(){
        return ResponseEntity.ok().body(tableService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Tables> findById(@PathVariable Long id){
        return ResponseEntity.ok().body(tableService.getById(id));
    }

    @GetMapping("/identifier")
    public ResponseEntity<Tables> findByIdentifier(@RequestParam String identifier){
        return ResponseEntity.ok().body(tableService.getByIdentifier(identifier));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id){
        tableService.deletetable(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping
    public ResponseEntity<Tables> create(@RequestBody @Valid Tables creaTeform){
        return ResponseEntity.ok().body(tableService.createTable(creaTeform));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Tables> update(@PathVariable Long id, @RequestBody Map<String, Object> updateForm){
        return ResponseEntity.ok().body(tableService.updateTable(id,updateForm));
    }
}
