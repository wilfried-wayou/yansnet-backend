package com.etsia.common.infrastructure.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "departments", schema = "public", uniqueConstraints = {
        @UniqueConstraint(name = "departments_name_key", columnNames = {"name"})
})
@AllArgsConstructor
@NamedEntityGraph
@Builder
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "name", nullable = false, length = 100)
    private String name;

    public Department() {

    }
}