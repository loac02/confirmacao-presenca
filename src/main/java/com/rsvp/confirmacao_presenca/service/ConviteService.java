package com.rsvp.confirmacao_presenca.service;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;

import com.rsvp.confirmacao_presenca.repositoy.ConviteRepository;
import com.rsvp.confirmacao_presenca.vo.ConviteVO;

import jakarta.transaction.Transactional;

@Service 
@Transactional 
public class ConviteService {

    private final ConviteRepository conviteRepository;

    public ConviteService(ConviteRepository conviteRepository) {
        this.conviteRepository = conviteRepository;
    }

    /**
     * Salva um convite no banco de dados.
     * @param data
     * @param local
     * @param restrito
     */
    public void salvarConvite(LocalDateTime data, String local, boolean restrito) {
        ConviteVO convite = new ConviteVO();
        convite.setData(data);
        convite.setLocal(local);
        convite.setRestrito(restrito);
        conviteRepository.save(convite);
    }

    /**
     * Exclui um convite do banco de dados.
     * @param convite
     */
    public void excluirConvite(ConviteVO convite) {
        conviteRepository.delete(convite);
    }

    /**
     * Busca um convite pelo seu ID.
     * @param id
     * @return
     */
    public ConviteVO buscarConvitePorId(Long id) {
        return conviteRepository.findById(id).orElse(null);
    }
}
