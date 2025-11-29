package br.com.tisystem.os.service;

import br.com.tisystem.os.model.Cliente;
import br.com.tisystem.os.repository.ClienteRepository;

import java.util.List;

public class ClienteService {

    private final ClienteRepository clienteRepository;

    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    public Cliente cadastrarCliente(String nome,
                                    String telefone,
                                    String endereco,
                                    String observacoes) {

        Cliente cliente = new Cliente(null, nome, telefone, endereco, observacoes);
        return clienteRepository.salvar(cliente);
    }

    public List<Cliente> listarClientes() {
        return clienteRepository.listarTodos();
    }
}
