package sn.isi.service;

import org.springframework.stereotype.Service;
import sn.isi.entity.CV;

import java.util.List;
import java.util.Optional;

@Service
public interface CvService {
    public void save(CV cv);
    List<CV> listCV();

    Optional<CV> findById(Long id);

}
