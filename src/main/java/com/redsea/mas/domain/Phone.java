package com.redsea.mas.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;


@Data
@Entity
public class Phone implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    public Phone(Integer area, Integer prefix,Integer numbers){
        this.area=area;
        this.prefix=prefix;
        this.numbers=numbers;
    }
    public Phone(){}
    private Integer prefix;
    private Integer area;
    private Integer numbers;
}
