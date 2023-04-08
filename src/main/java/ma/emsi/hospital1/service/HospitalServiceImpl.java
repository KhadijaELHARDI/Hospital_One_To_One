package ma.emsi.hospital1.service;

import ma.emsi.hospital1.entities.Consultation;
import ma.emsi.hospital1.entities.Medecin;
import ma.emsi.hospital1.entities.Patient;
import ma.emsi.hospital1.entities.RendezVous;
import ma.emsi.hospital1.repositories.ConsultationRepository;
import ma.emsi.hospital1.repositories.MedecinRepository;
import ma.emsi.hospital1.repositories.PatientRepository;
import ma.emsi.hospital1.repositories.RendezVousRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.UUID;

@Service
@Transactional
public class HospitalServiceImpl implements IHospitalService {

    private PatientRepository patientRepository;

    private MedecinRepository medecinRepository;
    private RendezVousRepository rendezVousRepository;
    private ConsultationRepository consultationRepository;

    public HospitalServiceImpl(ConsultationRepository consultationRepository,MedecinRepository medecinRepository,RendezVousRepository rendezVousRepository,PatientRepository patientRepository) {
        this.consultationRepository = consultationRepository;
        this.patientRepository=patientRepository;
        this.rendezVousRepository=rendezVousRepository;
        this.medecinRepository=medecinRepository;
    }


    @Override
    public Patient savePatient(Patient patient) {
        return patientRepository.save(patient);
    }

    @Override
    public Medecin saveMedecin(Medecin medecin) {
        return medecinRepository.save(medecin);
    }

    @Override
    public RendezVous saveRDV(RendezVous rendezVous) {
        rendezVous.setId(UUID.randomUUID().toString());
        return rendezVousRepository.save(rendezVous);
    }

    @Override
    public Consultation saveConsultation(Consultation consultation) {
        return consultationRepository.save(consultation);
    }
}
