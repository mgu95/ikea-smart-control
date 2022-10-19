package pl.mgu95.ikeasmartcontrol.data.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Light {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private int deviceId;
    private boolean power;
    private String colourHex;
    private short brightness;

    protected Light() {}

    public Light(int deviceId, boolean power, String colourHex, short brightness) {
        this.deviceId = deviceId;
        this.power = power;
        this.colourHex = colourHex;
        this.brightness = brightness;
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

    public String getColourHex() {
        return colourHex;
    }

    public short getBrightness() {
        return brightness;
    }
}
