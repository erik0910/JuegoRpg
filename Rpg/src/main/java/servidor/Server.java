package servidor;

import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;
import java.io.IOException;
import java.net.URI;
/**
 * Clase server
 *
 */

//http://localhost:8080/myapp/myresource

public class Server {
	  // Base URI the Grizzly HTTP server will listen on
    public static final String BASE_URI = "http://localhost:8080/rpg/";

    /**
     * Inicia Grizzly HTTP server exponiendo los recursos JAX-RS  definidos en esta aplicacion.
     * @return Grizzly HTTP server.
     */
    public static HttpServer startServer() {
        // create a resource config that scans for JAX-RS resources and providers
        // in servidor package
        final ResourceConfig rc = new ResourceConfig().packages("servidor");

        // create and start a new instance of grizzly http server
        // exposing the Jersey application at BASE_URI
        return GrizzlyHttpServerFactory.createHttpServer(URI.create(BASE_URI), rc);
    }

    /**
     * Metodo principal.
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        final HttpServer server = startServer();
        System.out.println(String.format("Jersey app started with WADL available at "
                + "%sapplication.wadl\nHit enter to stop it...", BASE_URI));
        System.in.read();
        server.stop();
    }
}
