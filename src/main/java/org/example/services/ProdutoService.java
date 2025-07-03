package org.example.services;

import org.example.entities.Produto;
import org.example.repositories.ProdutoRepository;
import org.example.services.exeptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository repository;

    public List<Produto> getAll() {
        return repository.findAll();
    }

    public Produto findById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public Produto insert(Produto produto) {
        produto.setProDataCadastro(LocalDateTime.now());
        produto.setProDataAtualizacao(LocalDateTime.now());
        return repository.save(produto);
    }

    public Produto update(Long id, Produto novoProduto) {
        Produto produtoExistente = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(id));

        produtoExistente.setProNome(novoProduto.getProNome());
        produtoExistente.setProDescricao(novoProduto.getProDescricao());
        produtoExistente.setProEstoque(novoProduto.getProEstoque());
        produtoExistente.setProCategoria(novoProduto.getProCategoria());
        produtoExistente.setProCodigoBarra(novoProduto.getProCodigoBarra());
        produtoExistente.setProCodigoInterno(novoProduto.getProCodigoInterno());
        produtoExistente.setProMarca(novoProduto.getProMarca());
        produtoExistente.setProStatus(novoProduto.getProStatus());
        produtoExistente.setProPrecoCusto(novoProduto.getProPrecoCusto());
        produtoExistente.setProPrecoVenda(novoProduto.getProPrecoVenda());
        produtoExistente.setProFabricante(novoProduto.getProFabricante());
        produtoExistente.setProAnoAplicacao(novoProduto.getProAnoAplicacao());
        produtoExistente.setProDataAtualizacao(LocalDateTime.now());
        produtoExistente.setProObservacao(novoProduto.getProObservacao());

        return repository.save(produtoExistente);
    }

    public void delete(Long id) {
        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException(id);
        }
        repository.deleteById(id);
    }
}
