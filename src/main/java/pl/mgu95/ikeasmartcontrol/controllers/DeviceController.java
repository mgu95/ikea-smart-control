package pl.mgu95.ikeasmartcontrol.controllers;

import nl.stijngroenen.tradfri.device.Device;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

@Controller
@SessionAttributes({"devices", "deviceId"})
public class DeviceController {

    private Device device;

    @RequestMapping(value = "/device/{id}", method = RequestMethod.GET)
    public String showDevice(@PathVariable int id, ModelMap modelMap) {

        Device[] devices = (Device[]) modelMap.get("devices");
        for (Device dev : devices) {
            if (dev.getInstanceId() == id) {
                device = dev;
            }
        }

        modelMap.put("deviceId", id); // do zastąpienia przez Device();
        modelMap.put("device", device);

        return "device";
    }
}
