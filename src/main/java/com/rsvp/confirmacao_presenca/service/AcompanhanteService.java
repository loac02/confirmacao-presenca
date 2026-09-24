package com.rsvp.confirmacao_presenca.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.rsvp.confirmacao_presenca.repositoy.AcompanhanteRepository;
import com.rsvp.confirmacao_presenca.vo.AcompanhanteVO;
import com.rsvp.confirmacao_presenca.vo.ConvidadoVO;

import jakarta.transaction.Transactional;

@Service 
@Transactional 
public class AcompanhanteService {

    private final AcompanhanteRepository acompanhanteRepository;

    public AcompanhanteService(AcompanhanteRepository acompanhanteRepository) {
        this.acompanhanteRepository = acompanhanteRepository;
    }

    /**
     * Salva um acompanhante no banco de dados.
     * @param nome
     * @param confirmado
     * @param convidado
     */
    public void salvarAcompanhante(String nome, boolean confirmado, ConvidadoVO convidado) {

        AcompanhanteVO acompanhante = new AcompanhanteVO();
        acompanhante.setNome(nome);
        acompanhante.setConfirmado(confirmado);
        acompanhante.setConvidado(convidado);

        acompanhanteRepository.save(acompanhante);
    }

    /**
     * Exclui um acompanhante do banco de dados.
     * @param acompanhante
     */
    public void excluirAcompanhante(AcompanhanteVO acompanhante) {
        acompanhanteRepository.delete(acompanhante);
    }

    /**
     * Busca um acompanhante pelo seu ID.
     * @param id
     * @return
     */
    public AcompanhanteVO buscarAcompanhantePorId(Long id) {
        return acompanhanteRepository.findById(id).orElse(null );
    }

    /**
     * Recupera uma lista de acompanhantes associados a um convidado específico pelo ID do convidado.
     * @param convidadoId
     * @return
     */
    public List<AcompanhanteVO> recuperaAcompanhantesPorConvidadoId(Long convidadoId) {
        return acompanhanteRepository.recuperaAcompanhantesPorConvidadoId(convidadoId);
    }
}
