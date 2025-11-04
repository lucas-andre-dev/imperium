package imperium_sistema.model.dto;
import imperium_sistema.model.entity.UserEntity;
import org.springframework.beans.BeanUtils;
/* CLASSE REPONSAVEL POR CRIAR USUARIO SEM USAR A CLASSE USUARIO DE FATO*/
public class UserCreateDto {

    private Long id;
    private String nome;
    private String roles;
    private String email;
    private String senha;

    public UserCreateDto(UserEntity user){
        BeanUtils.copyProperties(user,this);
    }
    public UserCreateDto(){

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
}
