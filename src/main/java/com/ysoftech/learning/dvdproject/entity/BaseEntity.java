package com.ysoftech.learning.dvdproject.entity;

import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import java.time.LocalDate;

@MappedSuperclass
public abstract class BaseEntity {

    @Column(name="last_update")
    @UpdateTimestamp
    private LocalDate lastUpdate;


    protected BaseEntity() {
    }

    public BaseEntity(LocalDate lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    public LocalDate getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(LocalDate lastUpdate) {
        this.lastUpdate = lastUpdate;
    }
}