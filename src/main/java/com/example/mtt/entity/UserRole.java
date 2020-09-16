package com.example.mtt.entity;

import javax.persistence.*;

@Entity
@Table(name = "user_role")
public class UserRole {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @OneToOne(targetEntity = UsersEntity.class, fetch = FetchType.EAGER)
    @JoinColumn(nullable = false, name = "user_id")
    private UsersEntity userId;

    @OneToOne(targetEntity = RoleEntity.class, fetch = FetchType.EAGER)
    @JoinColumn(nullable = false, name = "role_id")
    private RoleEntity roleEntity;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public UsersEntity getUserId() {
        return userId;
    }

    public void setUserId(UsersEntity userId) {
        this.userId = userId;
    }

    public RoleEntity getRoleEntity() {
        return roleEntity;
    }

    public void setRoleEntity(RoleEntity roleEntity) {
        this.roleEntity = roleEntity;
    }
}
