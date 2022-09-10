package pl.mgu95.ikeasmartcontrol.controllers;

import nl.stijngroenen.tradfri.device.Device;
import nl.stijngroenen.tradfri.device.Gateway;
import nl.stijngroenen.tradfri.util.Credentials;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes({"ip", "identity", "key"})
public class HomeController {

    private Gateway gateway;

    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public String showHomePage(ModelMap modelMap) {

        Device[] devices;

        if (!modelMap.isEmpty()) {
            gateway = new Gateway((String) modelMap.get("ip"));
            Credentials credentials = new Credentials((String) modelMap.get("identity"), (String) modelMap.get("key"));
            gateway.connect(credentials);
            devices = gateway.getDevices();
            for (Device device : devices) {
                System.out.println("name = " + device.getName() + ", type = " + device.getType());
            }
            modelMap.put("devices", devices);
        }

        return "home";
    }
}
