package ma.emsi.hospital1.service;

import ma.emsi.hospital1.entities.Consultation;
import ma.emsi.hospital1.entities.Medecin;
import ma.emsi.hospital1.entities.Patient;
import ma.emsi.hospital1.entities.RendezVous;

public interface IHospitalService {
    Patient savePatient(Patient patient);

    Medecin saveMedecin(Medecin medecin);
    RendezVous saveRDV(RendezVous rendezVous);
    Consultation saveConsultation(Consultation consultation);



}
