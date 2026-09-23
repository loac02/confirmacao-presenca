package com.rsvp.confirmacao_presenca.vo;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity 
@Table (name = "TB_CONVIDADO")
public class ConvidadoVO {

    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false) 
    private Long id;

    @Column(name = "nome", nullable = false)
    private String nome;

    @Column(name = "confirmado")
    private boolean confirmado;

    @Column(name = "numero_telefone")
    private String numeroTelefone;

    @ManyToOne(targetEntity = ConviteVO.class, optional = false)
    @Column(name = "numero_convite")
    private ConviteVO convite;

    @OneToMany(mappedBy = "convidado", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<AcompanhanteVO> acompanhantes;

    public ConvidadoVO() {
    }

    public ConvidadoVO(Long id, String nome, boolean confirmado, String numeroTelefone, ConviteVO convite, List<AcompanhanteVO> acompanhantes) {
        this.id = id;
        this.nome = nome;
        this.confirmado = confirmado;
        this.numeroTelefone = numeroTelefone;
        this.convite = convite;
        this.acompanhantes = acompanhantes;
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

    public String getNumeroTelefone() {
        return numeroTelefone;
    }

    public void setNumeroTelefone(String numeroTelefone) {
        this.numeroTelefone = numeroTelefone;
    }

    public ConviteVO getNumeroConvite() {
        return convite;
    }

    public void setNumeroConvite(ConviteVO convite) {
        this.convite = convite;
    }
    
    public List<AcompanhanteVO> getAcompanhantes() {
        return acompanhantes;
    }

    public void setAcompanhantes(List<AcompanhanteVO> acompanhantes) {
        this.acompanhantes = acompanhantes;
    }
}
