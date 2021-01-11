package cz.upol.pato.ejb.autentification.beans;

import cz.upol.pato.ejb.autentification.api.AutentificationEJBLocal;
import cz.upol.pato.ejb.autentification.dto.UserDto;
import cz.upol.pato.ejb.autentification.entity.User;
import cz.upol.pato.ejb.autentification.rest.UserResource;
import org.jboss.logging.Logger;

import javax.ejb.Stateless;
import javax.enterprise.context.Dependent;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

@Dependent
public class AutentificationEJB implements AutentificationEJBLocal {

    Logger log = Logger.getLogger(AutentificationEJB.class.getName());

    @PersistenceContext
    private EntityManager em;

    public UserDto getCurrentUserProfile(String email){
        TypedQuery<User> query = em.createNamedQuery("User.findByEmail", User.class);
        query.setParameter("email", email);
        User result = query.getSingleResult();
        log.info(result.getEmail() + " = " + result.getId());
        return convertUser(result);
    }

    private UserDto convertUser(User user){
        return new UserDto(user.getEmail(), user.getId());
    }
}
