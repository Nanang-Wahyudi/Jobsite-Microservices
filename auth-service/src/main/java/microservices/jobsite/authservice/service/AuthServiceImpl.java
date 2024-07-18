package microservices.jobsite.authservice.service;

import lombok.extern.slf4j.Slf4j;
import microservices.jobsite.authservice.client.UserClient;
import microservices.jobsite.authservice.entity.Role;
import microservices.jobsite.authservice.entity.User;
import microservices.jobsite.authservice.model.enums.RoleEnum;
import microservices.jobsite.authservice.model.request.CreateUserDetailAndCompanyRequest;
import microservices.jobsite.authservice.model.request.RegisterRequest;
import microservices.jobsite.authservice.repository.RoleRepository;
import microservices.jobsite.authservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Collections;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;

@Slf4j
@Service
public class AuthServiceImpl implements AuthService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private UserClient userClient;


    @Async
    @Override
    public CompletableFuture<Void> register(RegisterRequest request, RoleEnum roleName) {
        try {
            log.info("Register method started for username: {} (Thread: {})", request.getUsername(), Thread.currentThread().getName());

            Optional<Role> roleOptional = roleRepository.findByName(roleName);
            if (roleOptional.isEmpty()) {
                throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Role not found: " + roleName);
            }
            Role role = roleOptional.get();

            User user = User.builder()
                    .username(request.getUsername())
                    .email(request.getEmail())
                    .password(request.getPassword())
                    .roles(Collections.singletonList(role))
                    .build();
            userRepository.save(user);

            if (role.getName().equals(RoleEnum.COMPANY)) {
                CreateUserDetailAndCompanyRequest companyRequest = CreateUserDetailAndCompanyRequest.builder()
                        .name(request.getName())
                        .userId(user.getId())
                        .build();
                userClient.createCompany(companyRequest);
            } else {
                CreateUserDetailAndCompanyRequest userDetailRequest = CreateUserDetailAndCompanyRequest.builder()
                        .name(request.getName())
                        .userId(user.getId())
                        .build();
                userClient.createUserDetail(userDetailRequest);
            }

            log.info("Register method completed for username: {} (Thread: {})", request.getUsername(), Thread.currentThread().getName());
            return CompletableFuture.completedFuture(null);

        } catch (Exception ex) {
            log.error("Error in register for username: {} (Thread: {})", request.getUsername(), Thread.currentThread().getName(), ex);
            throw ex;
        }
    }

}
