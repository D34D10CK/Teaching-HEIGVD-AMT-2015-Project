package ch.heigvd.amt.amtproject.rest.config;

import java.util.Set;
import javax.ws.rs.core.Application;
import org.glassfish.jersey.jackson.JacksonFeature;

/**
 *
 * @author Olivier Liechti
 */
@javax.ws.rs.ApplicationPath("api")
public class ApplicationConfig extends Application {

  @Override
  public Set<Class<?>> getClasses() {
    Set<Class<?>> resources = new java.util.HashSet<>();
    addRestResourceClasses(resources);
    
    resources.add(JacksonFeature.class);
    return resources;
  }

  /**
   * Do not modify addRestResourceClasses() method.
   * It is automatically populated with
   * all resources defined in the project.
   * If required, comment out calling this method in getClasses().
   */
  private void addRestResourceClasses(Set<Class<?>> resources) {
    resources.add(ch.heigvd.amt.amtproject.rest.config.JacksonConfigurationProvider.class);
    resources.add(ch.heigvd.amt.amtproject.rest.config.JsonExceptionMapper.class);
        resources.add(ch.heigvd.amt.amtproject.rest.resources.BadgesResource.class);
        resources.add(ch.heigvd.amt.amtproject.rest.resources.EndUserResource.class);
        resources.add(ch.heigvd.amt.amtproject.rest.resources.EventResource.class);
        resources.add(ch.heigvd.amt.amtproject.rest.resources.LevelRessource.class);
        resources.add(ch.heigvd.amt.amtproject.rest.resources.ReputationRessource.class);
  }

}
