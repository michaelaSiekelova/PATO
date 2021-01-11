package cz.upol.pato.ejb.ticket.entity;

import cz.upol.pato.ejb.autentification.entity.User;
import cz.upol.pato.ejb.project.entity.Project;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@NamedQueries({
        @NamedQuery(name="Ticket.findTicketsByUserId", query="SELECT t FROM Ticket t where :userEmail=t.assignee"),
        @NamedQuery(name="Ticket.findTicketById", query="SELECT t FROM Ticket t where t.id=:id"),
})

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Ticket implements Serializable {

    @Id
    @GeneratedValue
    private long id;

    private String name;

    private String key;

    //TODO create enum
    private String type;

    private Date createDate;

    private Date deadline;

    private String createUser;

    private String assignee;

    private String description;

    @ManyToOne(fetch= FetchType.LAZY)
    private Project project;

    @PrePersist
    private void prePersist(){
        createDate = new Date();

    }
}
