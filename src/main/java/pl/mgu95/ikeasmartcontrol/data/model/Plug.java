package pl.mgu95.ikeasmartcontrol.data.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Plug {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private int deviceId;
    private boolean power;

    protected Plug() {}

    public Plug(int deviceId, boolean power) {
        this.deviceId = deviceId;
        this.power = power;
    }

    public Long getId() {
        return id;
    }

    public int getDeviceId() {
        return deviceId;
    }

    public boolean isPower() {
        return power;
    }
}
