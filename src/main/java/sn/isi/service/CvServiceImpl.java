package sn.isi.service;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import sn.isi.entity.CV;
import sn.isi.repository.CvRepository;

import java.util.List;
import java.util.Optional;

@Service
public class CvServiceImpl implements CvService{

    private CvRepository cvRepository;

    public CvServiceImpl(CvRepository cvRepository) {

        this.cvRepository = cvRepository;
    }
    @Override
    public void save(CV cv) {
        cvRepository.save(cv);
    }

    @Override
    public List<CV> listCV() {
        return cvRepository.findAll();
    }

    @Override
    public Optional<CV> findById(Long id) {
        return cvRepository.findById(id);

    }


}
