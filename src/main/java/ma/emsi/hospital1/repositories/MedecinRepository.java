package ma.emsi.hospital1.repositories;

import ma.emsi.hospital1.entities.Medecin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedecinRepository extends JpaRepository<Medecin,Long> {
Medecin findByNom(String nom);
}
