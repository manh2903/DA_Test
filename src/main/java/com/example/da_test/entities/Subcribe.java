package com.example.da_test.entities;

import jakarta.persistence.*;
import lombok.Getter;

import java.util.Date;

@Entity
@Table(name = "tbl_subcribe")
public class Subcribe extends BaseEntity {
    @Getter
    @Column(name = "email", length = 45, nullable = false)
    private String email;

    @Column(name = "created_date")
    private Date createdDate;

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public Date getCreatedDate() {
        return createdDate;
    }

    @Override
    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }
}