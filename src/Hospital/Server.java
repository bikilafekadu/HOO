/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Hospital;

/**
 *
 * @author Abi
 */
import java.rmi.Remote;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
public class Server {
    public static void main(String[] args) {
        try {
            HealthMonitorImpl healthMonitor = new HealthMonitorImpl();
            Registry registry = LocateRegistry.createRegistry(1099);
            registry.rebind("HealthMonitor", (Remote) healthMonitor);
            System.out.println("Server is running...");
        } catch (Exception e) {
            System.err.println("Server exception: " + e.toString());
            e.printStackTrace();
        }
    }
}
