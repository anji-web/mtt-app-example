package com.example.mtt.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "user_profile")
public class UserProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idUser;

    private String firstName;
    private String lastName;
    private String picture;
    private Date createdDate;
    private Date modifiedDate;
    private int createdBy;

    @OneToOne(targetEntity = UsersEntity.class, fetch = FetchType.EAGER)
    @JoinColumn(nullable = false, name = "user_id")
    private UsersEntity users;


}
