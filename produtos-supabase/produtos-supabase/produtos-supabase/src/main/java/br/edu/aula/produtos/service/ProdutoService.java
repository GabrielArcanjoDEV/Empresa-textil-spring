package br.edu.aula.produtos.service;

import br.edu.aula.produtos.entity.Produto;
import br.edu.aula.produtos.repository.ProdutoRepository;
import org.springframework.stereotype.Service;
import java.util.Optional;
import br.edu.aula.produtos.entity.Produto;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {

    private final ProdutoRepository repository;

    public ProdutoService(ProdutoRepository repository) {
        this.repository = repository;
    }

    public Produto criar(Produto produto) {
        produto.setId(null);
        return repository.save(produto);
    }

    public List<Produto> listar() {
        return repository.findAll();
    }

    public Optional<Produto> buscarPorId(Long id) {
        return repository.findById(id);
    }

    public Optional<Produto> atualizar(Long id, Produto dados) {
        return repository.findById(id).map(produto -> {
            produto.setNome(dados.getNome());
            produto.setPreco(dados.getPreco());
            produto.setQuantidadeEstoque(dados.getQuantidadeEstoque());
            produto.setAtivo(dados.getAtivo());
            return repository.save(produto);
        });
    }

    public boolean excluir(Long id) {
        if (!repository.existsById(id)) {
            return false;
        }

        repository.deleteById(id);
        return true;
    }
}
