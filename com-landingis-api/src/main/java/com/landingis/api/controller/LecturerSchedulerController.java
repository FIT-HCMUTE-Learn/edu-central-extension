package com.landingis.api.controller;

import com.landingis.api.dto.ApiMessageDto;
import com.landingis.api.dto.lecturerscheduler.LecturerSchedulerDto;
import com.landingis.api.form.lecturerscheduler.LecturerSchedulerCreateForm;
import com.landingis.api.form.lecturerscheduler.LecturerSchedulerUpdateForm;
import com.landingis.api.service.LecturerSchedulerService;
import com.landingis.api.util.ApiMessageUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/lecturer-scheduler/")
public class LecturerSchedulerController {

    @Autowired
    private LecturerSchedulerService lecturerSchedulerService;

    @GetMapping("/list")
    public ResponseEntity<ApiMessageDto<List<LecturerSchedulerDto>>> getAll() {
        ApiMessageDto<List<LecturerSchedulerDto>> response = ApiMessageUtils
                .success(lecturerSchedulerService.getAll(), "Successfully retrieved all lecture-schedulers");

        return ResponseEntity.ok(response);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<ApiMessageDto<LecturerSchedulerDto>> getById(@PathVariable Long id) {
        ApiMessageDto<LecturerSchedulerDto> response = ApiMessageUtils
                .success(lecturerSchedulerService.getById(id), "Successfully retrieved lecturer-scheduler by id");

        return ResponseEntity.ok(response);
    }

    @PostMapping("/create")
    public ResponseEntity<ApiMessageDto<LecturerSchedulerDto>> createPeriod(@Valid @RequestBody LecturerSchedulerCreateForm form) {
        ApiMessageDto<LecturerSchedulerDto> response = ApiMessageUtils
                .success(lecturerSchedulerService.create(form), "Successfully created lecturer-scheduler");

        return ResponseEntity.ok(response);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<ApiMessageDto<LecturerSchedulerDto>> updatePeriod(@PathVariable Long id,
                                                                            @Valid @RequestBody LecturerSchedulerUpdateForm form) {
        ApiMessageDto<LecturerSchedulerDto> response = ApiMessageUtils
                .success(lecturerSchedulerService.update(id, form), "Successfully updated lecturer-scheduler");

        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ApiMessageDto<Void>> deletePeriod(@PathVariable Long id) {
        lecturerSchedulerService.delete(id);
        ApiMessageDto<Void> response = ApiMessageUtils
                .success(null, "Successfully deleted period");

        return ResponseEntity.ok(response);
    }
}
