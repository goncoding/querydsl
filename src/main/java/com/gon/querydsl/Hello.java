package com.gon.querydsl;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
@NoArgsConstructor
public class Hello {

    @Id @GeneratedValue
    private Long id;

    private String name;

    public Hello(String name) {
        this.name = name;
    }
}
