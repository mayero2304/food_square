package com.mciro.food_square.infrastructure.output.entity;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "users")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 50)
    private String name;

    @Column(length = 50)
    private String lastname;

    @Column
    private Integer nit;

    @Column
    private String phone;

    @Column(nullable = false)
    private String email;

    @Column
    private String password;

    private Long role_id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "role_id",insertable = false, updatable = false, referencedColumnName = "id")
    private RoleEntity role;

}
