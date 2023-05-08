package sn.isi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sn.isi.entity.CV;

@Repository
public interface CvRepository extends JpaRepository<CV, Long> {
    CV findByEmail(String email);
}
