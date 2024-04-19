import java.rmi.RemoteException;

public class Calculator implements ICalculator{

	@Override
	public int add(int num1, int num2) throws RemoteException {
		 
		return num1 + num2;
	}

	 

}
