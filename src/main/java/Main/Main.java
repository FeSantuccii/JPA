package Main;

import dao.ProdutoDAO;
import model.Produto;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) { //PUBLIC PRODUTODAO
        ProdutoDAO produtoDAO = new ProdutoDAO();
        Scanner scanner = new Scanner(System.in);
        String continuar = "sim";

        while (continuar.equalsIgnoreCase("sim")) {
            //solicitar os dados
            Produto produto = new Produto();
            System.out.print("Digite o nome do produto: ");
            produto.setNome(scanner.nextLine());
            System.out.print("Digite o preço do produto: ");
            produto.setPreco(scanner.nextDouble());
            scanner.nextLine(); //QUEBRAR A LINHA

            produtoDAO.criar(produto); //criação de produtos

            System.out.print("Deseja adicionar outro produto? (sim/não): ");
            continuar = scanner.nextLine();
        }

        //LISTA DE TODOS OS PRODUTOS
        System.out.println("\nLista de produtos no banco de dados:");
        produtoDAO.listarTodos().forEach(p -> System.out.println(p.getNome() + " - " + p.getPreco()));

        scanner.close();
    }
}
