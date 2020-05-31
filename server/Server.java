package server;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import rmiPeripherals.RmiInterface;

/**
 * @author Adrian Stoica
 * 
 * Server side that implements the RMI interface and creates the RMI registry
 *
 */
public class Server{
		
		public static void main(String[] args) {
			System.out.println("Starting the server...");
			System.setProperty("java.rmi.server.hostname", "192.168.0.12");
			try {
				RmiInterface questions = new QuestionImplementation();
				Registry reg = LocateRegistry.createRegistry(1890);

				reg.rebind("questions",questions);

				System.out.println("The server is running!");

			} catch (RemoteException e) {
				System.out.println("An error occured: "+e.toString()); 
				e.printStackTrace();
			}
			
		}
}
