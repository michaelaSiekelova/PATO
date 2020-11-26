package cz.upol.pato.ejb.autentification.beans;

import cz.upol.pato.ejb.autentification.api.AutentificationEJBLocal;
import cz.upol.pato.ejb.autentification.dto.UserDto;
import cz.upol.pato.ejb.autentification.entity.User;

import javax.ejb.Stateless;
import javax.enterprise.context.Dependent;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

@Dependent
public class AutentificationEJB implements AutentificationEJBLocal {

    private EntityManager em;

    public UserDto getCurrentUserProfile(){
        TypedQuery<User> query = em.createNamedQuery("User.findById", User.class);
        query.setParameter("id", 1L);
        return convertUser(query.getSingleResult());
    }

    private UserDto convertUser(User user){
        return new UserDto(user.getEmail());
    }
}
