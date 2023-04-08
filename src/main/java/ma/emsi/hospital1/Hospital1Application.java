package ma.emsi.hospital1;

import ma.emsi.hospital1.entities.*;
import ma.emsi.hospital1.repositories.ConsultationRepository;
import ma.emsi.hospital1.repositories.MedecinRepository;
import ma.emsi.hospital1.repositories.PatientRepository;
import ma.emsi.hospital1.repositories.RendezVousRepository;
import ma.emsi.hospital1.service.IHospitalService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;
import java.util.stream.Stream;

@SpringBootApplication
public class Hospital1Application  {

	public static void main(String[] args) {
		SpringApplication.run(Hospital1Application.class, args);
	}
	@Bean
CommandLineRunner start(IHospitalService hospitalService,
						PatientRepository patientRepository,
						RendezVousRepository rendezVousRepository,
						MedecinRepository medecinRepository){
		return args -> {
			Stream.of("Mohammed","Hassan","Najat").forEach(name->{
				Patient patient=new Patient();
				patient.setNom(name);
				patient.setDateNaissance(new Date());
				patient.setMalade(false);
				hospitalService.savePatient(patient);
			});
			Stream.of("aymane","khadija","ayoub").forEach(name->{
				Medecin medecin=new Medecin();
				medecin.setNom(name);
				medecin.setEmail(name+"@gmail.com");
				medecin.setSpecialite(Math.random()>0.5?"Cardio":"Dentiste");
				hospitalService.saveMedecin(medecin);
			});
			Patient patient=patientRepository.findById(1L).orElse(null);
            Patient patient1=patientRepository.findByNom("Mohammed");
           Medecin medecin=medecinRepository.findByNom("khadija");
		   RendezVous rendezVous=new RendezVous();
		   rendezVous.setDate(new Date());
		   rendezVous.setStatus(StatusRDV.PENDING);
		   rendezVous.setMedecin(medecin);
		   rendezVous.setPatient(patient);
		   RendezVous saveDRDV=hospitalService.saveRDV(rendezVous);
			System.out.println(saveDRDV.getId());
		   RendezVous rendezVous1=rendezVousRepository.findAll().get(0);

			Consultation consultation=new Consultation();
			consultation.setDateConsultation((new Date()));
			consultation.setRendezVous(rendezVous1);
			consultation.setRapport("Rapport de la consultation ......");
			hospitalService.saveConsultation(consultation);


		};

}



}
