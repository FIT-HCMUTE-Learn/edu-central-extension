package com.landingis.api.service.impl;

import com.landingis.api.dto.lecturerscheduler.LecturerSchedulerDto;
import com.landingis.api.exception.ResourceNotFoundException;
import com.landingis.api.form.lecturerscheduler.LecturerSchedulerCreateForm;
import com.landingis.api.form.lecturerscheduler.LecturerSchedulerUpdateForm;
import com.landingis.api.mapper.LecturerSchedulerMapper;
import com.landingis.api.model.entity.LecturerScheduler;
import com.landingis.api.repository.LecturerSchedulerRepository;
import com.landingis.api.service.LecturerSchedulerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LecturerSchedulerServiceImpl implements LecturerSchedulerService {

    @Autowired
    private LecturerSchedulerRepository lecturerSchedulerRepository;

    @Autowired
    private LecturerSchedulerMapper lecturerSchedulerMapper;

    @Override
    public List<LecturerSchedulerDto> getAll() {
        return lecturerSchedulerMapper.toDtoList(lecturerSchedulerRepository.findAll());
    }

    @Override
    public LecturerSchedulerDto getById(Long id) {
        return lecturerSchedulerMapper.toDto(findLecturerSchedulerById(id));
    }

    @Override
    public LecturerSchedulerDto create(LecturerSchedulerCreateForm form) {
        LecturerScheduler lecturerScheduler = lecturerSchedulerMapper.toEntity(form);
        LecturerScheduler savedLecturerScheduler = lecturerSchedulerRepository.save(lecturerScheduler);

        return lecturerSchedulerMapper.toDto(savedLecturerScheduler);
    }

    @Override
    public LecturerSchedulerDto update(Long id, LecturerSchedulerUpdateForm form) {
        LecturerScheduler lecturerScheduler = findLecturerSchedulerById(id);
        lecturerSchedulerMapper.updateEntity(lecturerScheduler, form);
        LecturerScheduler updatedLecturerScheduler = lecturerSchedulerRepository.save(lecturerScheduler);

        return lecturerSchedulerMapper.toDto(updatedLecturerScheduler);
    }

    @Override
    public void delete(long id) {
        LecturerScheduler lecturerScheduler = findLecturerSchedulerById(id);
        lecturerSchedulerRepository.delete(lecturerScheduler);
    }

    private LecturerScheduler findLecturerSchedulerById(Long id) {
        return lecturerSchedulerRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Lecturer scheduler with id " + id + " not found")
        );
    }
}
