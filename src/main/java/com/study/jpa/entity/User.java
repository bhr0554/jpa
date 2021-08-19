package com.study.jpa.entity;

import com.study.jpa.entity.enums.Gender;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table
@Getter
@Setter
public class User {

    @Id
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long user_id;

    @Column(nullable = false, length = 50)
    private String email;

    @Column(nullable = false, length = 20)
    private String password;

    @Column(nullable = false, length = 20)
    private String name;

    @Column
    private LocalDate birth;

    @Column(nullable = false, length = 20)
    private String cell_phone;

    @Enumerated(EnumType.STRING)
    @Column(nullable = true)
    private Gender gender;

}
