package com.rsvp.confirmacao_presenca.vo;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table (name = "TB_CONVITE")
public class ConviteVO {

    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "ID", nullable = false)
    private Long id;

    @Column (name = "DATA", nullable = false)
    private LocalDateTime data;

    @Column (name = "LOCAL", nullable = false)
    private String local;

    @Column (name = "RESTRITO")
    private boolean restrito;

    @OneToMany(mappedBy = "convite", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ConvidadoVO> convidados;

    public ConviteVO() {
    }

    public ConviteVO(Long id, LocalDateTime data, String local, boolean restrito) {
        this.id = id;
        this.data = data;
        this.local = local;
        this.restrito = restrito;
    }

    
    public Long getId() {
        return id;
    }   

    public void setId(Long id) {
        this.id = id;
    }

    
    public LocalDateTime getData() {
        return data;
    }   

    public void setData(LocalDateTime data) {
        this.data = data;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public boolean isRestrito() {
        return restrito;
    }

    public void setRestrito(boolean restrito) {
        this.restrito = restrito;
    }

    public List<ConvidadoVO> getConvidados() {
        return convidados;
    }

    public void setConvidados(List<ConvidadoVO> convidados) {
        this.convidados = convidados;
    }
}
