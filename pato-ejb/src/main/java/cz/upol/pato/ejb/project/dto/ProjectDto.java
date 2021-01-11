package cz.upol.pato.ejb.project.dto;

import cz.upol.pato.ejb.autentification.dto.UserDto;
import cz.upol.pato.ejb.autentification.entity.User;
import cz.upol.pato.ejb.ticket.entity.Ticket;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProjectDto {
    private long id;

    private String name;

    private String key;


}
