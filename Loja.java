package DesafioSemana4;

import javax.swing.*;
import java.util.ArrayList;


public class Loja {

    public static ArrayList<Produto> produtos;
    public static void main(String[] args) {
        produtos = new ArrayList<>();

        Produto produto = new Produto("Iphone 11", "eletro",2999, 10);
        produtos.add(produto);
        produto = new Produto("Iphone 12", "eletro",3999, 10);
        produtos.add(produto);
        produto = new Produto("Iphone 13", "eletro",4999, 10);
        produtos.add(produto);
        produto = new Produto("Camisa Nike", "roupa",180, 10);
        produtos.add(produto);
        produto = new Produto("Camisa Adidas", "roupa",200, 10);
        produtos.add(produto);
        produto = new Produto("Camisa Puma", "roupa",250, 10);
        produtos.add(produto);
        produto = new Produto("Hamburguer", "alimento",20, 10);
        produtos.add(produto);
        produto = new Produto("Lasanha", "alimento",30, 10);
        produtos.add(produto);
        produto = new Produto("Pizza", "alimento",45, 10);
        produtos.add(produto);
        String a = JOptionPane.showInputDialog("ADMIN ou USUARIO");
        a = a.toLowerCase();

        if (ValidarUsuario(a, "^(admin|usuario)$")) {
            switch (a) {
                case "admin":
                    menu();
                    break;
                case "usuario":
                    Estoque.procurarProduto();
                    break;
            }
        } else {
            JOptionPane.showMessageDialog(null, "Entrada inválida. Escolha 'admin' ou 'usuario'.");
        }
    }
    public static void menu() {

        try {
            int n = Integer.parseInt(JOptionPane.showInputDialog("---- Selecione a operação desejada ----" +
                    " \n   [1] Adicionar produtos ao estoque" +
                    " \n   [2] Controlar a quantidade de produtos" +
                    " \n   [3] Registrar Venda" +
                    " \n   [4] Procurar produto por categoria" +
                    " \n   [0] Sair do Programa" ));

            switch (n) {
                case 1:
                    Estoque.addProdutos();
                    menu();
                    break;
                case 2:
                    Estoque.controlarEstoque();
                    Estoque.alertaEstoque();
                    menu();
                    break;
                case 3:
                    Venda.registrarVenda();
                    Estoque.alertaEstoque();
                    menu();
                    break;
                case 4:
                    Estoque.procurarProduto();
                    menu();
                    break;
                case 0:
                    JOptionPane.showMessageDialog(null, "Saindo...");
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opção Inválida!");
                    menu();
                    break;
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Digite algo válido ou Saia do programa!");
            menu();
        }
    }
    private static boolean ValidarUsuario(String input, String regex) {
        return input.matches(regex);
    }
}