package microservices.jobsite.authservice.service;

import microservices.jobsite.authservice.model.enums.RoleEnum;
import microservices.jobsite.authservice.model.request.RegisterRequest;

import java.util.concurrent.CompletableFuture;

public interface AuthService {

    CompletableFuture<Void> register(RegisterRequest request, RoleEnum roleName);

}
