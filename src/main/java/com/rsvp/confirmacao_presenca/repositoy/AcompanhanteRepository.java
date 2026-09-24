package com.rsvp.confirmacao_presenca.repositoy;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rsvp.confirmacao_presenca.vo.AcompanhanteVO;



public interface AcompanhanteRepository extends JpaRepository<AcompanhanteVO, Long> {
    
    public List<AcompanhanteVO> recuperaAcompanhantesPorConvidadoId(Long convidadoId);

}
