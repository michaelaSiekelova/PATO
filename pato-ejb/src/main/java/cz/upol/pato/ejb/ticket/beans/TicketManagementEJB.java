package cz.upol.pato.ejb.ticket.beans;

import com.google.gson.ExclusionStrategy;
import com.google.gson.FieldAttributes;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import cz.upol.pato.ejb.autentification.entity.User;
import cz.upol.pato.ejb.project.api.ProjectManagementEJBLocal;
import cz.upol.pato.ejb.project.beans.ProjectManagementEJB;
import cz.upol.pato.ejb.project.entity.Project;
import cz.upol.pato.ejb.ticket.api.TicketManagementEJBLocal;
import cz.upol.pato.ejb.ticket.entity.Ticket;
import io.swagger.util.Json;
import org.jboss.logging.Logger;

import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

@Dependent
public class TicketManagementEJB implements TicketManagementEJBLocal {

    Logger log = Logger.getLogger(TicketManagementEJB.class.getName());

    Gson gson = new GsonBuilder()
            .setExclusionStrategies(new ExclusionStrategy() {
                public boolean shouldSkipClass(Class<?> clazz) {
                    return (clazz == Project.class);
                }
                public boolean shouldSkipField(FieldAttributes f) {
                    return false;
                }
            })
            .setDateFormat("EEE, MMM d, ''yy")
            .create();

    @PersistenceContext
    EntityManager em;

    @Inject
    ProjectManagementEJBLocal projectEJB;

    public String getAllTicketsForCurrentUser(){
        TypedQuery<Ticket> query = em.createNamedQuery("Ticket.findTicketsByUserId", Ticket.class);
        //todo find current user email
        query.setParameter("userEmail", "m.siekelova@gmail.com");

        return gson.toJson(query.getResultList());
    }

    public String getTicketDetail(long id){
        TypedQuery<Ticket> query = em.createNamedQuery("Ticket.findTicketById", Ticket.class);
        query.setParameter("id", id);
        Ticket result = query.getSingleResult();
        return gson.toJson(result);
    }

    @Transactional
    public String createTicket(String name, String description, long projectId){
        Project project = projectEJB.getProject(projectId);
        Ticket newTicket = new Ticket();
        newTicket.setName(name);
        newTicket.setDescription(description);
        newTicket.setKey(project.getKey() + "-" + project.increaseLastTicketNumber());
        newTicket.setProject(project);
        em.persist(newTicket);
        return gson.toJson(newTicket);
    }
}
