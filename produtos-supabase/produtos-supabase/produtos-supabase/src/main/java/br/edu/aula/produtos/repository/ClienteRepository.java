package br.edu.aula.produtos.repository;

import br.edu.aula.produtos.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}