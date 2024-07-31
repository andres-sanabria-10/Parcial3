package com.example.Parcial3.services;

import com.example.Parcial3.model.Matter;
import com.example.Parcial3.repositories.MatterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MatterService {

    @Autowired
    private MatterRepository matterRepository;

    public List<Matter> getAllMatters() {
        return matterRepository.findAll();
    }

    public Optional<Matter> getMatterById(Integer id) {
        return matterRepository.findById(id);
    }

    public Matter saveMatter(Matter matter) {
        return matterRepository.save(matter);
    }

    public void deleteMatter(Integer id) {
        matterRepository.deleteById(id);
    }

    public Matter updateMatter(Integer id, Matter matterDetails) {
        Matter matter = matterRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Matter not found with id: " + id));

        matter.setName(matterDetails.getName());
        matter.setNumCredit(matterDetails.getNumCredit());
        // Actualiza la práctica si es necesario
        if (matterDetails.getPractice() != null) {
            matter.setPractice(matterDetails.getPractice());
        }

        return matterRepository.save(matter);
    }
}