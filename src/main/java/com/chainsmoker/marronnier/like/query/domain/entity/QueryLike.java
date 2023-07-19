package com.chainsmoker.marronnier.like.query.domain.entity;


import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;


@Getter
public class QueryLike implements Serializable {
    long feedId;
    long memberId;
}
