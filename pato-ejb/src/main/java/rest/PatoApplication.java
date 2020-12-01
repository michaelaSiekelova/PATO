package rest;

import java.util.HashSet;
import java.util.Set;

import javax.servlet.ServletConfig;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.Context;

import cz.upol.pato.ejb.autentification.dto.UserDto;
import cz.upol.pato.ejb.autentification.rest.UserResource;
import io.swagger.jaxrs.config.BeanConfig;

@ApplicationPath("/pato-api")
public class PatoApplication extends Application {

  // http://localhost:8080/pato-ejb/pato-api/swagger.json


  @Override
  public Set<Class<?>> getClasses() {
    Set<Class<?>> classes = new HashSet<Class<?>>();
    classes.add(UserResource.class);
    classes.add(UserDto.class);
    classes.add(io.swagger.jaxrs.listing.ApiListingResource.class);
    classes.add(io.swagger.jaxrs.listing.SwaggerSerializers.class);
    return classes;
  }



}
