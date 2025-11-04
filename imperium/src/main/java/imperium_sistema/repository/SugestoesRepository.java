package imperium_sistema.repository;

import imperium_sistema.model.entity.SugestoesEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
// INTERFACE QUE EXTEND JPAREPOSITORY
// RESPONSAVEL POR FAZER QUERY'S AO BANCO DE DADOS
@Repository
public interface SugestoesRepository extends JpaRepository<SugestoesEntity,Long> {
    // USADO PARA ALTERAR SUGESTOES VIA ID
    List<SugestoesEntity> findAllByUserEntityId(Long userId);
}
