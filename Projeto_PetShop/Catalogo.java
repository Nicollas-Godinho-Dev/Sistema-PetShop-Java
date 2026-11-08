public class Catalogo {

    private int idServico;
    private String nomeServico;
    private Double precoServico;
    private int tempo;

    public Catalogo(int idServico, String nomeServico, Double precoServico, int tempo) throws RegraNegocioException {

        setIdServico(idServico);
        setNomeServico(nomeServico);
        setPrecoServico(precoServico);
        setTempo(tempo);
    }

    public int getIdServico() {
        return idServico;
    }

    public void setIdServico(int idServico) {
        this.idServico = idServico;
    }

    public String getNomeServico() {
        return nomeServico;
    }

    public void setNomeServico(String nomeServico) throws RegraNegocioException {
        if (nomeServico == null || nomeServico.trim().isEmpty()) {
            throw new RegraNegocioException("O nome do serviço não pode ser vazio!");
        }
        this.nomeServico = nomeServico;
    }

    public double getPrecoServico() {
        return precoServico;
    }

    public void setPrecoServico(Double precoServico) throws RegraNegocioException {
        if (precoServico == null || precoServico <= 0) {
            throw new RegraNegocioException("O preço do serviço deve ser maior que R$ 0,00!");
        }
        this.precoServico = precoServico;
    }

    public int getTempo() {
        return tempo;
    }

    public void setTempo(int tempo) throws RegraNegocioException {
        if (tempo <= 0) {
            throw new RegraNegocioException("O tempo estimado do serviço deve ser maior que zero minutos!");
        }
        this.tempo = tempo;
    }

    public void exibirInformacoes() {

        System.out.println("ID Serviço: " + getIdServico());
        System.out.println("Serviço: " + getNomeServico());
        System.out.println("Valor: R$ " + getPrecoServico());
        System.out.println("Tempo estimado: " + getTempo() + "min");
    }

} // Final da Classe