package cz.upol.pato.ejb.autentification.rest;

import java.util.HashSet;
import java.util.Set;

import javax.servlet.ServletConfig;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.Context;

import cz.upol.pato.ejb.autentification.dto.UserDto;
import io.swagger.jaxrs.config.BeanConfig;

@ApplicationPath("/pato-api")
public class PatoApplication extends Application {

  // http://localhost:8080/pato-ejb/pato-api/swagger.json

  public PatoApplication(@Context ServletConfig servletConfig) {
    super();
    BeanConfig beanConfig = new BeanConfig();
    beanConfig.setVersion("1.0");
    beanConfig.setSchemes(new String[]{"http"});
    beanConfig.setHost("localhost:8090");
    beanConfig.setBasePath("/pato-api");
    beanConfig.setResourcePackage("cz.upol.pato.ejb.autentification.rest");
    beanConfig.setScan(true);
  }

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
