public class Produto {

    private int idProduto;
    private String nomeProduto;
    private double precoVenda;
    private int quantidade;

    public Produto(int idProduto, String nomeProduto, double precoVenda, int quantidade) throws RegraNegocioException {

        setIdProduto(idProduto);
        setNomeProduto(nomeProduto);
        setPrecoVenda(precoVenda);
        setQuantidade(quantidade);
    }

    public int getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(int idProduto) {
        this.idProduto = idProduto;
    }

    public String getNomeProduto() {
        return nomeProduto;
    }

    public void setNomeProduto(String nomeProduto) throws RegraNegocioException {
        if (nomeProduto == null || nomeProduto.trim().isEmpty()) {
            throw new RegraNegocioException("O nome do produto não pode ser vazio!");
        }
        this.nomeProduto = nomeProduto;
    }

    public double getPrecoVenda() {
        return precoVenda;
    }

    public void setPrecoVenda(double precoVenda) throws RegraNegocioException {
        if (precoVenda <= 0) {
            throw new RegraNegocioException("O preço do produto deve ser maior que R$ 0,00!");
        }
        this.precoVenda = precoVenda;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) throws RegraNegocioException {
        if (quantidade < 0) {
            throw new RegraNegocioException("A quantidade em estoque não pode ser negativa!");
        }
        this.quantidade = quantidade;
    }

    public void exibirInformacoes() {

        System.out.println("ID do produto: " + getIdProduto());
        System.out.println("Nome: " + getNomeProduto());
        System.out.println("Preço: " + getPrecoVenda());
        System.out.println("Quantidade: " + getQuantidade() + "un.");
    }

} // Final da Classe