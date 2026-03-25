package OriginStore.API.OriginE_commerce.Controller;

import OriginStore.API.OriginE_commerce.Entity.Produto;
import OriginStore.API.OriginE_commerce.Repository.ProdutoRepository;
import jakarta.persistence.Entity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("produtos")
public class ProdutoController {

    @Autowired
    private ProdutoRepository produtoRepository;

    @PostMapping
    public Produto save(@RequestBody Produto produto) {
        produtoRepository.save(produto);
        return produto;
    }
}


