package cz.upol.pato.ejb.metaAttribute.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@NamedQueries({
        @NamedQuery(name="MetaAttributeValue.", query="SELECT v FROM MetaAttributeValue v where "),
})

@Entity
@Getter
@Setter
@NoArgsConstructor
public class MetaAttributeValue {

    @Id
    @GeneratedValue
    private long id;

    private long ticketId;

    private long metaAttributeId;

    private String stringValue;

    private long longNumberValue;

    private int numberValue;

    private double doubleValue;
}
