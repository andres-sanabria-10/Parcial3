package com.example.Parcial3.services;

import com.example.Parcial3.model.Matter;
import com.example.Parcial3.model.Practice;
import com.example.Parcial3.repositories.PracticeRepository;
import com.example.Parcial3.repositories.MatterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MatterService {

    private final MatterRepository matterRepository;
    private final PracticeRepository practiceRepository;

    @Autowired
    public MatterService(MatterRepository matterRepository, PracticeRepository practiceRepository) {
        this.matterRepository = matterRepository;
        this.practiceRepository = practiceRepository;
    }

    public List<Matter> findAll() {
        return matterRepository.findAll();
    }

    public Matter findById(Integer id) {
        return matterRepository.findById(id).orElse(null);
    }

    public Matter save(Matter matter, Integer idPractice) {
        Optional<Practice> optionalPractice = practiceRepository.findById(idPractice);
        if (optionalPractice.isPresent()) {
            Practice practice = optionalPractice.get();
            matter.setPractice(practice);
            return matterRepository.save(matter);
        }
        return null;
    }

    public Matter update(Integer id, Matter matterDetails) {
        Optional<Matter> optionalMatter = matterRepository.findById(id);
        if (optionalMatter.isPresent()) {
            Matter existingMatter = optionalMatter.get();
            existingMatter.setName(matterDetails.getName());

            // No actualizamos la práctica aquí, asumiendo que no cambia
            return matterRepository.save(existingMatter);
        }
        return null;
    }

    public boolean delete(Integer id) {
        if (matterRepository.existsById(id)) {
            matterRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public List<Matter> findAllByPracticeId(Integer practiceId) {
        return matterRepository.findByPracticeId(practiceId);
    }
}