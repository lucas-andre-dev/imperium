package imperium_sistema.repository;

import imperium_sistema.model.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
// INTERFACE QUE EXTEND JPAREPOSITORY
// RESPONSAVEL POR FAZER QUERY'S AO BANCO DE DADOS
@Repository
public interface UserRepository extends JpaRepository<UserEntity,Long> {

/* PRECISEI CRIAR ESSE METODO PARA VALIDAÇÃO DE LOGIN */
Optional<UserEntity> findByEmail(String email);

}
