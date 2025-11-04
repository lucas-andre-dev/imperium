package imperium_sistema.model.dto;
/* CLASSE RESPONSAVEL POR FORMATAR O QUE DEVE RETORNAR AO FRONT, OU SEJA USUARIO SEM A SENHA */
import imperium_sistema.model.entity.UserEntity;
import org.springframework.beans.BeanUtils;

public class UserDto {

    private Long id;
    private String nome;
    private String email;
    private String roles;

//CONRUTOR RESPONSAVEL POR TRANSFORMA CLASSE USERENTITY EM USERDTO
    public UserDto(UserEntity user){
        BeanUtils.copyProperties(user,this);
    }
    public UserDto(){


    }
/* GETTERS E SETTERS APENAS*/

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRoles() {
        return roles;
    }

    public void setRoles(String roles) {
        this.roles = roles;
    }
}
