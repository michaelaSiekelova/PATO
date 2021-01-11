package cz.upol.pato.ejb.metaAttribute.beans;

import com.google.gson.ExclusionStrategy;
import com.google.gson.FieldAttributes;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import cz.upol.pato.ejb.metaAttribute.api.MetaAttributeManagementEJBLocal;
import cz.upol.pato.ejb.metaAttribute.entity.MetaAttribute;
import cz.upol.pato.ejb.project.entity.Project;
import cz.upol.pato.ejb.utils.Enums;
import cz.upol.pato.ejb.utils.PatoException;

import javax.enterprise.context.Dependent;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.Map;

@Dependent
public class MetaAttributeManagementEJB implements MetaAttributeManagementEJBLocal {

    @PersistenceContext
    EntityManager em;

    Gson gson = new GsonBuilder()
            .setDateFormat("EEE, MMM d, ''yy")
            .create();


    @Override
    public void createMetaAttributeForProject(String name, String type, List<String> enumValues, long projectId) throws PatoException {
        MetaAttribute newAttr = new MetaAttribute();
        Enums.MetaAttrType enumType = Enums.MetaAttrType.getMetaAttributeType(type);
        if (enumType == null){
            throw new PatoException("Used meta attribute type does not exists.");
        }
        if (Enums.MetaAttrType.ENUM.equals(enumType) && (enumValues==null || enumValues.isEmpty())){
            throw new PatoException("Enum values have to be defined.");
        }
        newAttr.setEnumValues(enumValues);
        newAttr.setName(name);
        newAttr.setType(enumType);
        newAttr.setProjectId(projectId);
        em.persist(newAttr);
    }

    @Override
    public String getAllMetaAttributesForProject(long projectId) {
        TypedQuery<MetaAttribute> query = em.createNamedQuery("MetaAttribute.findAllForProject", MetaAttribute.class);
        query.setParameter("projectId", projectId);
        List<MetaAttribute> resultList = query.getResultList();
        return gson.toJson(resultList);
    }

    @Override
    public void deleteMetaAttribute(long metaAttrId) {
        MetaAttribute attr = em.find(MetaAttribute.class, metaAttrId);
        em.remove(attr);
    }

    @Override
    public void setMetaAttributeValueForTicket(long metaAttrValue, String stringValue, int numberValue, long longNumberValue, double doubleValue, List<String> enumValues, long ticketId) {
        
    }

    @Override
    public String getAllMetaAttrValuesForTicket(long ticketId) {
        //TODO
        return null;
    }
}
