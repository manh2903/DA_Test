package com.example.da_test.entities;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


import java.util.Date;

@Getter
@Setter
@MappedSuperclass

public abstract class BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "status", nullable = true)
    private Boolean status = Boolean.TRUE;

    @Column(name = "created_by", nullable = true)
    private Integer createdBy;

    @Column(name = "updated_by", nullable = true)
    private Integer updatedBy;

    @Column(name = "updated_date", nullable = true)
    private Date updatedDate;

    @Column(name = "created_date", nullable = true)
    private Date createdDate;

}
