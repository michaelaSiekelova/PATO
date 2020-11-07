package cz.upol.pato.ejb.permitions.entity;

import cz.upol.pato.ejb.project.entity.Project;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class ProjectRole extends Role implements Serializable {

    @Id
    @GeneratedValue
    private long id;

}
