package imperium_sistema.service;
import imperium_sistema.model.entity.SugestoesEntity;
import imperium_sistema.repository.SugestoesRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class SugestoesService {
    //INJEÇÃO DE DEPENDENCIA REPOSITORY
    private SugestoesRepository sugestoesRepository ;

    public SugestoesService(SugestoesRepository sugestoesRepository){
        this.sugestoesRepository = sugestoesRepository ;
    }
    // CRUD
    //  CREATE
    public void criarSugestoes(SugestoesEntity sugestoesEntity){
        sugestoesRepository.save(sugestoesEntity) ;
    }
    //  READER
    public List<SugestoesEntity> todasSugestoes(Long id){
        return sugestoesRepository.findAllByUserEntityId(id);
    }
    //  UPDATE
    public void alterarSugestoes(SugestoesEntity sugestoesEntity){

        sugestoesRepository.save(sugestoesEntity) ;
    }
    //  DELETE
    public void deletarSugestoes(Long id){

         sugestoesRepository.deleteById(id);
    }
    // LISTAR TUDO
    public List<SugestoesEntity> listaTudo(){
        return sugestoesRepository.findAll() ;
    }
    // ENCONTRAR SUGESTÃO DO USUARIO, PARA ADMIN ALTERAR
    public SugestoesEntity alterarSugestAdmin(Long id,SugestoesEntity sugestoesEntity){
        SugestoesEntity sugest = sugestoesRepository.findById(id).get();
        Long sugestId = sugestoesEntity.getId();
        String sugestTitulo = sugestoesEntity.getSugestao();
        String sugestSugestao = sugestoesEntity.getSugestao();
        sugest.setTitulo(sugestTitulo);
        sugest.setSugestao(sugestSugestao);
        return sugestoesRepository.save(sugest);
    }
}
