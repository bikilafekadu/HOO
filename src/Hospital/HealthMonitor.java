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
import java.rmi.RemoteException;
import java.util.List;
public interface HealthMonitor extends Remote {
    void updatePatientStatus(String patientName, String status) throws RemoteException;
    List<Patient> getAllPatients() throws RemoteException;
    void addNewPatient(Patient patient) throws RemoteException;
    void deletePatient(String patientName) throws RemoteException;

    /**
     *
     * @param patient
     */
}
