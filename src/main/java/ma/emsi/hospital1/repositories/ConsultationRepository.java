package ma.emsi.hospital1.repositories;

import ma.emsi.hospital1.entities.Consultation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConsultationRepository extends JpaRepository<Consultation,Long> {
}
