package com.example.Parcial3.services;

import com.example.Parcial3.model.Academic_semester;
import com.example.Parcial3.repositories.Academic_semesterRepository;
import com.example.Parcial3.repositories.StudentRepository;
import com.example.Parcial3.repositories.TeacherRepository;
import com.example.Parcial3.repositories.MatterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class Academic_semesterService {

    @Autowired
    private Academic_semesterRepository academicSemesterRepository;

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private TeacherRepository teacherRepository;

    @Autowired
    private MatterRepository matterRepository;

    public List<Academic_semester> getAllAcademicSemesters() {
        return academicSemesterRepository.findAll();
    }

    public Optional<Academic_semester> getAcademicSemesterById(Integer id) {
        return academicSemesterRepository.findById(id);
    }

    public Academic_semester createAcademicSemester(Integer studentId, Integer teacherId, Integer matterId, Academic_semester academicSemester) {
        return studentRepository.findById(studentId).map(student -> {
            academicSemester.setStudent(student);
            return teacherRepository.findById(teacherId).map(teacher -> {
                academicSemester.setTeacher(teacher);
                return matterRepository.findById(matterId).map(matter -> {
                    academicSemester.setMatter(matter);
                    return academicSemesterRepository.save(academicSemester);
                }).orElseThrow(() -> new RuntimeException("Matter not found"));
            }).orElseThrow(() -> new RuntimeException("Teacher not found"));
        }).orElseThrow(() -> new RuntimeException("Student not found"));
    }

    public Academic_semester updateAcademicSemester(Integer id, Academic_semester academicSemesterDetails) {
        return academicSemesterRepository.findById(id).map(academicSemester -> {
            academicSemester.setName(academicSemesterDetails.getName());
            return academicSemesterRepository.save(academicSemester);
        }).orElseThrow(() -> new RuntimeException("Academic semester not found"));
    }

    public void deleteAcademicSemester(Integer id) {
        academicSemesterRepository.deleteById(id);
    }
}