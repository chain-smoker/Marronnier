package com.chainsmoker.marronnier.admin.command.application.service;

import com.chainsmoker.marronnier.admin.command.application.dto.CreateAdminDTO;
import com.chainsmoker.marronnier.admin.command.domain.aggragate.entity.Admin;
import com.chainsmoker.marronnier.admin.command.domain.aggragate.entity.EnumType.Role;
import com.chainsmoker.marronnier.admin.command.domain.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegistAdminService {

    private final AdminRepository adminRepository;

    @Autowired
    public RegistAdminService(AdminRepository adminRepository) {
        this.adminRepository = adminRepository;
    }

    public long create(CreateAdminDTO createAdminDTO) {
        Admin adminEntity = new Admin(
                createAdminDTO.getName(),
                Role.ADMIN,
                createAdminDTO.getPassword(),
                createAdminDTO.getLoginId()
        );

        Admin admin = adminRepository.save(adminEntity);
        return admin.getId();
    };
}
