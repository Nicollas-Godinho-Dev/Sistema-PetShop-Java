import java.util.Scanner;
import java.util.ArrayList;
import java.util.Random;

public class PetShop {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Random random = new Random();

        ArrayList<Cliente> clientes = new ArrayList<>();
        ArrayList<Pet> pets = new ArrayList<>();
        ArrayList<Catalogo> catalogo = new ArrayList<>();
        ArrayList<Agendamento> agendamentos = new ArrayList<>();
        ArrayList<Produto> produtos = new ArrayList<>();

        int opcao = 0;

        do {

            exibirMenu();

            try {

            opcao = scanner.nextInt();
            scanner.nextLine(); // Clear Buffer

            switch (opcao) {

                case 1:
                    cadastrarCliente(scanner, random, clientes);
                    break;

                case 2:
                    cadastrarPet(scanner, random, clientes, pets);
                    break;

                case 3:
                    cadastrarServico(scanner, random, catalogo);
                    break;

                case 4:
                    agendarServico(scanner, random, pets, catalogo, agendamentos);
                    break;

                case 5:
                    cadastrarProduto(scanner, random, produtos);
                    break;

                case 6:
                    listarClientes(clientes);
                    break;

                case 7:
                    listarPets(pets);
                    break;

                case 8:
                    listarProdutos(produtos);
                    break;

                case 9:
                    listarAgendamentos(agendamentos);
                    break;

                case 10:
                    relatorioCompleto(clientes, pets, produtos, agendamentos);
                    break;

                case 0:
                    System.out.println("Encerrando o sistema...");
                    break;

                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }
        } catch (java.util.InputMismatchException e) {
                System.out.println("Entrada inválida! Por favor, digite um número.");
                scanner.nextLine(); // Limpa o buffer 
            }

        } while (opcao != 0);

