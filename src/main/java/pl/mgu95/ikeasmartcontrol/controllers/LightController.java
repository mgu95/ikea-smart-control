package pl.mgu95.ikeasmartcontrol.controllers;

import nl.stijngroenen.tradfri.device.Device;
import nl.stijngroenen.tradfri.device.Light;
import nl.stijngroenen.tradfri.util.ColourHex;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("devices")
public class LightController {

    @RequestMapping(value = "/light/update-brightness/{id}/{value}", method = RequestMethod.GET)
    public String updateBrightness(@PathVariable int id, @PathVariable int value, ModelMap modelMap) {

        int brightness = value * 254 / 100;
        System.out.println("brightness = " + brightness);
        if (brightness > 254 || brightness < 2) {
            return "errors/406";
        } else {
            Light light = getLightById(id, (Device[]) modelMap.get("devices"));
            if (!light.getOn()) {
                light.setOn(true);
            }
            light.setBrightness(value);
        }

        return "redirect:/home";
    }

    @RequestMapping(value = "/light/update-colour-hex/{id}/{colourHex}", method = RequestMethod.GET)
    public String updateColourHex(@PathVariable int id, @PathVariable String colourHex, ModelMap modelMap) {

        Light light = getLightById(id, (Device[]) modelMap.get("devices"));
        if (!light.getOn()) {
            light.setOn(true);
        }
        light.setColourHex(getColourHex(colourHex));

        return "redirect:/home";
    }

    @RequestMapping(value = "/light/update-power/{id}", method = RequestMethod.GET)
    public String updatePower(@PathVariable int id, ModelMap modelMap) {

        Light light = getLightById(id, (Device[]) modelMap.get("devices"));

        if (light.getOn()) {
            light.setOn(false);
        } else {
            light.setOn(true);
        }

        return "redirect:/home";
    }

    private String getColourHex(String colour) {

        switch (colour) {
            case "WHITE": return ColourHex.WHITE;
            case "WARM": return ColourHex.WARM;
            case "GLOW": return ColourHex.GLOW;
            case "BLUE": return ColourHex.BLUE;
            case "LIGHT_BLUE": return ColourHex.LIGHT_BLUE;
            case "SATURATED_PURPLE": return ColourHex.SATURATED_PURPLE;
            case "LIME": return ColourHex.LIME;
            case "LIGHT_PURPLE": return ColourHex.LIGHT_PURPLE;
            case "YELLOW": return ColourHex.YELLOW;
            case "SATURATED_PINK": return ColourHex.SATURATED_PINK;
            case "DARK_PEACH": return ColourHex.DARK_PEACH;
            case "SATURATED_RED": return ColourHex.SATURATED_RED;
            case "COLD_SKY": return ColourHex.COLD_SKY;
            case "PINK": return ColourHex.PINK;
            case "PEACH": return ColourHex.PEACH;
            case "WARM_AMBER": return ColourHex.WARM_AMBER;
            case "LIGHT_PINK": return ColourHex.LIGHT_PINK;
            case "COOL_DAYLIGHT": return ColourHex.COOL_DAYLIGHT;
            case "CANDLELIGHT": return ColourHex.CANDLELIGHT;
            case "WARM_GLOW": return ColourHex.WARM_GLOW;
            case "WARM_WHITE": return ColourHex.WARM_WHITE;
            case "SUNRISE": return ColourHex.SUNRISE;
            case "COOL_WHITE": return ColourHex.COOL_WHITE;
        }

        return null;
    }

    private Light getLightById(int id, Device[] devices) {

        for (Device device : devices) {
            if (device.isLight()) {
                Light light = device.toLight();
                if (light.getInstanceId() == id) {
                    return light;
                }
            }
        }

        return null;
    }
}
