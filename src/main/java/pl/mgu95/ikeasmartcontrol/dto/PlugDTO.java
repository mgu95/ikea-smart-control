package pl.mgu95.ikeasmartcontrol.dto;

import nl.stijngroenen.tradfri.device.Plug;

public class PlugDTO {

    private int deviceId;
    private boolean power;

    public PlugDTO(int deviceId, boolean power) {
        this.deviceId = deviceId;
        this.power = power;
    }

    public PlugDTO(Plug plug) {
        this.deviceId = plug.getInstanceId();
        this.power = plug.getOn();
    }

    public int getDeviceId() {
        return deviceId;
    }

    public boolean isPower() {
        return power;
    }
}
