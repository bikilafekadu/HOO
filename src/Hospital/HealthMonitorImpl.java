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
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;
public class HealthMonitorImpl extends UnicastRemoteObject implements HealthMonitor {
    private List<Patient> patients;

    public HealthMonitorImpl() throws RemoteException {
        patients = new ArrayList<>();
    }

    @Override
    public void updatePatientStatus(String patientName, String status) throws RemoteException {
        for (Patient patient : patients) {
            if (patient.getName().equals(patientName)) {
                patient.setStatus(status);
                break;
            }
        }
    }

    @Override
    public List<Patient> getAllPatients() throws RemoteException {
        return patients;
    }

    @Override
    public void addNewPatient(Patient patient) throws RemoteException {
        patients.add(patient);
    }

    @Override
    public void deletePatient(String patientName) throws RemoteException {
        patients.removeIf(patient -> patient.getName().equals(patientName));
    }
}
