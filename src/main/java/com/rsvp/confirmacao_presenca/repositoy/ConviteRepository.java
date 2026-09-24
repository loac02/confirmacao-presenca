package com.rsvp.confirmacao_presenca.repositoy;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rsvp.confirmacao_presenca.vo.ConviteVO;

public interface ConviteRepository extends JpaRepository<ConviteVO, Long> {


}
