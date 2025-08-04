package org.example.repositories;

import org.example.entities.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {

    // ✅ Método para buscar produtos que contenham parte do nome, ignorando maiúsculas/minúsculas
    List<Produto> findByProNomeContainingIgnoreCase(String nome);
}
