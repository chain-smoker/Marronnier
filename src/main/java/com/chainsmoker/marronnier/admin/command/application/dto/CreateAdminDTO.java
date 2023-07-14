package com.chainsmoker.marronnier.admin.command.application.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateAdminDTO {
    private String loginId;
    private String password;
    private String name;

    public CreateAdminDTO(String loginId, String password, String name) {
        this.loginId = loginId;
        this.password = password;
        this.name = name;
    }

    @Override
    public String toString() {
        return "CreateAdminDTO{" +
                "loginId=" + loginId +
                ", password=" + password +
                ", name='" + name + '\'' +
                '}';
    }
}
