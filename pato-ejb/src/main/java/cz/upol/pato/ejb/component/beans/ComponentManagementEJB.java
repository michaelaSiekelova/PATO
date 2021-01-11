package cz.upol.pato.ejb.component.beans;

import cz.upol.pato.ejb.component.api.ComponentManagementEJBLocal;

public class ComponentManagementEJB implements ComponentManagementEJBLocal {


    @Override
    public String getComponents(long entityId, boolean ticketEntity) {
        //TODO
        return null;
    }

    @Override
    public String createComponent(long entityId, boolean ticketEntity, String name, long userId, byte[] content) {
        //TODO
        return null;
    }
}
