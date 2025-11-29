package br.com.tisystem.os.repository;

import br.com.tisystem.os.model.Cliente;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ClienteRepository {

    private final List<Cliente> clientes = new ArrayList<>();
    private Long sequence = 1L;

    public Cliente salvar(Cliente cliente) {
        if (cliente.getId() == null) {
            cliente.setId(sequence++);
        }
        clientes.add(cliente);
        return cliente;
    }
    public List<Cliente> listarTodos() {
        return new ArrayList<>(clientes);
    }

    public Optional<Cliente> buscarPorId(Long id) {
        return clientes.stream()
                .filter(c -> c.getId().equals(id))
                .findFirst();
    }
}