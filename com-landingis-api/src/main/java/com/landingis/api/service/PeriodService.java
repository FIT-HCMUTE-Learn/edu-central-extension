package com.landingis.api.service;

import com.landingis.api.dto.period.PeriodDto;
import com.landingis.api.form.period.PeriodCreateForm;
import com.landingis.api.form.period.PeriodUpdateForm;

import java.util.List;

public interface PeriodService {
    List<PeriodDto> getAll();
    PeriodDto getById(Long id);
    PeriodDto create(PeriodCreateForm form);
    PeriodDto update(Long id, PeriodUpdateForm form);
    void delete(Long id);
}
