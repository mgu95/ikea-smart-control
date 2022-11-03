package pl.mgu95.ikeasmartcontrol.controllers;

import nl.stijngroenen.tradfri.device.Device;
import nl.stijngroenen.tradfri.device.Gateway;
import nl.stijngroenen.tradfri.util.Credentials;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import pl.mgu95.ikeasmartcontrol.dto.LightDTO;
import pl.mgu95.ikeasmartcontrol.dto.PlugDTO;

import java.util.ArrayList;
import java.util.List;

@Controller
@SessionAttributes({"ip", "devices"})
public class HomeController {

    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public String showHomePage(ModelMap modelMap) {

        if (modelMap.getAttribute("ip") == null) {
            return "redirect:/login";
        }

        Device[] devices = (Device[]) modelMap.get("devices");
        modelMap.put("lights", getLights(devices));
        modelMap.put("plugs", getPlugs(devices));
        modelMap.put("scenes", getScenes());
        modelMap.put("behaviors", getBehaviors());

        return "home";
    }

    private LightDTO[] getLights(Device[] devices) {
        List<LightDTO> lightDTOList = new ArrayList<>();

        for (Device device : devices) {
            if (device.isLight()) {
                lightDTOList.add(new LightDTO(device.toLight()));
            }
        }

        LightDTO[] arrayToReturn = new LightDTO[lightDTOList.size()];
        arrayToReturn = lightDTOList.toArray(arrayToReturn);
        return arrayToReturn;
    }

    private PlugDTO[] getPlugs(Device[] devices) {
        List<PlugDTO> plugDTOList = new ArrayList<>();

        for (Device device : devices) {
            if (device.isPlug()) {
                plugDTOList.add(new PlugDTO(device.toPlug()));
            }
        }

        PlugDTO[] arrayToReturn =  new PlugDTO[plugDTOList.size()];
        arrayToReturn = plugDTOList.toArray(arrayToReturn);
        return arrayToReturn;
    }

    private Object getScenes() {
        return null;
    }

    private Object getBehaviors() {
        return null;
    }
}
