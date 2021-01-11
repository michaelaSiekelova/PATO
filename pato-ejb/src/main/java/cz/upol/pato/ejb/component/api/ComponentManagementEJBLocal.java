package cz.upol.pato.ejb.component.api;

public interface ComponentManagementEJBLocal {

    String getComponents (long entityId, boolean ticketEntity);

    String createComponent (long entityId, boolean ticketEntity, String name, long userId, byte[] content);
}
