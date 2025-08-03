package com.allobank.allobackendtest.controller;

import com.allobank.allobackendtest.dto.CalegDTO;
import com.allobank.allobackendtest.model.JenisKelamin;
import com.allobank.allobackendtest.service.CalegService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/caleg")
public class CalegController {

    private final CalegService calegService;

    @Autowired
    public CalegController(CalegService calegService) {
        this.calegService = calegService;
    }

    /**
     * Get candidates with filters and sorting
     * 
     * @param dapilId Filter by electoral district ID (optional)
     * @param partaiId Filter by political party ID (optional)
     * @param nama Filter by name (optional, partial match)
     * @param jenisKelamin Filter by gender (optional)
     * @param nomorUrut Filter by sequence number (optional)
     * @param sortBy Field to sort by (optional, defaults to "nomorUrut")
     * @param sortDirection Sort direction (optional, defaults to ASC)
     * @return List of candidates matching the criteria
     */
    @GetMapping
    public ResponseEntity<List<CalegDTO>> getCaleg(
            @RequestParam(required = false) UUID dapilId,
            @RequestParam(required = false) UUID partaiId,
            @RequestParam(required = false) String nama,
            @RequestParam(required = false) JenisKelamin jenisKelamin,
            @RequestParam(required = false) Integer nomorUrut,
            @RequestParam(required = false, defaultValue = "nomorUrut") String sortBy,
            @RequestParam(required = false, defaultValue = "ASC") Sort.Direction sortDirection) {

        return ResponseEntity.ok(calegService.getCalegWithFilters(
                dapilId, partaiId, nama, jenisKelamin, nomorUrut, sortBy, sortDirection));
    }

    @GetMapping("/{id}")
    public ResponseEntity<CalegDTO> getCalegById(@PathVariable UUID id) {
        CalegDTO caleg = calegService.getCalegById(id);
        if (caleg != null) {
            return ResponseEntity.ok(caleg);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