        scanner.close();

    } // Final do Main

    public static void exibirMenu() {
        System.out.println("===== SISTEMA PETSHOP =====");
        System.out.println("1. Cadastrar Cliente");
        System.out.println("2. Cadastrar Pet");
        System.out.println("3. Cadastrar Serviço");
        System.out.println("4. Agendar Serviço");
        System.out.println("5. Cadastrar Produto");
        System.out.println("6. Listar Clientes");
        System.out.println("7. Listar Pets");
        System.out.println("8. Listar Produtos / Estoque");
        System.out.println("9. Listar Agendamentos");
        System.out.println("10. Relatório Completo");
        System.out.println("0. Sair");
        System.out.print("Escolha uma opção: ");
    }

    public static void cadastrarCliente(Scanner scanner, Random random, ArrayList<Cliente> clientes) {
        System.out.println("=== Cadastrar Cliente ===");
        int idCliente = random.nextInt(9000) + 1000;

        System.out.print("Nome: ");
        String nome = scanner.nextLine();

        System.out.print("CPF: ");
        String cpf = scanner.nextLine();

        System.out.print("Telefone: ");
        String telefone = scanner.nextLine();

        System.out.print("Endereço: ");
        String endereco = scanner.nextLine();

        try {
            Cliente novoCliente = new Cliente(idCliente, nome, cpf, telefone, endereco);
            clientes.add(novoCliente);
            System.out.println("Cliente cadastrado com sucesso! ID: " + idCliente);
        } catch (RegraNegocioException e) {
            System.out.println("Erro ao cadastrar cliente: " + e.getMessage());
        }
    }

    public static void cadastrarPet(Scanner scanner, Random random, ArrayList<Cliente> clientes, ArrayList<Pet> pets) {
        System.out.println("=== Cadastrar Pet ===");

        if (clientes.isEmpty()) {
            System.out.println("Nenhum cliente cadastrado! Cadastre um cliente primeiro.");
            return;
        }

        System.out.println("=== CLIENTES DISPONÍVEIS ===");
        for (Cliente c : clientes) {
            System.out.println("ID: " + c.getId() + " | Nome: " + c.getNome());
        }
        System.out.println("---------------------------");

        System.out.print("Digite o ID do Dono do Pet: ");
        int idDono = scanner.nextInt();
        scanner.nextLine(); // Clear buffer

        int idPet = random.nextInt(9000) + 1000;

        System.out.print("Nome do Pet: ");
        String nomePet = scanner.nextLine();

        System.out.print("Espécie: ");
        String especie = scanner.nextLine();

        System.out.print("Raça: ");
        String raca = scanner.nextLine();

        System.out.print("Porte: ");
        String porte = scanner.nextLine();

        System.out.print("Idade: ");
        int idade = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Observações: ");
        String obs = scanner.nextLine();

        try {
            Pet novoPet = new Pet(idPet, idDono, nomePet, especie, raca, porte, idade, obs);
            pets.add(novoPet);
            System.out.println("Pet " + nomePet + " cadastrado com sucesso! ID do Pet: " + idPet);
        } catch (RegraNegocioException e) {
            System.out.println("Erro ao cadastrar pet: " + e.getMessage());
        }
    }

    public static void cadastrarServico(Scanner scanner, Random random, ArrayList<Catalogo> catalogo) {
        System.out.println("=== CADASTRAR SERVIÇO ===");

        System.out.print("Nome do Serviço: ");
        String nomeServico = scanner.nextLine();

        System.out.print("Preço: ");
        double precoServico = scanner.nextDouble();

        System.out.print("Tempo: ");
        int tempo = scanner.nextInt();

        scanner.nextLine(); // Clear buffer

        int idServico = random.nextInt(9000) + 1000;

        try {
            Catalogo novoServico = new Catalogo(idServico, nomeServico, precoServico, tempo);
            catalogo.add(novoServico);
            System.out.println("Serviço cadastrado com sucesso! ID: " + idServico);
        } catch (RegraNegocioException e) {
            System.out.println("Erro ao cadastrar serviço: " + e.getMessage());
        }
    }

    public static void agendarServico(Scanner scanner, Random random, ArrayList<Pet> pets, ArrayList<Catalogo> catalogo,
            ArrayList<Agendamento> agendamentos) {
        System.out.println("=== AGENDAR SERVIÇO ===");

        if (pets.isEmpty() || catalogo.isEmpty()) {
            System.out.println("Nenhum Pet ou Serviço cadastrado no sistema!");
            return;
        }

        System.out.println("=== LISTA DE PETS DISPONÍVEIS ===");
        for (Pet p : pets) {
            System.out.println("ID: " + p.getId() + " | Nome: " + p.getNome());
        }
        System.out.println("---------------------------------");

        System.out.print("Digite o ID do Pet escolhido: ");
        int id = scanner.nextInt();

        System.out.println("\n--- CATÁLOGO DE SERVIÇOS ---");
        for (Catalogo c : catalogo) {
            System.out.println("ID: " + c.getIdServico() + " | Serviço: " + c.getNomeServico() + " | Preço: R$ "
                    + c.getPrecoServico());
        }
        System.out.println("----------------------------");

        System.out.print("Digite o ID do Serviço escolhido: ");
        int idServicoEscolhido = scanner.nextInt();

        scanner.nextLine(); // Clear buffer

        System.out.print("Data e Hora (ex: 19/04/2026 16:13): ");
        String dataHora = scanner.nextLine();

        System.out.print("Status (ex: Agendado): ");
        String status = scanner.nextLine();

        System.out.print("Observações: ");
        String obsAgendamento = scanner.nextLine();

        int idAgen = random.nextInt(9000) + 1000;

        try {
            Agendamento novoAgendamento = new Agendamento(idAgen, id, idServicoEscolhido, dataHora, status,
                    obsAgendamento);
            agendamentos.add(novoAgendamento);
            System.out.println("Agendamento realizado com sucesso! ID do Agendamento: " + idAgen);
        } catch (RegraNegocioException e) {
            System.out.println("Erro ao agendar serviço: " + e.getMessage());
        }
    }

    public static void cadastrarProduto(Scanner scanner, Random random, ArrayList<Produto> produtos) {
        System.out.println("=== CADASTRAR PRODUTO ===");

        System.out.print("Nome do Produto: ");
        String nomeProduto = scanner.nextLine();

        System.out.print("Preço de Venda: ");
        double precoProduto = scanner.nextDouble();

        System.out.print("Quantidade em Estoque: ");
        int quantidadeEstoque = scanner.nextInt();

        scanner.nextLine(); // Clear buffer

        int idProduto = random.nextInt(9000) + 1000;

        try {
            Produto novoProduto = new Produto(idProduto, nomeProduto, precoProduto, quantidadeEstoque);
            produtos.add(novoProduto);
            System.out.println("Produto cadastrado com sucesso! ID: " + idProduto);
        } catch (RegraNegocioException e) {
            System.out.println("Erro ao cadastrar produto: " + e.getMessage());
        }
    }

    public static void listarClientes(ArrayList<Cliente> clientes) {
        System.out.println("\n=== CLIENTES CADASTRADOS ===");
        if (clientes.isEmpty()) {
            System.out.println("Nenhum cliente cadastrado até o momento.");
            return;
        }
        for (Cliente c : clientes) {
            c.exibirInformacoes();
            System.out.println("--------------------");
        }

    }

    public static void listarPets(ArrayList<Pet> pets) {
        System.out.println("\n=== PETS CADASTRADOS ===");
        if (pets.isEmpty()) {
            System.out.println("Nenhum pet cadastrado até o momento.");
            return;
        }
        for (Pet p : pets) {
            p.exibirInformacoes();
            System.out.println("--------------------");
        }
    }

    public static void listarProdutos(ArrayList<Produto> produtos) {
        System.out.println("\n=== PRODUTOS EM ESTOQUE ===");
        if (produtos.isEmpty()) {
            System.out.println("Nenhum produto cadastrado.");
            return;
        }
        for (Produto prod : produtos) {
            prod.exibirInformacoes();
            System.out.println("--------------------");
        }
    }

    public static void listarAgendamentos(ArrayList<Agendamento> agendamentos) {
        System.out.println("\n=== AGENDAMENTOS ===");
        if (agendamentos.isEmpty()) {
            System.out.println("Nenhum agendamento cadastrado.");
            return;
        }
        for (Agendamento a : agendamentos) {
            a.exibirInformacoes();
            System.out.println("--------------------");
        }
    }

    public static void relatorioCompleto(ArrayList<Cliente> clientes, ArrayList<Pet> pets, ArrayList<Produto> produtos,
            ArrayList<Agendamento> agendamentos) {
        System.out.println("\n=== RELATÓRIO COMPLETO DO SISTEMA ===");
        listarClientes(clientes);
        listarPets(pets);
        listarProdutos(produtos);
        listarAgendamentos(agendamentos);
    }

} // Final da Classe
