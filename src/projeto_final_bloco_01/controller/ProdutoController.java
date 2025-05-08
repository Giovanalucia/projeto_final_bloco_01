package projeto_final_bloco_01.controller;

import java.util.ArrayList;
import java.util.Optional;
import projeto_final_bloco_01.model.Produto;
import projeto_final_bloco_01.repository.ProdutoRepository;

public class ProdutoController implements ProdutoRepository {

    private ArrayList<Produto> listaProdutos = new ArrayList<Produto>();
    private int id = 0; // Controlador de IDs

    public void procurarPorId(int id) {
        Optional<Produto> produto = buscarNaCollection(id);
        if (produto.isPresent())
            produto.get().visualizar();
        else
            System.out.printf("\nA Xícara com o ID '%d' não foi encontrado", id);
    }

    @Override
    public void listarTodos() {
        for (Produto produto : listaProdutos) {
            produto.visualizar();
        }
    }

    @Override
    public void cadastrar(Produto produto) {
        listaProdutos.add(produto);
        System.out.println("A Xícara foi criado com sucesso!");
    }

    @Override
    public void atualizar(Produto produto) {
        Optional<Produto> buscaProduto = buscarNaCollection(produto.getId());
        if (buscaProduto.isPresent()) {
            listaProdutos.set(listaProdutos.indexOf(buscaProduto.get()), produto);
            System.out.printf("\nA Xícara com o ID '%d' foi atualizado com sucesso!", produto.getId());
        } else {
            System.out.printf("\nA Xícara com o ID '%d' não foi encontrado", produto.getId());
        }
    }

    @Override
    public void deletar(int id) {
        Optional<Produto> produto = buscarNaCollection(id);
        if (produto.isPresent()) {
            listaProdutos.remove(produto.get());
            System.out.printf("\nA Xícara com o ID '%d' foi excluído com sucesso!", id);
        } else {
            System.out.printf("\nA Xícara com o ID '%d' não foi encontrado", id);
        }
    }

    // Métodos Auxiliares
    public int gerarId() {
        return ++id;
    }

    public Optional<Produto> buscarNaCollection(int id) {
        for (Produto produto : listaProdutos) {
            if (produto.getId() == id)
                return Optional.of(produto);
        }
        return Optional.empty();
    }

}