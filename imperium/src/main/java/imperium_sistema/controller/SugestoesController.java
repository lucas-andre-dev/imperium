package imperium_sistema.controller;

import imperium_sistema.model.entity.SugestoesEntity;
import imperium_sistema.service.SugestoesService;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/sugestoes")
public class SugestoesController {

    //  INJEÇÃO DE DEPENDECIA SERVICE
    private SugestoesService sugestoesService ;

    public SugestoesController(SugestoesService sugestoesService){
        this.sugestoesService = sugestoesService ;

    }
    // GET - LISTAR APENAS SUGESTOES DE UM ID ESPECIFICO
    @GetMapping("/{id}")
    public List<SugestoesEntity> listar(@PathVariable Long id){
        return sugestoesService.todasSugestoes(id) ;
    }
    // GET - LISTAR TUDO
    @GetMapping("all")
    public List<SugestoesEntity> listarTudo(){
        return sugestoesService.listaTudo() ;
    }
    //  POST - CRIAR COM DATA DE CRIAÇÃO
    @PostMapping
    public void criar(@RequestBody  SugestoesEntity sugestoesEntity){
        sugestoesEntity.setDataCriacao(LocalDateTime.now()); ;
        sugestoesService.criarSugestoes(sugestoesEntity);
    }
    //DELETE - DELETAR - ATRAVES DO BODY DA URL
    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id){
        sugestoesService.deletarSugestoes(id);
    }
    //PUT - ATUALIZAR - ALTERAR - USER
    @PutMapping
    public void alterar(@RequestBody SugestoesEntity sugestoesEntity){
        sugestoesEntity.setDataCriacao(LocalDateTime.now());
        sugestoesService.alterarSugestoes(sugestoesEntity);
    }

}
