package com.example.Parcial3.services;

import com.example.Parcial3.model.Practice;
import com.example.Parcial3.model.Student;
import com.example.Parcial3.repositories.PracticeRepository;
import com.example.Parcial3.repositories.Academic_semesterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PracticeService {

    private final PracticeRepository practiceRepository;

    @Autowired
    public PracticeService(PracticeRepository practiceRepository) {
        this.practiceRepository = practiceRepository;
    }

    public List<Practice> getAllPractices() {
        return practiceRepository.findAll();
    }

    public Optional<Practice> getPracticeById(Integer id) {
        return practiceRepository.findById(id);
    }

    public Practice savePractice(Practice practice) {
        return practiceRepository.save(practice);
    }

    public void deletePractice(Integer id) {
        practiceRepository.deleteById(id);
    }

    public List<Student> getStudentsByPracticeId(Integer practiceId) {
        return practiceRepository.findStudentsByPracticeId(practiceId);
    }

    public List<Map<String, Object>> getPracticesSummaryBySemester(Integer semesterId) {
        List<Object[]> results = Academic_semesterRepository.findPracticesSummaryBySemester(semesterId);

        return results.stream().map(row -> Map.of(
                "semesterName", row[0],
                "matterName", row[1],
                "teacherName", row[2] + " " + row[3], // Combinamos nombre y apellido del profesor
                "startDate", row[4],
                "endDate", row[5],
                "location", row[6]
        )).collect(Collectors.toList());
    }

    public Practice updatePractice(Integer id, Practice practiceDetails) {
        Optional<Practice> practice = practiceRepository.findById(id);
        if (practice.isPresent()) {
            Practice existingPractice = practice.get();
            existingPractice.setStartDate(practiceDetails.getStartDate());
            existingPractice.setEndDate(practiceDetails.getEndDate());
            existingPractice.setLocation(practiceDetails.getLocation());
            return practiceRepository.save(existingPractice);
        }
        return null;
    }
}