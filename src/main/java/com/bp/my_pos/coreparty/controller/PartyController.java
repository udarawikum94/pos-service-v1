package com.bp.my_pos.coreparty.controller;

import com.bp.my_pos.coreparty.model.dto.PartyCreateRequest;
import com.bp.my_pos.coreparty.model.dto.PartyDto;
import com.bp.my_pos.coreparty.service.PartyService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * ----------------------------------------------------------------------------
 *  Author      : Udara Wikum
 *  Date        : 2025-12-04 12:46 PM
 *  Developed with an Intelligent Approach
 * ----------------------------------------------------------------------------
 */

@RestController
@RequestMapping("/api/parties")
@RequiredArgsConstructor
public class PartyController {

    private final PartyService partyService;

    @PostMapping
    @PreAuthorize("hasAuthority('PARTY_CREATE')")
    public ResponseEntity<PartyDto> create(@Valid @RequestBody PartyCreateRequest request) {
        return ResponseEntity.ok(partyService.create(request));
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAuthority('PARTY_VIEW')")
    public ResponseEntity<PartyDto> get(@PathVariable Long id) {
        return ResponseEntity.ok(partyService.getById(id));
    }

    @GetMapping("/customers")
    @PreAuthorize("hasAuthority('CUSTOMER_VIEW')")
    public ResponseEntity<List<PartyDto>> customers() {
        return ResponseEntity.ok(partyService.getAllCustomers());
    }

    @GetMapping("/suppliers")
    @PreAuthorize("hasAuthority('SUPPLIER_VIEW')")
    public ResponseEntity<List<PartyDto>> suppliers() {
        return ResponseEntity.ok(partyService.getAllSuppliers());
    }
}
