package br.com.tisystem.os.repository;

import br.com.tisystem.os.model.OrdemServico;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class OrdemServicoRepository {
    
    private final List<OrdemServico> ordens = new ArrayList<>();
    private Long sequence = 1L;

    public OrdemServico salvar(OrdemServico os) {
        if (os.getId() == null) {
            os.setId(sequence++);
        }
        ordens.add(os);
        return os;
    }

    public List<OrdemServico> listarTodos() {
        return new ArrayList<>(ordens);
    }

    public Optional<OrdemServico> buscarPorId(Long id) {
        return ordens.stream()
                .filter(os -> os.getId().equals(id))
                .findFirst();
    }

    public List<OrdemServico> listarPorStatus(String status) {
        return ordens.stream()
                .filter(os -> os.getStatus().equalsIgnoreCase(status))
                .collect(Collectors.toList());
    }
}