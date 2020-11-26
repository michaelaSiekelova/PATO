package cz.upol.pato.web.rest;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

import cz.upol.pato.web.rest.model.UserResource;
import io.swagger.jaxrs.config.BeanConfig;

@ApplicationPath("rest")
public class PatoApplication extends Application {

  public PatoApplication() {
    BeanConfig beanConfig = new BeanConfig();
    beanConfig.setVersion("1.0");
    beanConfig.setSchemes(new String[]{"http"});
    beanConfig.setHost("localhost:8090");
    beanConfig.setBasePath("/pato-/rest");
    beanConfig.setResourcePackage("cz.upol.pato.web.rest.model");
    beanConfig.setScan(true);
  }

  @Override
  public Set<Class<?>> getClasses() {
    Set<Class<?>> classes = new HashSet<Class<?>>();
    classes.add(UserResource.class);
    return classes;
  }

}
