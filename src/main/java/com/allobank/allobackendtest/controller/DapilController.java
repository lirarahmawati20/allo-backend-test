package com.allobank.allobackendtest.controller;

import com.allobank.allobackendtest.dto.DapilDTO;
import com.allobank.allobackendtest.service.DapilService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/dapil")
public class DapilController {

    private final DapilService dapilService;

    @Autowired
    public DapilController(DapilService dapilService) {
        this.dapilService = dapilService;
    }

    /**
     * Get electoral districts with filters and sorting
     * 
     * @param namaDapil Filter by name (optional, partial match)
     * @param provinsi Filter by province (optional, partial match)
     * @param jumlahKursi Filter by number of seats (optional)
     * @param sortBy Field to sort by (optional, defaults to "namaDapil")
     * @param sortDirection Sort direction (optional, defaults to ASC)
     * @return List of electoral districts matching the criteria
     */
    @GetMapping
    public ResponseEntity<List<DapilDTO>> getDapil(
            @RequestParam(required = false) String namaDapil,
            @RequestParam(required = false) String provinsi,
            @RequestParam(required = false) Integer jumlahKursi,
            @RequestParam(required = false, defaultValue = "namaDapil") String sortBy,
            @RequestParam(required = false, defaultValue = "ASC") Sort.Direction sortDirection) {

        return ResponseEntity.ok(dapilService.getDapilWithFilters(
                namaDapil, provinsi, jumlahKursi, sortBy, sortDirection));
    }

    @GetMapping("/{id}")
    public ResponseEntity<DapilDTO> getDapilById(@PathVariable UUID id) {
        DapilDTO dapil = dapilService.getDapilById(id);
        if (dapil != null) {
            return ResponseEntity.ok(dapil);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
