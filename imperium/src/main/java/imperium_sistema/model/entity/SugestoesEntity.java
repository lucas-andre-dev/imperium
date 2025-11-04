package imperium_sistema.model.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;
// CLASSE DE SUGESTOES
@Table(name = "tb_sugest")
@Entity
public class SugestoesEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;
    @Column(name = "titulo", nullable = false)
    private String titulo;
    @Column(name = "sugestao",nullable = false)
    private String sugestao;
    @ManyToOne
    @JoinColumn(name = "fk_user",nullable = false)
    private UserEntity userEntity ;
    @Column(name = "dataCriacao", nullable = true)
    private LocalDateTime dataCriacao;
    public SugestoesEntity() {}

// CONSTRUTOR COMPLETO COM TODOS OS ATRIBUTOS
    public SugestoesEntity(String titulo, String sugestao, UserEntity usuario) {
        this.titulo = titulo;
        this.sugestao = sugestao;
        this.userEntity = usuario;
        this.dataCriacao = LocalDateTime.now();
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getSugestao() {
        return sugestao;
    }

    public void setSugestao(String sugestao) {
        this.sugestao = sugestao;
    }

    public UserEntity getUserEntity() {
        return userEntity;
    }

    public void setUserEntity(UserEntity userEntity) {
        this.userEntity = userEntity;
    }

    public LocalDateTime getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(LocalDateTime dataCriacao) {
        this.dataCriacao = dataCriacao;
    }
}
