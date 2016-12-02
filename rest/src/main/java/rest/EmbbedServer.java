package rest;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.glassfish.grizzly.http.server.HttpServer;

import com.sun.jersey.api.container.grizzly2.GrizzlyServerFactory;
import com.sun.jersey.api.core.ClassNamesResourceConfig;
import com.sun.jersey.api.core.ResourceConfig;

public class EmbbedServer {

	public static String REST_SERVICE = "http://localhost/";

	public static void main(String[] args) {

		System.out.println("EmbbedServer.main()");
		
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("spu");
        EntityManager manager = factory.createEntityManager();
        
        manager.find(Pessoa.class, 1L);
		
		
		
		
		ServiceResource sr = new ServiceResource();
		System.out.println("EmbbedServer.main:" + sr);
		HttpServer server = null;

		try {
			
			ResourceConfig rc = new ClassNamesResourceConfig(ServiceResource.class.getName());
			
			server = GrizzlyServerFactory.createHttpServer("http://localhost:5555",rc);
			System.out.println("Press any key to stop the service...");
			System.in.read();
		} catch (Throwable e) {
			e.printStackTrace();
		}

		finally {
			try {
				if (server != null) {
					server.stop();
				}
			} finally {
				;
			}
		}

	}
}
