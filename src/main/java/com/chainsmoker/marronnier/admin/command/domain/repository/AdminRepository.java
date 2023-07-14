package com.chainsmoker.marronnier.admin.command.domain.repository;

import com.chainsmoker.marronnier.admin.command.domain.aggragate.entity.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepository extends JpaRepository<Admin, Long> {
}
