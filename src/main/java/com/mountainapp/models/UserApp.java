package com.mountainapp.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;


@AllArgsConstructor
@NoArgsConstructor
@Entity
@Data
@Table(name = "user")
public class UserApp {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Integer id;

    private String name;
    private String password;
    private int active;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "user_role",
            joinColumns= @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id") )

    private Set<Role> roles;
}
