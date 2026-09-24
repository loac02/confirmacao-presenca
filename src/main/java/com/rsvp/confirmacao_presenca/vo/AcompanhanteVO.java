package com.rsvp.confirmacao_presenca.vo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity 
@Table (name = "TB_ACOMPANHANTE")
public class AcompanhanteVO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "ID", nullable = false)
    private Long id;

    @Column (name = "NOME", nullable = false)
    private String nome;

    @Column (name = "CONFIRMADO")
    private boolean confirmado;

    @JoinColumn (name = "TB_CONVIDADO")
    @ManyToOne(targetEntity = ConvidadoVO.class, optional = false) 
    private ConvidadoVO convidado;

    public AcompanhanteVO() {
    }

    public AcompanhanteVO(Long id, String nome, boolean confirmado, ConvidadoVO convidado) {
        this.id = id;
        this.nome = nome;
        this.confirmado = confirmado;
        this.convidado = convidado;
    }

    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    
    public String getNome() {
        return nome;
    }   

    public void setNome(String nome) {
        this.nome = nome;
    }

    
    public boolean isConfirmado() {
        return confirmado;
    }

    public void setConfirmado(boolean confirmado) {
        this.confirmado = confirmado;
    }

    
    public ConvidadoVO getConvidado() {
        return convidado;
    }   

    public void setConvidado(ConvidadoVO convidado) {
        this.convidado = convidado;
    }

}
