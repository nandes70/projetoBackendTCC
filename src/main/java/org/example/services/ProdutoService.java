package org.example.services;

import org.example.entities.Produto;
import org.example.repositories.ProdutoRepository;
import org.example.services.exeptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

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
        Optional<Produto> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public Produto insert(Produto produto) {
        return repository.save(produto);
    }

    public boolean update(Long id, Produto produto) {
        Optional<Produto> optionalProduto = repository.findById(id);
        if (optionalProduto.isPresent()) {
            Produto produtoSistema = optionalProduto.get();
            produtoSistema.setProId(produto.getProId());
            produtoSistema.setProNome(produto.getProNome());
            produtoSistema.setProDescricao(produto.getProDescricao());
            produtoSistema.setProEstoque(produto.getProEstoque());
            produtoSistema.setProCategoria(produto.getProCategoria());
            produtoSistema.setProCodigoBarra(produto.getProCodigoBarra());
            produtoSistema.setProMarca(produto.getProMarca());
            produtoSistema.setProStatus(produto.getProStatus());
            produtoSistema.setProPrecoCusto(produto.getProPrecoCusto());
            produtoSistema.setProPrecoVenda(produto.getProPrecoVenda());
            produtoSistema.setProFabricante(produto.getProFabricante());
            produtoSistema.setProAplicacao(produto.getProAplicacao());
            produtoSistema.setProDataCadastro(produto.getProDataCadastro());

            repository.save(produtoSistema);
            return true;
        }
        return false;
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}