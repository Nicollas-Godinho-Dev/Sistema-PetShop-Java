public class Agendamento {

    private int idAgendamento;
    private int idPet;
    private int idServico;
    private String dataHora;
    private String status;
    private String observacoes;

    public Agendamento(int idAgendamento, int idPet, int idServico, String dataHora, String status,
            String observacoes) throws RegraNegocioException {

        setIdAgendamento(idAgendamento);
        setIdPet(idPet);
        setIdServico(idServico);
        setDataHora(dataHora);
        setStatus(status);
        setObservacoes(observacoes);
    }

    public int getIdAgendamento() {
        return idAgendamento;
    }

    public void setIdAgendamento(int id) {
        this.idAgendamento = id;
    }

    public int getIdPet() {
        return idPet;
    }

    public void setIdPet(int id) {
        this.idPet = id;
    }

    public int getIdServico() {
        return idServico;
    }

    public void setIdServico(int idServico) {
        this.idServico = idServico;
    }

    public String getDataHora() {
        return dataHora;
    }

    public void setDataHora(String dataHora) throws RegraNegocioException {
        if (dataHora == null || dataHora.trim().isEmpty()) {
            throw new RegraNegocioException("A data e hora do agendamento são obrigatórias!");
        }
        this.dataHora = dataHora;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) throws RegraNegocioException {
        if (status == null || status.trim().isEmpty()) {
            throw new RegraNegocioException("O status do agendamento é obrigatório!");
        }
        this.status = status;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes; // Observação pode ser nula/vazia
    }

    public void exibirInformacoes() {

        System.out.println("ID do agendamento: " + getIdAgendamento());
        System.out.println("ID do animal: " + getIdPet());
        System.out.println("ID do serviço: " + getIdServico());
        System.out.println("Data e Hora: " + getDataHora());
        System.out.println("Status: " + getStatus());
        System.out.println("Observações: " + getObservacoes());
    }

} // Final da Classe