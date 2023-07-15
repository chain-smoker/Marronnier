package com.chainsmoker.marronnier.member.query.application.dto;

import com.chainsmoker.marronnier.member.command.domain.aggregate.entity.EnumType.GenderEnum;
import com.chainsmoker.marronnier.member.command.domain.aggregate.entity.EnumType.Role;
import lombok.Getter;

import java.time.LocalDate;

@Getter
public class FindMemberDTO {
    private final Long id;
    private final String name;
    private final String address;
    private final GenderEnum gender;
    private final LocalDate birthDate;
    private final Role role;

    public static Builder builder(Long id, String name, String address, GenderEnum gender, LocalDate birthDate, Role role) {
        return new Builder(id, name, address, gender, birthDate, role);
    }

    private FindMemberDTO(Builder builder) {
        this.id = builder.id;
        this.name = builder.name;
        this.address = builder.address;
        this.gender = builder.gender;
        this.birthDate = builder.birthDate;
        this.role = builder.role;
    }

    public static class Builder {
        private final Long id;
        private final String name;
        private final String address;
        private final GenderEnum gender;
        private final LocalDate birthDate;
        private final Role role;

        public Builder(Long id, String name, String address, GenderEnum gender, LocalDate birthDate, Role role) {
            this.id = id;
            this.name = name;
            this.address = address;
            this.gender = gender;
            this.birthDate = birthDate;
            this.role = role;
        }

        public FindMemberDTO build() {
            return new FindMemberDTO(this);
        }
    }

    @Override
    public String toString() {
        return "SessionUser{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
