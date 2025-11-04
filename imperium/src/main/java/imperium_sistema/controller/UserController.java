package imperium_sistema.controller;

import imperium_sistema.model.dto.UserCreateDto;
import imperium_sistema.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin
@RestController
@RequestMapping("/usuarios")
public class UserController {
    /* INJEÇÃO DE DEPENDENCIAS */
    private UserService userService;

    public UserController(UserService userService){
        this.userService = userService ;
    }

    /* REQUISIÇÃO HTTP POST VIA CORPO JSON*/
    @PostMapping
    public void create(@RequestBody UserCreateDto user){
        userService.create(user);
    }

    /* REQUISIÇÃO HTTP GET RETORNA TODOS USUARIOS */
    @GetMapping
    public List<UserCreateDto> read(){
        return userService.listAll() ;
    }

    /* REQUISIÇÃO HTTP GET POR ID VIA URL */
    @GetMapping("/{id}")
    public UserCreateDto getById(@PathVariable Long id){
        return userService.findId(id) ;
    }

    /* REQUISIÇÃO HTTP PUT PARA ALTERAR USUARIO POR ID VIA URL */
    @PutMapping("/{id}")
    public ResponseEntity<UserCreateDto> updateUser(@PathVariable Long id, @RequestBody UserCreateDto userCreateDto) {
        try {
            UserCreateDto atualizado = userService.update(id, userCreateDto);
            return ResponseEntity.ok(atualizado);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    /* REQUISIÇÃO HTTP DELETE PARA DEETAR USUARIO POR ID VIA URL */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Long id){
        userService.delete(id) ;
        return ResponseEntity.ok().build() ;
    }


}
