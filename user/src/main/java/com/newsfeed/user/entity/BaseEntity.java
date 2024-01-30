package com.newsfeed.user.entity;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@ToString
@MappedSuperclass
@AllArgsConstructor
@NoArgsConstructor
public class BaseEntity {

    @Column(name  =  "created_at")
    private LocalDate createdAt;

    @Column(name  =  "created_by")
    private String createdBy;

    @Column(name  =  "updated_at")
    private LocalDate updatedAt;

    @Column(name  =  "updated_by")
    private String updatedBy;

}
