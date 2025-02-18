package com.landingis.api.service;

import com.landingis.api.dto.lecturerscheduler.LecturerSchedulerDto;
import com.landingis.api.form.lecturerscheduler.LecturerSchedulerCreateForm;
import com.landingis.api.form.lecturerscheduler.LecturerSchedulerUpdateForm;

import java.util.List;

public interface LecturerSchedulerService {
    List<LecturerSchedulerDto> getAll();
    LecturerSchedulerDto getById(Long id);
    LecturerSchedulerDto create(LecturerSchedulerCreateForm form);
    LecturerSchedulerDto update(Long id, LecturerSchedulerUpdateForm form);
    void delete(long id);
}
