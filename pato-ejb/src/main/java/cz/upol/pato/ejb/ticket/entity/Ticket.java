package cz.upol.pato.ejb.ticket.entity;

import cz.upol.pato.ejb.autentification.entity.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Ticket implements Serializable {

    @Id
    @GeneratedValue
    private long id;

    private String name;

    private Date createDate;

    @ManyToOne(fetch= FetchType.LAZY)
    @JoinColumn(name="create_user_id")
    private User createUser;

    private String definition;

}
