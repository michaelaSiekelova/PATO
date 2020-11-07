package cz.upol.pato.ejb.autentification.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import cz.upol.pato.ejb.permitions.entity.Role;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "APP_USER")
public class User implements Serializable {

    @Id
    @GeneratedValue
    private long id;

    private String email;

    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
            name = "User_Role",
            joinColumns = { @JoinColumn(name = "user_id") },
            inverseJoinColumns = { @JoinColumn(name = "role_id") }
    )
    private List<Role> roles;
}
