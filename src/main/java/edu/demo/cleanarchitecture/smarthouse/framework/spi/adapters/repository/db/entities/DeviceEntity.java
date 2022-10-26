package edu.demo.cleanarchitecture.smarthouse.framework.spi.adapters.repository.db.entities;

import javax.persistence.*;

@Entity
@Table(name="DEVICE")
public class DeviceEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
