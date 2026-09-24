package com.rsvp.confirmacao_presenca.service;

import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rsvp.confirmacao_presenca.repositoy.ConvidadoRepository;
import com.rsvp.confirmacao_presenca.vo.ConvidadoVO;
import com.rsvp.confirmacao_presenca.vo.ConviteVO;

@Service
@Transactional
public class ConvidadoService {

    private final ConvidadoRepository convidadoRepository;

    // Injeção de dependência por construtor
    public ConvidadoService(ConvidadoRepository convidadoRepository) {
        this.convidadoRepository = convidadoRepository;
    }

    /**
     * Salva um convidado no banco de dados.
     * @param nome
     * @param confirmado
     * @param numeroTelefone
     * @param convite
     * @return
     */
    public ConvidadoVO salvarConvidado(String nome, boolean confirmado, String numeroTelefone, ConviteVO convite) {
        ConvidadoVO convidado = new ConvidadoVO();
        convidado.setNome(nome);
        convidado.setConfirmado(confirmado);
        convidado.setNumeroTelefone(numeroTelefone);
        convidado.setConvite(convite);
        return convidadoRepository.save(convidado);
    }

    /**
     * Exclui um convidado do banco de dados.
     * @param convidado
     */
    public void excluirConvidado(ConvidadoVO convidado) {
        convidadoRepository.delete(convidado);
    }

    /**
     * Busca um convidado pelo seu ID.
     * @param id
     * @return
     */
    @Transactional(readOnly = true)
    public ConvidadoVO buscarConvidadoPorId(Long id) {
        return convidadoRepository.findById(id).orElse(null);
    }

    /**
     * Recupera uma lista de convidados associados a um convite específico pelo ID do convite.
     * @param conviteId
     * @return
     */
    @Transactional(readOnly = true)
    public List<ConvidadoVO> recuperaConvidadosPorConviteId(Long conviteId) {
        return convidadoRepository.findByConviteId(conviteId);
    }
}