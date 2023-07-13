package com.chainsmoker.marronnier.admin.command.application.dto;

import com.chainsmoker.marronnier.admin.command.domain.aggragate.entity.vo.PasswordVO;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateAdminDTO {
    private String loginId;
    private PasswordVO password;
    private String name;

    public CreateAdminDTO(String loginId, String password, String name) {
        this.loginId = loginId;
        this.password = new PasswordVO(password);
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
