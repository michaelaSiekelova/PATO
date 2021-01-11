package cz.upol.pato.ejb.ticket.api;

public interface TicketManagementEJBLocal {

    String getAllTicketsForCurrentUser();

    String getTicketDetail(long id);

    String createTicket(String name, String description, long projectId);
}
