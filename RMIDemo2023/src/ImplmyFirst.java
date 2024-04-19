import java.rmi.RemoteException;

public class ImplmyFirst implements myFirst {
    @Override
    public int calc(int a, int b) throws RemoteException {
        return (a + b);
    }
}
