package DesafioSemana4;

import javax.swing.*;
import java.util.regex.Pattern;

public class Venda {
    public static void registrarVenda() {
        for (Produto produto : Loja.produtos) {
            JOptionPane.showMessageDialog(null, "Nome: " + produto.getNomeProduto() + "| Preço: R$" + produto.getPrecoProduto() +
                    "| Código: " + produto.getCodigoProduto());
        }

        String codigoProdutoInput = JOptionPane.showInputDialog("Qual o Código do produto você quer comprar? ");
        if (!ValidarCodigoProduto(codigoProdutoInput)) {
            JOptionPane.showMessageDialog(null, "Código do produto inválido. Por favor, insira um número válido.");
            return;
        }

        int codigoProduto = Integer.parseInt(codigoProdutoInput);

        String quantProdutoComprarInput = JOptionPane.showInputDialog("Você quer comprar quantos " + Loja.produtos.get(codigoProduto).getNomeProduto() + "?");
        if (!ValidarQuantidade(quantProdutoComprarInput)) {
            JOptionPane.showMessageDialog(null, "Quantidade inválida. Por favor, insira um número inteiro válido.");
            return;
        }

        int quantProdutoComprar = Integer.parseInt(quantProdutoComprarInput);

        if (quantProdutoComprar <= Loja.produtos.get(codigoProduto).getQuantProduto()) {
            float totalCompra = quantProdutoComprar * Loja.produtos.get(codigoProduto).getPrecoProduto();
            JOptionPane.showMessageDialog(null, "Total da compra: R$" + totalCompra + "\nDeseja confirmar a compra?");
            JOptionPane.showMessageDialog(null, "Compra realizada com sucesso! Volte sempre!");
            Loja.produtos.get(codigoProduto).setQuantProduto(Loja.produtos.get(codigoProduto).getQuantProduto() - quantProdutoComprar);
        } else {
            JOptionPane.showMessageDialog(null, "Desculpe não há estoque o suficiente para essa compra");
        }
    }
    private static boolean ValidarCodigoProduto(String codigoProduto) {
        return Pattern.matches("\\d+", codigoProduto);
    }
    private static boolean ValidarQuantidade(String quantidade) {
        return Pattern.matches("\\d+", quantidade);
    }



}