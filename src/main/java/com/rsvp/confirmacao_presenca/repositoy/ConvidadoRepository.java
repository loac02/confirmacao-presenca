package com.rsvp.confirmacao_presenca.repositoy;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.rsvp.confirmacao_presenca.vo.ConvidadoVO;

public interface ConvidadoRepository extends JpaRepository<ConvidadoVO, Long> {
    List<ConvidadoVO> findByConviteId(Long conviteId);
}