package com.page.demo.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "memberInfo")
@Data
public class Member {

    @Id // ID를 지정
    @GeneratedValue(strategy = GenerationType.IDENTITY) // ID값 Auto_increment을 위한 설정.
    private Long memberNo;

    private String id;
    private String name;

 
}
