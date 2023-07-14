package com.chainsmoker.marronnier.admin.command.domain.aggragate.entity;

import com.chainsmoker.marronnier.admin.command.domain.aggragate.entity.vo.PasswordVO;
import com.chainsmoker.marronnier.admin.command.domain.aggragate.entity.EnumType.Role;
import lombok.Getter;

import javax.persistence.*;

@Entity
@Table(name="ADMIN_TB")
@Getter
public class Admin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 30)
    private String name;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Role role;

    @Embedded
    private PasswordVO password;

    @Column(name = "login_id")
    private String loginId;

    public Admin() {};

    public Admin(String name, Role role, PasswordVO password, String loginId) {
        this.name = name;
        this.role = role;
        this.password = password;
        this.loginId = loginId;
    }
}
