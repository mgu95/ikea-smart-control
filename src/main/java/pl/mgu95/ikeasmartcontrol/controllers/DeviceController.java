package pl.mgu95.ikeasmartcontrol.controllers;

import nl.stijngroenen.tradfri.device.Device;
import nl.stijngroenen.tradfri.device.Light;
import nl.stijngroenen.tradfri.util.ColourHex;
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

    @RequestMapping(value = "/device/{id}/on", method = RequestMethod.GET)
    public String onDevice(@PathVariable int id, ModelMap modelMap) {

        Device[] devices = (Device[]) modelMap.get("devices");
        for (Device dev : devices) {
            if (dev.getInstanceId() == id) {
                device = dev;
            }
        }

        if (device.isLight()) {
            Light light = device.toLight();
            light.setOn(true);
        }

        modelMap.put("device", device);

        return "device";
    }

    @RequestMapping(value = "/device/{id}/off", method = RequestMethod.GET)
    public String offDevice(@PathVariable int id, ModelMap modelMap) {

        Device[] devices = (Device[]) modelMap.get("devices");
        for (Device dev : devices) {
            if (dev.getInstanceId() == id) {
                device = dev;
            }
        }

        if (device.isLight()) {
            Light light = device.toLight();
            light.setOn(false);
        }

        modelMap.put("device", device);

        return "device";
    }

    @RequestMapping(value = "/device/{id}/colourHex/{colour}", method = RequestMethod.GET)
    public String changeColourHex(@PathVariable int id, @PathVariable String colour, ModelMap modelMap) {

        Device[] devices = (Device[]) modelMap.get("devices");
        for (Device dev : devices) {
            if (dev.getInstanceId() == id) {
                device = dev;
            }
        }

        if(device.isLight()){
            Light light = device.toLight();
            light.updateOn(true);
            light.updateBrightness(128);
            switch (colour) {
                case "WHITE":
                    light.setColourHex(ColourHex.WHITE);
                    break;
                case "WARM":
                    light.setColourHex(ColourHex.WARM);
                    break;
                case "GLOW":
                    light.setColourHex(ColourHex.GLOW);
                    break;
                case "BLUE":
                    light.setColourHex(ColourHex.BLUE);
                    break;
                case "LIGHT_BLUE":
                    light.setColourHex(ColourHex.LIGHT_BLUE);
                    break;
                case "SATURATED_PURPLE":
                    light.setColourHex(ColourHex.SATURATED_PURPLE);
                    break;
                case "LIME":
                    light.setColourHex(ColourHex.LIME);
                    break;
                case "LIGHT_PURPLE":
                    light.setColourHex(ColourHex.LIGHT_PURPLE);
                    break;
                case "YELLOW":
                    light.setColourHex(ColourHex.YELLOW);
                    break;
                case "SATURATED_PINK":
                    light.setColourHex(ColourHex.SATURATED_PINK);
                    break;
                case "DARK_PEACH":
                    light.setColourHex(ColourHex.DARK_PEACH);
                    break;
                case "SATURATED_RED":
                    light.setColourHex(ColourHex.SATURATED_RED);
                    break;
                case "COLD_SKY":
                    light.setColourHex(ColourHex.COLD_SKY);
                    break;
                case "PINK":
                    light.setColourHex(ColourHex.PINK);
                    break;
                case "PEACH":
                    light.setColourHex(ColourHex.PEACH);
                    break;
                case "WARM_AMBER":
                    light.setColourHex(ColourHex.WARM_AMBER);
                    break;
                case "LIGHT_PINK":
                    light.setColourHex(ColourHex.LIGHT_PINK);
                    break;
                case "COOL_DAYLIGHT":
                    light.setColourHex(ColourHex.COOL_DAYLIGHT);
                    break;
                case "CANDLELIGHT":
                    light.setColourHex(ColourHex.CANDLELIGHT);
                    break;
                case "WARM_GLOW":
                    light.setColourHex(ColourHex.WARM_GLOW);
                    break;
                case "WARM_WHITE":
                    light.setColourHex(ColourHex.WARM_WHITE);
                    break;
                case "SUNRISE":
                    light.setColourHex(ColourHex.SUNRISE);
                    break;
                case "COOL_WHITE":
                    light.setColourHex(ColourHex.COOL_WHITE);
                    break;
            }
            light.applyUpdates();
        }

        modelMap.put("device", device);

        return "device";
    }

    @RequestMapping(value = "/device/{id}", method = RequestMethod.POST)
    public String changeBrightness(@PathVariable int id, @RequestParam int value, ModelMap modelMap) {

        Device[] devices = (Device[]) modelMap.get("devices");
        for (Device dev : devices) {
            if (dev.getInstanceId() == id) {
                device = dev;
            }
        }

        if (value > 254 || value < 2) {
            modelMap.put("errorMessage", "Invalid value!");
            return "device";
        } else {
            if(device.isLight()){
                Light light = device.toLight();
                light.setBrightness(value); // 2 <> 254
            }
        }

        modelMap.put("device", device);

        return "device";
    }

}
