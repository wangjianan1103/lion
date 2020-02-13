package com.core.lion.model.entity;

import com.core.lion.model.entity.base.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;

@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Data
@Entity
public class LogUserSubscribe extends BaseEntity {
    @Column(length = 64)
    private String openId = "";
    @Column(length = 64)
    private String unionId = "";
    @Column()
    private Integer subscribeType = 0;

}