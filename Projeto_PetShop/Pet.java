public class Pet {

    private int id;
    private int idDono;
    private String nome;
    private String especie;
    private String raca;
    private String porte;
    private int idade;
    private String observacoes;

    public Pet(int id, int idDono, String nome, String especie, String raca, String porte, int idade,
            String observacoes) throws RegraNegocioException {

        setId(id);
        setIdDono(idDono);
        setNome(nome);
        setEspecie(especie);
        setRaca(raca);
        setPorte(porte);
        setIdade(idade);
        setObservacoes(observacoes);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;        
    }

    public int getIdDono() {
        return idDono;
    }

    public void setIdDono(int idDono) {
        this.idDono = idDono;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) throws RegraNegocioException {
        if (nome == null || nome.trim().isEmpty()) {
            throw new RegraNegocioException("O nome do animal não pode ser vazio!");
        }
        this.nome = nome;
    }

    public String getEspecie() {
        return especie;
    }

    public void setEspecie(String especie) throws RegraNegocioException {
        if (especie == null || especie.trim().isEmpty()) {
            throw new RegraNegocioException("A espécie do animal não pode ser vazia!");
        }
        this.especie = especie;
    }

    public String getRaca() {
        return raca;
    }

    public void setRaca(String raca) throws RegraNegocioException {
        if (raca == null || raca.trim().isEmpty()) {
            throw new RegraNegocioException("A raça do animal não pode ser vazia!");
        }
        this.raca = raca;
    }

    public String getPorte() {
        return porte;
    }

    public void setPorte(String porte) throws RegraNegocioException {
        if (porte == null || porte.trim().isEmpty()) {
            throw new RegraNegocioException("O porte do animal não pode ser vazio!");
        }
        this.porte = porte;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) throws RegraNegocioException {
        if (idade < 0) {
            throw new RegraNegocioException("A idade do pet não pode ser negativa!");
        }
        this.idade = idade;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes; // Observação pode ser nula/vazia
    }

    public void exibirInformacoes() {

        System.out.println("ID: " + getId());
        System.out.println("ID do proprietário: " + getIdDono());
        System.out.println("Nome do animal: " + getNome());
        System.out.println("Espécie: " + getEspecie());
        System.out.println("Raça: " + getRaca());
        System.out.println("Porte: " + getPorte());
        System.out.println("Idade: " + getIdade());
        System.out.println("Observações: " + getObservacoes());
    }

} // Final da Classe