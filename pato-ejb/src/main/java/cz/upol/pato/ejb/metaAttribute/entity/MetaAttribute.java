package cz.upol.pato.ejb.metaAttribute.entity;

import cz.upol.pato.ejb.utils.Enums;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@NamedQueries({
        @NamedQuery(name="MetaAttribute.findAllForProject", query="SELECT a FROM MetaAttribute a where :projectId=a.projectId"),
})

@Entity
@Getter
@Setter
@NoArgsConstructor
public class MetaAttribute {

    @Id
    @GeneratedValue
    private long id;

    private long projectId;

    private String name;

    private String enumValues;

    private Enums.MetaAttrType type;

    private Date createDate;

    @PrePersist
    private void prePersist(){
        createDate = new Date();

    }

    public List<String> getEnumValuesAsList(){
        List<String> result = new ArrayList<>();
        if(enumValues!=null && !enumValues.isEmpty()){
            result = Arrays.asList(enumValues.split(","));
        }
        return result;
    }

    public void setEnumValues (List<String> enumValues){
        String result = "";
        for (String value : enumValues){
            result += value + ",";
        }
        this.enumValues = result;
    }
}
