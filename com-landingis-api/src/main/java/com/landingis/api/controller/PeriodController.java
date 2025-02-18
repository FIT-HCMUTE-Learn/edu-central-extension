package com.landingis.api.controller;

import com.landingis.api.dto.ApiMessageDto;
import com.landingis.api.dto.period.PeriodDto;
import com.landingis.api.form.period.PeriodCreateForm;
import com.landingis.api.form.period.PeriodUpdateForm;
import com.landingis.api.service.PeriodService;
import com.landingis.api.util.ApiMessageUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/period/")
public class PeriodController {

    @Autowired
    private PeriodService periodService;

    @GetMapping("/list")
    public ResponseEntity<ApiMessageDto<List<PeriodDto>>> getAll() {
        ApiMessageDto<List<PeriodDto>> response = ApiMessageUtils
                .success(periodService.getAll(), "Successfully retrieved all periods");

        return ResponseEntity.ok(response);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<ApiMessageDto<PeriodDto>> getById(@PathVariable Long id) {
        ApiMessageDto<PeriodDto> response = ApiMessageUtils
                .success(periodService.getById(id), "Successfully retrieved period by id");

        return ResponseEntity.ok(response);
    }

    @PostMapping("/create")
    public ResponseEntity<ApiMessageDto<PeriodDto>> createPeriod(@Valid @RequestBody PeriodCreateForm form) {
        ApiMessageDto<PeriodDto> response = ApiMessageUtils
                .success(periodService.create(form), "Successfully created period");

        return ResponseEntity.ok(response);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<ApiMessageDto<PeriodDto>> updatePeriod(@PathVariable Long id, @Valid @RequestBody PeriodUpdateForm form) {
        ApiMessageDto<PeriodDto> response = ApiMessageUtils
                .success(periodService.update(id, form), "Successfully updated period");

        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ApiMessageDto<Void>> deletePeriod(@PathVariable Long id) {
        periodService.delete(id);
        ApiMessageDto<Void> response = ApiMessageUtils
                .success(null, "Successfully deleted period");

        return ResponseEntity.ok(response);
    }
}
