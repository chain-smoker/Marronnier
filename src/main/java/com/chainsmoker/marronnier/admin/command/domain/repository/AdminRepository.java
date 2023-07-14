package com.chainsmoker.marronnier.admin.command.domain.repository;

import com.chainsmoker.marronnier.admin.command.domain.aggragate.entity.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Long> {
    Admin findAdminByLoginId(String loginId);
}
