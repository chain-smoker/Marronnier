package com.chainsmoker.marronnier.admin.command.domain.aggragate.entity.vo;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
@Embeddable
public class PasswordVO {
    @Column(nullable = false, name = "password")
    private String value;

    public PasswordVO(String value) {

        MessageDigest md = null;
        try {
            md = MessageDigest.getInstance("SHA-256");
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
        md.update((value).getBytes());
        byte[] pwdSalt = md.digest();

        StringBuffer pwdSb = new StringBuffer();
        for(byte b : pwdSalt) {
            pwdSb.append(String.format("%02x", b));
        }
        this.value = pwdSb.toString();
    }

    protected PasswordVO() {}

    public String getValue() {
        return this.value;
    }
}
