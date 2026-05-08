package OriginStore.API.OriginE_commerce.Dtos.Request;

import jakarta.validation.constraints.NotEmpty;

public record LoginRequest(@NotEmpty(message = "Email é obrigatorio") String email,
                           @NotEmpty(message = "Senha é obrigatorio") String senha) {
}
