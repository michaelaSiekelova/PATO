package cz.upol.pato.ejb.project.beans;

import com.google.gson.ExclusionStrategy;
import com.google.gson.FieldAttributes;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import cz.upol.pato.ejb.autentification.entity.User;
import cz.upol.pato.ejb.project.api.ProjectManagementEJBLocal;
import cz.upol.pato.ejb.project.dto.ProjectDto;
import cz.upol.pato.ejb.project.entity.Project;
import cz.upol.pato.ejb.project.rest.ProjectResource;
import cz.upol.pato.ejb.ticket.entity.Ticket;
import org.jboss.logging.Logger;

import javax.enterprise.context.Dependent;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;

@Dependent
public class ProjectManagementEJB implements ProjectManagementEJBLocal {

    Logger log = Logger.getLogger(ProjectManagementEJB.class.getName());

    @PersistenceContext
    EntityManager em;

    Gson gson = new GsonBuilder()
            .setExclusionStrategies(new ExclusionStrategy() {
                public boolean shouldSkipClass(Class<?> clazz) {
                    return (clazz == User.class || clazz == Ticket.class );
                }
                public boolean shouldSkipField(FieldAttributes f) {
                    return false;
                }
            })
            .setDateFormat("EEE, MMM d, ''yy")
            .create();

    public String getAllProjectsForUser(long userId){
        TypedQuery<Project> query = em.createNamedQuery("Project.findProjectsByUserId", Project.class);
        query.setParameter("id", userId);
        List<Project> result = query.getResultList();
        return gson.toJson(result);
    }

    public String getProjectDetail(long id){
        TypedQuery<Project> query = em.createNamedQuery("Project.findProjectById", Project.class);
        query.setParameter("id", id);
        Project result = query.getSingleResult();
        return gson.toJson(result);
    }

    @Transactional
    public String createProject(String name, String key){
        log.info("callingCreateProject");
        //ProjectDto newProjectDto = gson.fromJson(json, ProjectDto.class);
        Project newProject = new Project();
        newProject.setName(name);
        newProject.setKey(key);
        newProject.setDeadline(new Date());
        em.persist(newProject);
        return gson.toJson(newProject);
    }

    public Project getProject(long id){
        TypedQuery<Project> query = em.createNamedQuery("Project.findProjectById", Project.class);
        query.setParameter("id", id);
        Project result = query.getSingleResult();
        return result;
    }
}
