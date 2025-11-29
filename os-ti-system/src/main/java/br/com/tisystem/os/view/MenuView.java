package br.com.tisystem.os.view;

import br.com.tisystem.os.model.Cliente;
import br.com.tisystem.os.model.OrdemServico;
import br.com.tisystem.os.service.ClienteService;
import br.com.tisystem.os.service.OrdemServicoService;

import java.util.List;
import java.util.Scanner;

public class MenuView {

    private final ClienteService clienteService;
    private final OrdemServicoService ordemServicoService;
    private final Scanner scanner = new Scanner(System.in);

    public MenuView(ClienteService clienteService,
                    OrdemServicoService ordemServicoService) {
        this.clienteService = clienteService;
        this.ordemServicoService = ordemServicoService;
    }

    public void iniciar() {
        int opcao;
        do {
            mostrarMenu();
            opcao = lerInteiro("Escolha uma opcao: ");

            switch (opcao) {
                case 1 -> cadastrarCliente();
                case 2 -> listarClientes();
                case 3 -> abrirOrdemServico();
                case 4 -> listarOrdens();
                case 0 -> System.out.println("Encerrando sistema...");
                default -> System.out.println("Opcao invalida.");
            }
        } while (opcao != 0);
    }

    private void mostrarMenu() {
        System.out.println("\n===== SISTEMA DE OS TI =====");
        System.out.println("1 - Cadastrar cliente");
        System.out.println("2 - Listar clientes");
        System.out.println("3 - Abrir ordem de servico");
        System.out.println("4 - Listar ordens de servico");
        System.out.println("0 - Sair");
    }

    private void cadastrarCliente() {
        System.out.println("\n--- Cadastro de Cliente ---");
        System.out.print("Nome: ");
        String nome = scanner.nextLine();

        System.out.print("Telefone: ");
        String telefone = scanner.nextLine();

        System.out.print("Endereco: ");
        String endereco = scanner.nextLine();

        System.out.print("Observacoes: ");
        String observacoes = scanner.nextLine();

        Cliente cliente = clienteService.cadastrarCliente(nome, telefone, endereco, observacoes);
        System.out.println("Cliente cadastrado com ID: " + cliente.getId());
    }

    private void listarClientes() {
        System.out.println("\n--- Lista de Clientes ---");
        List<Cliente> clientes = clienteService.listarClientes();
        if (clientes.isEmpty()) {
            System.out.println("Nenhum cliente cadastrado.");
        } else {
            clientes.forEach(System.out::println);
        }
    }

    private void abrirOrdemServico() {
        System.out.println("\n--- Abertura de Ordem de Servico ---");
        Long idCliente = (long) lerInteiro("ID do cliente: ");

        System.out.print("Descricao do problema: ");
        String descricao = scanner.nextLine();

        double valor = lerDouble("Valor estimado: ");

        try {
            OrdemServico os = ordemServicoService.abrirOrdem(idCliente, descricao, valor);
            System.out.println("OS aberta com ID: " + os.getId());
        } catch (IllegalArgumentException e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }

    private void listarOrdens() {
        System.out.println("\n--- Lista de Ordens de Servico ---");
        List<OrdemServico> ordens = ordemServicoService.listarTodas();
        if (ordens.isEmpty()) {
            System.out.println("Nenhuma OS cadastrada.");
        } else {
            ordens.forEach(System.out::println);
        }
    }

    private int lerInteiro(String msg) {
        while (true) {
            try {
                System.out.print(msg);
                String linha = scanner.nextLine();
                return Integer.parseInt(linha);
            } catch (NumberFormatException e) {
                System.out.println("Valor invalido, tente novamente.");
            }
        }
    }

    private double lerDouble(String msg) {
        while (true) {
            try {
                System.out.print(msg);
                String linha = scanner.nextLine();
                return Double.parseDouble(linha.replace(",", "."));
            } catch (NumberFormatException e) {
                System.out.println("Valor invalido, tente novamente.");
            }
        }
    }
}
