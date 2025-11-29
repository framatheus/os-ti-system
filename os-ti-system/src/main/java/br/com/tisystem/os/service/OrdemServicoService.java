package br.com.tisystem.os.service;

import br.com.tisystem.os.model.Cliente;
import br.com.tisystem.os.model.OrdemServico;
import br.com.tisystem.os.repository.ClienteRepository;
import br.com.tisystem.os.repository.OrdemServicoRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public class OrdemServicoService {

    private final OrdemServicoRepository ordemServicoRepository;
    private final ClienteRepository clienteRepository;

    public OrdemServicoService(OrdemServicoRepository ordemServicoRepository,
                               ClienteRepository clienteRepository) {
        this.ordemServicoRepository = ordemServicoRepository;
        this.clienteRepository = clienteRepository;
    }

    public OrdemServico abrirOrdem(Long idCliente,
                                   String descricaoProblema,
                                   Double valor) {

        Optional<Cliente> optCliente = clienteRepository.buscarPorId(idCliente);
        if (optCliente.isEmpty()) {
            throw new IllegalArgumentException("Cliente nao encontrado com id: " + idCliente);
        }

        OrdemServico os = new OrdemServico(
                null,
                optCliente.get(),
                LocalDate.now(),
                descricaoProblema,
                valor,
                "ABERTA"
        );

        return ordemServicoRepository.salvar(os);
    }

    public List<OrdemServico> listarTodas() {
        return ordemServicoRepository.listarTodos();
    }

    public List<OrdemServico> listarPorStatus(String status) {
        return ordemServicoRepository.listarPorStatus(status);
    }
}
