package microservices.jobsite.authservice.config;

import lombok.extern.slf4j.Slf4j;
import microservices.jobsite.authservice.entity.Privilege;
import microservices.jobsite.authservice.entity.Role;
import microservices.jobsite.authservice.model.enums.PrivilegeEnum;
import microservices.jobsite.authservice.model.enums.RoleEnum;
import microservices.jobsite.authservice.repository.PrivilegeRepository;
import microservices.jobsite.authservice.repository.RoleRepository;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;

import java.util.ArrayList;
import java.util.Optional;

@Slf4j
@DependsOn("roleConfig")
@Configuration
public class PrivilegeConfig {

    PrivilegeConfig(PrivilegeRepository privilegeRepository, RoleRepository roleRepository) {
        log.info("Checking Privilege Config Log Presented");

        Role adminRole = roleRepository.findByName(RoleEnum.ADMIN)
                .orElseThrow(() -> new IllegalStateException("Role ADMIN not found"));
        Role userRole = roleRepository.findByName(RoleEnum.USER)
                .orElseThrow(() -> new IllegalStateException("Role USER not found"));
        Role companyRole = roleRepository.findByName(RoleEnum.COMPANY)
                .orElseThrow(() -> new IllegalStateException("Role USER not found"));

        for (PrivilegeEnum pe : PrivilegeEnum.values()) {
            Optional<Privilege> existingPrivilege = privilegeRepository.findByName(pe);
            if (existingPrivilege.isPresent()) {
                log.info("Privilege {} Has Been Found!", pe);
            }

            if (existingPrivilege.isEmpty()) {
                Privilege newPrivilege = Privilege.builder()
                        .name(pe)
                        .roles(new ArrayList<>())
                        .build();

                if (pe.name().contains("ADMIN")) {
                    newPrivilege.getRoles().add(adminRole);
                    adminRole.getPrivileges().add(newPrivilege);
                    log.info("Privilege {} has been associated with role ADMIN", pe);

                } else if (pe.name().contains("USER")) {
                    newPrivilege.getRoles().add(userRole);
                    userRole.getPrivileges().add(newPrivilege);
                    log.info("Privilege {} has been associated with role USER", pe);

                } else if (pe.name().contains("COMPANY")) {
                    newPrivilege.getRoles().add(companyRole);
                    companyRole.getPrivileges().add(newPrivilege);
                    log.info("Privilege {} has been associated with role USER", pe);
                }

                log.info("Privilege {} is Not Found, Inserting to DB . . .", pe);
                privilegeRepository.save(newPrivilege);
            }
        }

        log.info("Entering Changes to DB Transaction Role and Privilege . . .");
        roleRepository.save(adminRole);
        roleRepository.save(userRole);
        roleRepository.save(companyRole);
    }

}
