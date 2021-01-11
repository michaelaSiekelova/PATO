package cz.upol.pato.ejb.autentification.entity;

import cz.upol.pato.ejb.project.entity.Project;
import cz.upol.pato.ejb.ticket.entity.Ticket;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import cz.upol.pato.ejb.permitions.entity.Role;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Set;

@NamedQueries({
        @NamedQuery(name="User.findById", query="SELECT u FROM User u where u.id=:id"),
        @NamedQuery(name="User.findByEmail", query="SELECT u FROM User u where u.email=:email"),
        @NamedQuery(name="User.findProjectsByUserId", query="SELECT u.projects FROM User u where u.id=:id"),
})


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

    private byte[] userAvatar;


    @ManyToMany(fetch = FetchType.EAGER, mappedBy = "users")
    Set<Project> projects;

}
