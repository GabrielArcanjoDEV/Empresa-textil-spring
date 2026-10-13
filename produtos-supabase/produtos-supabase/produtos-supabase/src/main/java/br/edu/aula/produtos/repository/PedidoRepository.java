package br.edu.aula.produtos.repository;

import br.edu.aula.produtos.entity.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {
}