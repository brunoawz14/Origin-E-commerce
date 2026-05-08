package OriginStore.API.OriginE_commerce.Controller;


import OriginStore.API.OriginE_commerce.Dtos.Request.LoginRequest;
import OriginStore.API.OriginE_commerce.Dtos.Request.RegisterUserRequest;
import OriginStore.API.OriginE_commerce.Dtos.Response.LoginResponse;
import OriginStore.API.OriginE_commerce.Dtos.Response.RegisterUserResponse;
import OriginStore.API.OriginE_commerce.Entity.User;
import OriginStore.API.OriginE_commerce.Repository.UserRepository;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final UserRepository userRepository;

    public AuthController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@Valid @RequestBody LoginRequest request) {
        return null;
    }

    @PostMapping("/Register")
    public ResponseEntity<RegisterUserResponse> register(@Valid @RequestBody RegisterUserRequest request) {
        User newUser  = new User();
        newUser.setSenha(request.senha());
        newUser.setEmail(request.email());
        newUser.setNome(request.nome());

        userRepository.save(newUser);
// o que ele vai retornar para o usuario
        return ResponseEntity.status(HttpStatus.CREATED).body(new RegisterUserResponse(newUser.getNome(), newUser.getEmail()));
    }

}
