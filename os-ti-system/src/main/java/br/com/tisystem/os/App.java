package br.com.tisystem.os;

import br.com.tisystem.os.repository.ClienteRepository;
import br.com.tisystem.os.repository.OrdemServicoRepository;
import br.com.tisystem.os.service.ClienteService;
import br.com.tisystem.os.service.OrdemServicoService;
import br.com.tisystem.os.view.MenuView;

public class App {

    public static void main(String[] args) {
        System.out.println("Sistema de OS TI iniciado");

        ClienteRepository clienteRepository = new ClienteRepository();
        OrdemServicoRepository ordemServicoRepository = new OrdemServicoRepository();

        ClienteService clienteService = new ClienteService(clienteRepository);
        OrdemServicoService ordemServicoService =
                new OrdemServicoService(ordemServicoRepository, clienteRepository);

        MenuView menuView = new MenuView(clienteService, ordemServicoService);
        menuView.iniciar();
    }
}
