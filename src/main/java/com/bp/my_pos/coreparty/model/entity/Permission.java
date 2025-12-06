package com.bp.my_pos.coreparty.model.entity;

import jakarta.persistence.*;
import lombok.*;

/**
 * ----------------------------------------------------------------------------
 *  Author      : Udara Wikum
 *  Date        : 2025-12-04 16:34 PM
 *  Developed with an Intelligent Approach
 * ----------------------------------------------------------------------------
 */

@Entity
@Table(name = "permission")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Permission {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true, length = 100)
    private String code;

    @Column(nullable = false, length = 150)
    private String name;

    @Column(length = 50)
    private String module;

    private String description;
}
