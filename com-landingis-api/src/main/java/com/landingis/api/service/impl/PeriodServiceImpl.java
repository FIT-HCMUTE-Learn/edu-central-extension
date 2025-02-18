package com.landingis.api.service.impl;

import com.landingis.api.dto.period.PeriodDto;
import com.landingis.api.exception.ResourceNotFoundException;
import com.landingis.api.form.period.PeriodCreateForm;
import com.landingis.api.form.period.PeriodUpdateForm;
import com.landingis.api.mapper.PeriodMapper;
import com.landingis.api.model.entity.Period;
import com.landingis.api.repository.PeriodRepository;
import com.landingis.api.service.PeriodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PeriodServiceImpl implements PeriodService {

    @Autowired
    private PeriodRepository periodRepository;

    @Autowired
    private PeriodMapper periodMapper;

    @Override
    public List<PeriodDto> getAll() {
        return periodMapper.toDtoList(periodRepository.findAll());
    }

    @Override
    public PeriodDto getById(Long id) {
        return periodMapper.toDto(findPeriodById(id));
    }

    @Override
    public PeriodDto create(PeriodCreateForm form) {
        Period period = periodMapper.toEntity(form);
        Period savedPeriod = periodRepository.save(period);

        return periodMapper.toDto(savedPeriod);
    }

    @Override
    public PeriodDto update(Long id, PeriodUpdateForm form) {
        Period period = findPeriodById(id);
        periodMapper.updateEntity(period, form);
        Period updatedPeriod = periodRepository.save(period);

        return periodMapper.toDto(updatedPeriod);
    }

    @Override
    public void delete(Long id) {
        Period period = findPeriodById(id);
        periodRepository.delete(period);
    }

    private Period findPeriodById(Long id){
        return periodRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Period with id " + id + " not found")
        );
    }
}
