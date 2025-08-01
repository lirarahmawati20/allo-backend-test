package com.allobank.allobackendtest.controller;

import com.allobank.allobackendtest.dto.PartaiDTO;
import com.allobank.allobackendtest.service.PartaiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/partai")
public class PartaiController {

    private final PartaiService partaiService;

    @Autowired
    public PartaiController(PartaiService partaiService) {
        this.partaiService = partaiService;
    }

    /**
     * Get political parties with filters and sorting
     * 
     * @param id Filter by ID (optional)
     * @param namaPartai Filter by name (optional, partial match)
     * @param nomorUrut Filter by sequence number (optional)
     * @param sortBy Field to sort by (optional, defaults to "nomorUrut")
     * @param sortDirection Sort direction (optional, defaults to ASC)
     * @return List of political parties matching the criteria
     */
    @GetMapping
    public ResponseEntity<List<PartaiDTO>> getPartai(
            @RequestParam(required = false) UUID id,
            @RequestParam(required = false) String namaPartai,
            @RequestParam(required = false) Integer nomorUrut,
            @RequestParam(required = false, defaultValue = "nomorUrut") String sortBy,
            @RequestParam(required = false, defaultValue = "ASC") Sort.Direction sortDirection) {

        return ResponseEntity.ok(partaiService.getPartaiWithFilters(
                id, namaPartai, nomorUrut, sortBy, sortDirection));
    }

    // Get political party by ID
    @GetMapping("/{id}")
    public ResponseEntity<PartaiDTO> getPartaiById(@PathVariable UUID id) {
        PartaiDTO partai = partaiService.getPartaiById(id);
        if (partai != null) {
            return ResponseEntity.ok(partai);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
