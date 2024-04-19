import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class Server extends Calculator {

	public static void main(String[] args) {
		try {
			
			Calculator calc = new Calculator();
			 
			ICalculator stub = (ICalculator) UnicastRemoteObject.exportObject(calc,10990);
			
			Registry registry = LocateRegistry.createRegistry(10990);
            registry.bind("icalc", stub);
            System.out.println("Server Ready!");
            
            
			
		}catch(Exception ex) {
			System.out.println(ex);
		}
	}
}
