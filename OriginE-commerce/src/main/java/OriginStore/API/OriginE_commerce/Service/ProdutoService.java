package OriginStore.API.OriginE_commerce.Service;

import OriginStore.API.OriginE_commerce.Entity.Produto;
import OriginStore.API.OriginE_commerce.Repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service // 👈 Diz pro Spring que essa classe é um Service e gerencia ela automaticamente
public class ProdutoService {

    @Autowired // 👈 O Spring injeta o Repository aqui sozinho, você não precisa dar "new ProdutoRepository()"
    private ProdutoRepository produtoRepository;

    // 👇 Salva um produto novo no banco
    public Produto save(Produto produto) {
        return produtoRepository.save(produto); // o .save() do JPA já faz o INSERT no banco
    }

    // 👇 Busca um produto pelo ID — se não achar, lança um erro automaticamente
    public Produto findById(Long id) {
        return produtoRepository.findById(id) // retorna um Optional<Produto> (pode ter ou não ter)
                .orElseThrow(() -> new RuntimeException("Produto não encontrado")); // se não achar, lança exceção
    }

    // 👇 Busca um produto existente, atualiza os campos e salva novamente
    public Produto atualizar(Long id, Produto produtoAtualizado) {
        Produto existente = findById(id); // primeiro verifica se o produto existe

        existente.setNome(produtoAtualizado.getNome());   // sobrescreve o nome
        existente.setPreco(produtoAtualizado.getPreco()); // sobrescreve o preço

        return produtoRepository.save(existente); // o .save() com ID já faz UPDATE no banco
    }

    // 👇 Retorna uma lista com todos os produtos do banco
    public List<Produto> listarTodos() {
        return produtoRepository.findAll(); // o .findAll() faz um SELECT * no banco
    }

    // 👇 Deleta um produto pelo ID
    public void deletar(Long id) {
        findById(id); // verifica se existe antes de tentar deletar (evita erro silencioso)
        produtoRepository.deleteById(id); // faz o DELETE no banco
    }
}


//Resumo do que cada camada faz:

//Service
  // ↓
//produtoRepository.save()      →  INSERT ou UPDATE no banco
//produtoRepository.findById()  →  SELECT por ID
//produtoRepository.findAll()   →  SELECT *
//        produtoRepository.deleteById()→  DELETE por ID