package ma.emsi.hospital1.web;

import ma.emsi.hospital1.entities.Patient;

import ma.emsi.hospital1.repositories.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PatientRestController {
    @Autowired
private PatientRepository patientRepository;
@GetMapping("/patients")
public List<Patient> patientList(){
    return patientRepository.findAll();
}
}
