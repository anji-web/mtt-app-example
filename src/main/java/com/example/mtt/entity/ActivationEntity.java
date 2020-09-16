package com.example.mtt.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
public class ActivationEntity {

    @Id
    @Column(name = "activation_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int activationId;
    private String token;
    private String status;
    private Date activationDate;
    private Date expiredDate;
    private Date createdDate;
    private Date modifiedDate;

    @OneToOne(targetEntity = UsersEntity.class, fetch = FetchType.EAGER)
    @JoinColumn(nullable = false, name = "user_id")
    private UsersEntity user;


    public int getActivationId() {
        return activationId;
    }

    public void setActivationId(int activationId) {
        this.activationId = activationId;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getActivationDate() {
        return activationDate;
    }

    public void setActivationDate(Date activationDate) {
        this.activationDate = activationDate;
    }

    public Date getExpiredDate() {
        return expiredDate;
    }

    public void setExpiredDate(Date expiredDate) {
        this.expiredDate = expiredDate;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(Date modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    public UsersEntity getUser() {
        return user;
    }

    public void setUser(UsersEntity user) {
        this.user = user;
    }
}
