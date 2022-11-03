package pl.mgu95.ikeasmartcontrol.dto;

import nl.stijngroenen.tradfri.device.Light;

public class LightDTO {

    private int deviceId;
    private boolean power;
    private String colourHex;
    private Integer brightness;

    public LightDTO(int deviceId, boolean power, String colourHex, Integer brightness) {
        this.deviceId = deviceId;
        this.power = power;
        this.colourHex = colourHex;
        this.brightness = brightness;
    }

    public LightDTO(Light light) {
        this.deviceId = light.getInstanceId();
        this.power = light.getOn();
        this.colourHex = light.getColourHex();
        this.brightness = light.getBrightness();
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

    public Integer getBrightness() {
        return brightness;
    }
}
