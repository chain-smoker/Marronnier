package com.chainsmoker.marronnier.admin.command.application.service;

import com.chainsmoker.marronnier.admin.command.application.dto.CreateAdminDTO;
import com.chainsmoker.marronnier.admin.command.domain.aggragate.entity.Admin;
import com.chainsmoker.marronnier.admin.command.domain.aggragate.entity.EnumType.AdminRole;
import com.chainsmoker.marronnier.admin.command.domain.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class RegistAdminService {

    private final AdminRepository adminRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public RegistAdminService(AdminRepository adminRepository, PasswordEncoder passwordEncoder) {
        this.adminRepository = adminRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public long create(CreateAdminDTO createAdminDTO) {
        Admin adminEntity = new Admin(
                createAdminDTO.getName(),
                AdminRole.ADMIN,
                passwordEncoder.encode(createAdminDTO.getPassword()),
                createAdminDTO.getLoginId()
        );

        Admin admin = adminRepository.save(adminEntity);
        return admin.getId();
    };
}
