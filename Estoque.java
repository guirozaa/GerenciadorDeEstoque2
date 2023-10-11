package DesafioSemana4;

import javax.swing.*;
import java.util.regex.Pattern;


public class Estoque {

    public static void addProdutos(){
        String nome;
        do {
            nome = JOptionPane.showInputDialog("Nome do produto: ");
        } while (!validarNomeProduto(nome));

        String categoriaProduto;
        do {
            categoriaProduto = JOptionPane.showInputDialog("Categoria do produto(eletro/roupa/alimento): ");
        }while(!validarCategoriaProduto(categoriaProduto));

        float preco = 0;
        do {
            String inputPreco = JOptionPane.showInputDialog("Preço do produto:");
            if (validarPreco(inputPreco)) {
                preco = Float.parseFloat(inputPreco);
            }else {
                System.out.println("Preço inválido. Digite um valor numérico válido.");
            }
        }while(preco <= 0);

        int quantidade;
        do {
            quantidade = Integer.parseInt(JOptionPane.showInputDialog("Quantidade do produto: "));
        } while (quantidade <= 0);

        JOptionPane.showMessageDialog(null, "Produto adicionado com sucesso!!");


        Produto produto = new Produto(nome, categoriaProduto,preco,quantidade);
        Loja.produtos.add(produto);
    }

    public static void procurarProduto() {
        String categoriaDesejada;
        while (true) {
            categoriaDesejada = JOptionPane.showInputDialog("Qual a categoria do produto?(eletro/roupa/alimento)");
            if (ValidarCategoria(categoriaDesejada)) {
                break;
            } else {
                JOptionPane.showMessageDialog(null, "Categoria inválida. Por favor, insira uma categoria válida (eletro/roupa/alimento).");
            }
        }

        JOptionPane.showMessageDialog(null, "Produtos da categoria " + categoriaDesejada + ":");
        for (Produto produto : Loja.produtos) {
            if (produto.getCategoriaProduto().equalsIgnoreCase(categoriaDesejada)) {
                JOptionPane.showMessageDialog(null, "Nome: " + produto.getNomeProduto() + "| Preço: R$" + produto.getPrecoProduto() +
                        ", Código: " + produto.getCodigoProduto());
            }
        }
    }

    public static void controlarEstoque() {
        JOptionPane.showMessageDialog(null, "ÁREA DE CONTROLE DE ESTOQUE");

        for (Produto produto : Loja.produtos) {
            JOptionPane.showMessageDialog(null, "Nome: " + produto.getNomeProduto() + "| Código: " + produto.getCodigoProduto() +
                    " |Quantidade: " + produto.getQuantProduto());
        }

        String codigoProdutoInput = JOptionPane.showInputDialog("Qual código do produto do estoque que deseja modificar?");
        String acaoEscolhida = JOptionPane.showInputDialog("Você deseja adicionar(add) ou subtrair(sub) o estoque de produtos?");

        if (!ValidarCodigoProduto(codigoProdutoInput)) {
            JOptionPane.showMessageDialog(null, "Código do produto inválido. Deve ser um número inteiro positivo.");
            return;
        }

        int produtoEscolhido = Integer.parseInt(codigoProdutoInput);

        if (!ValidarAcaoEscolhida(acaoEscolhida)) {
            JOptionPane.showMessageDialog(null, "Ação inválida. Digite 'add' ou 'sub'.");
            return;
        }

        if (acaoEscolhida.equalsIgnoreCase("add")) {
            int novaQuantidade = Integer.parseInt(JOptionPane.showInputDialog("Deseja adicionar quanto ao estoque?"));

            Loja.produtos.get(produtoEscolhido).setQuantProduto(Loja.produtos.get(produtoEscolhido).getQuantProduto() + novaQuantidade);
            JOptionPane.showMessageDialog(null, "A quantidade de produto foi atualizada com sucesso!");
        } else if (acaoEscolhida.equalsIgnoreCase("sub")) {
            int novaQuantidade = Integer.parseInt(JOptionPane.showInputDialog("Deseja tirar quanto ao estoque?"));

            if (novaQuantidade <= Loja.produtos.get(produtoEscolhido).getQuantProduto()) {
                Loja.produtos.get(produtoEscolhido).setQuantProduto(Loja.produtos.get(produtoEscolhido).getQuantProduto() - novaQuantidade);
                JOptionPane.showMessageDialog(null, "A quantidade de produto foi atualizada com sucesso!");
            } else {
                JOptionPane.showMessageDialog(null, "Sem quantidade o suficiente");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Digitação incorreta, escreva add ou sub");
        }
    }

    public static void alertaEstoque(){
        for (Produto produto: Loja.produtos) {
            if (produto.getQuantProduto() < 3){
                JOptionPane.showMessageDialog(null, "ESTOQUE BAIXO DE "+ produto.getNomeProduto() +"!! ADICIONE PRODUTOS AO ESTOQUE");
            }
        }
    }

    public static boolean validarNomeProduto(String nome) {
        String regex = "^[\\p{L}\\p{N}\\s.,()-]+$";
        return nome.matches(regex);
    }
    public static boolean validarCategoriaProduto(String categoriaProduto) {
        String regex = "^(eletro|roupa|alimento)$";
        return categoriaProduto.matches(regex);
    }
    public static boolean validarPreco(String inputPreco) {
        String regex = "^\\d+(\\.\\d{1,2})?$";
        return inputPreco.matches(regex);
    }
    private static boolean ValidarCategoria(String categoria) {
        return Pattern.matches("eletro|roupa|alimento", categoria);
    }
    private static boolean ValidarCodigoProduto(String codigoProduto) {
        String regex = "^[1-9]\\d*$";
        return codigoProduto.matches(regex);
    }
    private static boolean ValidarAcaoEscolhida(String acao) {
        String regex = "^(add|sub)$";
        return acao.matches(regex);
    }
}