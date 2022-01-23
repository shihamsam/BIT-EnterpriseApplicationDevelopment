import java.rmi.Remote;
import java.rmi.RemoteException;

public interface myFirst extends Remote {
    public int calc(int a, int b) throws RemoteException;
}
