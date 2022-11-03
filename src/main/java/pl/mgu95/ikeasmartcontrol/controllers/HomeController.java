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

    private Gateway gateway;

    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public String showHomePage(ModelMap modelMap) {

        if (modelMap.getAttribute("ip") == null) {
            return "redirect:/login";
        }

        gateway = new Gateway((String) modelMap.get("ip"));
        Credentials credentials = new Credentials((String) modelMap.get("identity"), (String) modelMap.get("key"));
        gateway.connect(credentials);

        modelMap.put("lights", getLights());
        modelMap.put("plugs", getPlugs());
        modelMap.put("scenes", getScenes());
        modelMap.put("behaviors", getBehaviors());
        modelMap.put("devices", gateway.getDevices());

        return "home";
    }

    private LightDTO[] getLights() {
        List<LightDTO> lightDTOList = new ArrayList<>();

        Device[] devices = gateway.getDevices();
        for (Device device : devices) {
            if (device.isLight()) {
                lightDTOList.add(new LightDTO(device.toLight()));
            }
        }

        LightDTO[] arrayToReturn = new LightDTO[lightDTOList.size()];
        arrayToReturn = lightDTOList.toArray(arrayToReturn);
        return arrayToReturn;
    }

    private PlugDTO[] getPlugs() {
        List<PlugDTO> plugDTOList = new ArrayList<>();

        Device[] devices = gateway.getDevices();
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
