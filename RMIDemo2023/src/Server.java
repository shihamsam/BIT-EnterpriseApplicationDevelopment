import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class Server extends ImplmyFirst {
    public Server() {
    }

    public static void main(String[] args) {
        try {

            ImplmyFirst obj = new ImplmyFirst();
            myFirst stub = (myFirst) UnicastRemoteObject.exportObject(obj,0);

            Registry registry = LocateRegistry.getRegistry();

            registry.bind("myFirst", stub);
            System.out.println("Server Ready!");

        }catch (Exception e){

            System.err.println("Server Exception: " + e.toString());
            e.printStackTrace();
        }

    }

}
