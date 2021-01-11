package cz.upol.pato.ejb.metaAttribute.api;

import cz.upol.pato.ejb.utils.PatoException;

import java.util.List;
import java.util.Map;

public interface MetaAttributeManagementEJBLocal {

    void createMetaAttributeForProject (String name, String type, List<String> enumValues, long projectId) throws PatoException;

    String getAllMetaAttributesForProject (long projectId);

    void deleteMetaAttribute (long metaAttrId);

    void setMetaAttributeValueForTicket (long metaAttrValue, String stringValue, int numberValue, long longNumberValue, double doubleValue, List<String> enumValues, long ticketId);

    String getAllMetaAttrValuesForTicket (long ticketId);
}
