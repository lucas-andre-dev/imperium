package imperium_sistema.service;

import imperium_sistema.model.dto.LoginRequest;
import imperium_sistema.model.dto.UserCreateDto;
import imperium_sistema.model.entity.UserEntity;
import imperium_sistema.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class UserService {
    /*INJEÇÃO DE DEPENDENCIA VIA CONTRUTOR*/
    private UserRepository userRepository ;

    public UserService(UserRepository userRepository){
        this.userRepository = userRepository ;
    }

    /* LISTAR TODOS OS USUARIO DO BANCO DE DADOS*/
    public List<UserCreateDto> listAll(){
        List<UserEntity> users = userRepository.findAll();
        return users.stream().map(UserCreateDto::new).toList();
    }
    /* SALVAR USUARIO NO BANCO DE DADOS*/
    public void create(UserCreateDto userCreateDto){
        UserEntity userEntity = new UserEntity(userCreateDto);
        userRepository.save(userEntity) ;
    }
    /* ALTERA USUARIO NO BANCO DE DADOS | USADO QUANDO É PASSADO UM JSON VIA BODY DA REQUISIÇÃO HTTP */
    public UserCreateDto alter(UserCreateDto userCreateDto){
        UserEntity userEntity = new UserEntity(userCreateDto) ;


        UserCreateDto user = new UserCreateDto(userRepository.save(userEntity));
        return user ;
    }
    /* DELETA USUARIO DO BANCO VIA ID */
    public void delete(Long id){
        UserEntity user = userRepository.findById(id).get() ;
        userRepository.delete(user);
    }
    /* ENCONTRA USUARIO PELO ID */
    public UserCreateDto findId(Long id){
        UserEntity userEntity = userRepository.findById(id).get() ;
        return new UserCreateDto(userEntity);

    }
    /* ALTERA O USUARIO VIA ID | USADO QUANDO É PASSADO O ID VIA URL NA REQUISIÇÃO HTTP */
    public UserCreateDto update(Long id, UserCreateDto userCreateDto) {
        UserEntity user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

        user.setNome(userCreateDto.getNome());
        user.setEmail(userCreateDto.getEmail());

        // VALIDA SENHA ANTES DE ALTERAR
        if (userCreateDto.getSenha() != null && !userCreateDto.getSenha().isEmpty()) {
            user.setSenha(userCreateDto.getSenha());
        }

        user.setRoles(userCreateDto.getRoles());

        userRepository.save(user);
        return new UserCreateDto(user);
    }

    public UserEntity validarLogin(String email,String senha) {

        Optional<UserEntity> optionalUser = userRepository.findByEmail(email);
        if (optionalUser.isEmpty()) return null; // usuário não encontrado

        UserEntity user = optionalUser.get();

        // compara senha
        if (user.getSenha().equals(senha)) {
            return user; // login válido
        }

        return null; // senha incorreta
    }
}
