import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

public class Client {

	public static void main(String[] args) {
		 try {
			 
		 Registry registry= LocateRegistry.getRegistry("localhost", 10990);
		 
		ICalculator stub = (ICalculator) registry.lookup("icalc");
		
		 Scanner myscan = new Scanner(System.in);

         System.out.println("Enter Number 1:");
         int x = myscan.nextInt();

         System.out.println("Enter Number 2:");
         int y = myscan.nextInt();

         int ans = stub.add(x,y);

         System.out.println("Total is: " + ans);
         
		 
		 }catch(Exception ex) {
			 ex.printStackTrace();
		 }
		 

	}

}
