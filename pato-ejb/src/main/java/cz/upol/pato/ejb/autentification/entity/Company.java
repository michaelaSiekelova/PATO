package cz.upol.pato.ejb.autentification.entity;

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
public class Company implements Serializable {

    @Id
    @GeneratedValue
    private long id;

    private String name;

}
