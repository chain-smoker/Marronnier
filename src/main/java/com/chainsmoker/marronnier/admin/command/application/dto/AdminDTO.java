package com.chainsmoker.marronnier.admin.command.application.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AdminDTO {
    private String loginId;
    private String name;

    public AdminDTO(String loginId, String name) {
        this.loginId = loginId;
        this.name = name;
    }

    public String getLoginId() {
        return loginId;
    }

    public void setLoginId(String loginId) {
        this.loginId = loginId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "AdminDTO{" +
                "loginId='" + loginId + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
