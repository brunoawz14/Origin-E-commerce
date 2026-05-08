package OriginStore.API.OriginE_commerce.Controller;

import OriginStore.API.OriginE_commerce.Entity.Produto;
import OriginStore.API.OriginE_commerce.Service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("produtos")
public class ProdutoController {

    private final ProdutoService produtoService; // ✅ campo declarado

    public ProdutoController(ProdutoService produtoService) {
        this.produtoService = produtoService; // ✅ Spring injeta automaticamente
    }

    @PostMapping
    public ResponseEntity<Produto> save(@RequestBody Produto produto) {
        Produto salvo = produtoService.save(produto);
        return ResponseEntity.status(HttpStatus.CREATED).body(salvo);
    }

    @GetMapping
    public Page<Produto> findAll(
            @RequestParam(required = false) String categoria,
            Pageable pageable) {
        return produtoService.findAll(categoria, pageable);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Produto> findById(@PathVariable Long id) {
        Produto produto = produtoService.findById(id);
        return ResponseEntity.ok(produto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        produtoService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}