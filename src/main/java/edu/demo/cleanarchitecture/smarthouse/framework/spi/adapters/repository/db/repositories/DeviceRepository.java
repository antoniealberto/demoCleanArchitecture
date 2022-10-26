package edu.demo.cleanarchitecture.smarthouse.framework.spi.adapters.repository.db.repositories;


import edu.demo.cleanarchitecture.smarthouse.framework.spi.adapters.repository.db.entities.DeviceEntity;
import org.springframework.stereotype.Repository;

import java.util.Collections;
import java.util.Set;

@Repository
public class DeviceRepository implements GenericDbRepository<DeviceEntity>{

    @Override
    public void save(DeviceEntity deviceEntity) {

    }

    @Override
    public DeviceEntity findEntityById(Long id) {
        return null;
    }

    @Override
    public Set<DeviceEntity> findAll() {
        return Collections.emptySet();
    }
}
