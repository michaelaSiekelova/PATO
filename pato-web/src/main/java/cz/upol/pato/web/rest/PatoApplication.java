package cz.upol.pato.web.rest;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

import ch.xxx.carrental.ui.dto.CrDetail;
import ch.xxx.carrental.ui.dto.CrLogMsg;
import ch.xxx.carrental.ui.dto.CrMessage;
import ch.xxx.carrental.ui.dto.CrPeriod;
import ch.xxx.carrental.ui.dto.CrPortfolio;
import ch.xxx.carrental.ui.dto.CrTableRow;
import ch.xxx.carrental.ui.interceptor.JaxRsExceptionMapper;
import ch.xxx.carrental.ui.rest.model.CrDetailResource;
import ch.xxx.carrental.ui.rest.model.CrLogResource;
import ch.xxx.carrental.ui.rest.model.CrTableResource;
import io.swagger.jaxrs.config.BeanConfig;

@ApplicationPath("rest")
public class PatoApplication extends Application {

  public CrApplication() {
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
    classes.add(CrPortfolio.class);
    return classes;
  }

}
