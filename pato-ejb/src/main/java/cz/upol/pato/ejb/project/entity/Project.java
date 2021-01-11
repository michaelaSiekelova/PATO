package cz.upol.pato.ejb.project.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import cz.upol.pato.ejb.autentification.entity.User;
import cz.upol.pato.ejb.ticket.entity.Ticket;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Set;

@NamedQueries({
        @NamedQuery(name="Project.findProjectsByUserId", query="SELECT p FROM Project p where :id in (select u.id from p.users u)"),
        @NamedQuery(name="Project.findProjectById", query="SELECT p FROM Project p where p.id=:id"),
})

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Project implements Serializable {

    @Id
    @GeneratedValue
    private long id;

    private String name;

    private String key;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "project_user",
            joinColumns = @JoinColumn(name = "project_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id"))
    private Set<User> users;

    private Date createDate;
    private Date deadline;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "project")
    private Set<Ticket> tickets;

    @ColumnDefault("0")
    private int lastTicketNumber;

    @PrePersist
    private void prePersist(){
        createDate = new Date();
        lastTicketNumber = 0;
    }

    public long increaseLastTicketNumber(){
        return ++lastTicketNumber;
    }

}
