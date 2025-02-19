package com.landingis.api.controller;

import com.landingis.api.dto.ApiMessageDto;
import com.landingis.api.dto.PaginationDto;
import com.landingis.api.dto.lecturerscheduler.LecturerSchedulerDto;
import com.landingis.api.exception.ResourceNotFoundException;
import com.landingis.api.form.lecturerscheduler.LecturerSchedulerCreateForm;
import com.landingis.api.form.lecturerscheduler.LecturerSchedulerUpdateForm;
import com.landingis.api.mapper.LecturerSchedulerMapper;
import com.landingis.api.model.criteria.LecturerSchedulerCriteria;
import com.landingis.api.model.entity.LecturerScheduler;
import com.landingis.api.repository.LecturerSchedulerRepository;
import com.landingis.api.util.ApiMessageUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/lecturer-scheduler/")
public class LecturerSchedulerController {

    @Autowired
    private LecturerSchedulerRepository lecturerSchedulerRepository;

    @Autowired
    private LecturerSchedulerMapper lecturerSchedulerMapper;

    @GetMapping("/list")
    public ResponseEntity<ApiMessageDto<PaginationDto<LecturerSchedulerDto>>> getAll(
            LecturerSchedulerCriteria lecturerSchedulerCriteria,
            Pageable pageable
    ) {
        Specification<LecturerScheduler> specification = lecturerSchedulerCriteria.getSpecification();
        Page<LecturerScheduler> page = lecturerSchedulerRepository.findAll(specification, pageable);

        PaginationDto<LecturerSchedulerDto> result = new PaginationDto<>(
                lecturerSchedulerMapper.toDtoList(page.getContent()),
                page.getTotalElements(),
                page.getTotalPages()
        );


        ApiMessageDto<PaginationDto<LecturerSchedulerDto>> response = ApiMessageUtils
                .success(result, "Successfully retrieved all lecture-schedulers");

        return ResponseEntity.ok(response);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<ApiMessageDto<LecturerSchedulerDto>> getById(@PathVariable Long id) {
        ApiMessageDto<LecturerSchedulerDto> response = ApiMessageUtils
                .success(lecturerSchedulerMapper.toDto(findLecturerSchedulerById(id)), "Successfully retrieved lecturer-scheduler by id");

        return ResponseEntity.ok(response);
    }

    @PostMapping("/create")
    public ResponseEntity<ApiMessageDto<LecturerSchedulerDto>> createPeriod(@Valid @RequestBody LecturerSchedulerCreateForm form) {
        LecturerScheduler lecturerScheduler = lecturerSchedulerMapper.toEntity(form);
        LecturerScheduler savedLecturerScheduler = lecturerSchedulerRepository.save(lecturerScheduler);

        ApiMessageDto<LecturerSchedulerDto> response = ApiMessageUtils
                .success(lecturerSchedulerMapper.toDto(savedLecturerScheduler), "Successfully created lecturer-scheduler");

        return ResponseEntity.ok(response);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<ApiMessageDto<LecturerSchedulerDto>> updatePeriod(@PathVariable Long id,
                                                                            @Valid @RequestBody LecturerSchedulerUpdateForm form) {
        LecturerScheduler lecturerScheduler = findLecturerSchedulerById(id);
        lecturerSchedulerMapper.updateEntity(lecturerScheduler, form);
        LecturerScheduler updatedLecturerScheduler = lecturerSchedulerRepository.save(lecturerScheduler);

        ApiMessageDto<LecturerSchedulerDto> response = ApiMessageUtils
                .success(lecturerSchedulerMapper.toDto(updatedLecturerScheduler), "Successfully updated lecturer-scheduler");

        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ApiMessageDto<Void>> deletePeriod(@PathVariable Long id) {
        LecturerScheduler lecturerScheduler = findLecturerSchedulerById(id);
        lecturerSchedulerRepository.delete(lecturerScheduler);

        ApiMessageDto<Void> response = ApiMessageUtils
                .success(null, "Successfully deleted period");

        return ResponseEntity.ok(response);
    }

    private LecturerScheduler findLecturerSchedulerById(Long id) {
        return lecturerSchedulerRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Lecturer scheduler with id " + id + " not found")
        );
    }
}
