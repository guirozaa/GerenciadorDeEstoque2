package DesafioSemana4;
public class Produto {
    private static int count = 0;
    private String nomeProduto;
    private int codigoProduto;
    private String categoriaProduto;
    private float precoProduto;
    private int quantProduto;

    public Produto(){
    };
    public Produto(String nomeProduto, String categoriaProduto, float precoProduto, int quantProduto) {
        this.nomeProduto = nomeProduto;
        this.codigoProduto = count;
        this.categoriaProduto = categoriaProduto;
        this.precoProduto = precoProduto;
        this.quantProduto = quantProduto;
        Produto.count += 1;
    }
    public String getNomeProduto() {
        return nomeProduto;
    }
    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }
    public int getCodigoProduto() {
        return codigoProduto;
    }
    public String getCategoriaProduto() {
        return categoriaProduto;
    }
    public void setCategoriaProduto(String categoriaProduto) {
        this.categoriaProduto = categoriaProduto;
    }
    public float getPrecoProduto() {
        return precoProduto;
    }
    public void setPrecoProduto(float precoProduto) {
        this.precoProduto = precoProduto;
    }
    public int getQuantProduto() {
        return quantProduto;
    }
    public void setQuantProduto(int quantProduto) {
        this.quantProduto = quantProduto;
    }
}