package imperium_sistema.controller;

import imperium_sistema.model.dto.LoginRequest;
import imperium_sistema.model.dto.UserDto;
import imperium_sistema.model.entity.UserEntity;
import imperium_sistema.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/auth")
public class AuthController {

    /* INJEÇÃO DE DEPENDENCIA */
    private UserService userService ;

    public AuthController(UserService userService){
        this.userService = userService ;
    }

    /*  ENDPOINT PARA LOGAR */
    @PostMapping
    public ResponseEntity<?> verificarLogin(@RequestBody LoginRequest loginRequest) {
        UserEntity user = userService.validarLogin(loginRequest.getEmail(), loginRequest.getSenha());

        if (user == null || user.getRoles() == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                    .body("Usuário ou senha inválidos!");
        }

        return ResponseEntity.ok(new UserDto(user));
    }



}
