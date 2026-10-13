package br.edu.aula.produtos.repository;

import br.edu.aula.produtos.entity.Producao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProducaoRepository extends JpaRepository<Producao, Long> {
}