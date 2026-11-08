public class Cliente {

    private int id;
    private String nome;
    private String cpf;
    private String telefone;
    private String endereco;

    public Cliente(int id, String nome, String cpf, String telefone, String endereco) throws RegraNegocioException {

        setId(id);
        setNome(nome);
        setCpf(cpf);
        setTelefone(telefone);
        setEndereco(endereco);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) throws RegraNegocioException {
        if (nome == null || nome.trim().isEmpty()) {
            throw new RegraNegocioException("O nome do cliente não pode ser vazio!");
        }
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) throws RegraNegocioException {
        if (cpf == null || cpf.trim().isEmpty()) {
            throw new RegraNegocioException("O CPF do cliente não pode ser vazio!");
        }
        this.cpf = cpf;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) throws RegraNegocioException {
        if (telefone == null || telefone.trim().isEmpty()) {
            throw new RegraNegocioException("O telefone do cliente não pode ser vazio!");
        }
        this.telefone = telefone;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) throws RegraNegocioException {
        if (endereco == null || endereco.trim().isEmpty()) {
            throw new RegraNegocioException("O endereço do cliente não pode ser vazio!");
        }
        this.endereco = endereco;
    }

    public void exibirInformacoes() {

        System.out.println("ID: " + getId());
        System.out.println("Nome: " + getNome());
        System.out.println("CPF: " + getCpf());
        System.out.println("Telefone: " + getTelefone());
        System.out.println("Endereço: " + getEndereco());
    }

} // Final da Classe