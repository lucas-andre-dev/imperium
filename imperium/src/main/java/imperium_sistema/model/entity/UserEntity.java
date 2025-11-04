package imperium_sistema.model.entity;
import imperium_sistema.model.dto.UserCreateDto;
import jakarta.persistence.*;
import org.springframework.beans.BeanUtils;
import java.util.Objects;
// CLASSE DE USUARIO
@Table(name = "tb_user")
@Entity
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "nome",nullable = false)
    private String nome;
    @Column(name = "roles",nullable = false)
    private String roles;
    @Column(name = "email",nullable = false,unique = true)
    private String email;
    @Column(name = "senha",nullable = false)
    private String senha;

/* INJEÇÃO DE DEPENDENCIA VIA CONSTRUTOR, SEM USO DE AUTOWIRED*/
    public UserEntity(UserCreateDto user){
        BeanUtils.copyProperties(user,this);
    }
    public UserEntity(){

    }
/* ABAIXO GETTERS E SETTERS E ABAIXO DELES EQUALS E HASHCODE APENAS*/
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

    public String getRoles() {
        return roles;
    }

    public void setRoles(String roles) {
        this.roles = roles;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
/* EQUALS VERIFICA SE DOIS OBEJTOS SÃO IGUAL PELO ID */
    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        UserEntity that = (UserEntity) o;
        return Objects.equals(id, that.id);
    }
/* TRANSMISSÃO DE DADOS VIA HASHCODE */
    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
