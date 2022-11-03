package pl.mgu95.ikeasmartcontrol.controllers;

import nl.stijngroenen.tradfri.device.Device;
import nl.stijngroenen.tradfri.device.Plug;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("devices")
public class PlugController {

    @RequestMapping(value = "/plug/update-power/{id}", method = RequestMethod.GET)
    public String updatePower(@PathVariable int id, ModelMap modelMap) {

        Plug plug = getPlugById(id, (Device[]) modelMap.get("devices"));

        if (plug.getOn()) {
            plug.setOn(false);
        } else {
            plug.setOn(true);
        }

        return "redirect:/home";
    }

    private Plug getPlugById(int id, Device[] devices) {

        for (Device device : devices) {
            if (device.isPlug()) {
                Plug plug = device.toPlug();
                if (plug.getInstanceId() == id) {
                    return plug;
                }
            }
        }

        return null;
    }
}
