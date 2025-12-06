package com.bp.my_pos.coreparty.model.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

/**
 * ----------------------------------------------------------------------------
 *  Author      : Udara Wikum
 *  Date        : 2025-12-04 11:23 AM
 *  Developed with an Intelligent Approach
 * ----------------------------------------------------------------------------
 */

@Entity
@Table(name = "business_party")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BusinessParty {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true, length = 50)
    private String code;

    @Column(nullable = false, length = 200)
    private String fullName;

    private String contactPerson;
    private String phone;
    private String email;
    private String address;

    @Column(columnDefinition = "TEXT")
    private String notes;

    private boolean customer;
    private boolean supplier;
    private boolean staff;
    private boolean active;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
