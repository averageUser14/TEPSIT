package applicationRest;
import javax.ws.rs.ApplicationPath;

import org.glassfish.jersey.server.ResourceConfig;


@ApplicationPath("api")
public class applicationRest extends ResourceConfig {
    public applicationRest() {
        packages("applicationRest");
    }
}