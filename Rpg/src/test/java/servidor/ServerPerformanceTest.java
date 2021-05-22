package servidor;

import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.client.WebTarget;
import jakarta.ws.rs.core.GenericType;
import jakarta.ws.rs.core.MediaType;

import org.glassfish.grizzly.http.server.HttpServer;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.databene.contiperf.PerfTest;
import org.databene.contiperf.junit.ContiPerfRule;
import org.junit.experimental.categories.Category;

import categories.IntegrationTest;
import db.Estadisticas;


@Category(IntegrationTest.class)
public class ServerPerformanceTest {
	 
	@Rule public ContiPerfRule rule = new ContiPerfRule();
	
    private HttpServer server;
    private WebTarget target;
 
    @Before
    public void setUp() throws Exception {
        server = Server.startServer();
 
        Client c = ClientBuilder.newClient();
        target = c.target(Server.BASE_URI);
    }
 
    @After
    public void tearDown() throws Exception {
        server.stop();
    }
 
    /**
     * Test to see that the message "Got it!" is sent in the response.
     */
    @Test
    @PerfTest(invocations = 1000, threads = 40)
    public void testGetIt() {
        String responseMsg = target.path("myresource").request().get(String.class);
        assertEquals("Got it!", responseMsg);
    }
    
    @Test
    @PerfTest(invocations = 10, threads = 40)
    public void testEstadisticasResource() {
    	GenericType<List<Estadisticas>> genericType = new GenericType<List<Estadisticas>>() {};
        List<Estadisticas> real = target.path("estadisticas").request(MediaType.APPLICATION_JSON).get(genericType);
        assertEquals(0, real.size());
    }
}