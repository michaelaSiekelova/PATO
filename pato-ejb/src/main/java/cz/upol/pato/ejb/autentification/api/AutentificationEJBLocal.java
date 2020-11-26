package cz.upol.pato.ejb.autentification.api;


import cz.upol.pato.ejb.autentification.dto.UserDto;

import javax.ejb.Local;

@Local
public interface AutentificationEJBLocal {

    UserDto getCurrentUserProfile();
}
