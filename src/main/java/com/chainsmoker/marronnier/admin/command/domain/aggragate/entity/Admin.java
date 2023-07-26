package com.chainsmoker.marronnier.admin.command.domain.aggragate.entity;

import com.chainsmoker.marronnier.admin.command.domain.aggragate.entity.EnumType.AdminRole;
import lombok.Getter;

import javax.persistence.*;

@Entity
@Table(name="ADMIN_TB")
@Getter
public class Admin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 30, nullable = false ,unique = true)
    private String name;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private AdminRole role;

    @Column(nullable = false)
    private String password;

    @Column(name = "login_id", nullable = false ,unique = true)
    private String loginId;

    public Admin() {}

    public Admin(String name, AdminRole role, String password, String loginId) {
        this.name = name;
        this.role = role;
        this.password = password;
        this.loginId = loginId;
    }

    @Override
    public String toString() {
        return "Admin{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", role=" + role +
                ", password=" + password +
                ", loginId='" + loginId + '\'' +
                '}';
    }
}
