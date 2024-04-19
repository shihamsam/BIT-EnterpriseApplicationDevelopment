import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

public class Client {
    public Client() {
    }

    public static void main(String[] args) {
        try{
            Registry registry= LocateRegistry.getRegistry();

            myFirst stub = (myFirst) registry.lookup("myFirst");

            Scanner myscan = new Scanner(System.in);

            System.out.println("Enter X:");
            int x = myscan.nextInt();

            System.out.println("Enter Y:");
            int y = myscan.nextInt();

            int ans = stub.calc(x,y);

            System.out.println("Answer = " + ans);



        }catch (Exception e){

            System.err.println("Client Exception: " + e.toString());
            e.printStackTrace();
        }
    }
}
