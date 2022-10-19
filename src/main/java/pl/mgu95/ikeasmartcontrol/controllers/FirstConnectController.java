package pl.mgu95.ikeasmartcontrol.controllers;

import nl.stijngroenen.tradfri.util.Credentials;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import pl.mgu95.ikeasmartcontrol.services.FirstConnectService;

@Controller
public class FirstConnectController {

    @Autowired
    FirstConnectService service;

    @RequestMapping(value = "/firstConnect", method = RequestMethod.GET)
    public String showFirstConnectPage() {
        return "firstConnect";
    }

    @RequestMapping(value = "/firstConnect", method = RequestMethod.POST)
    public String requestForCredentials(ModelMap modelMap, @RequestParam String ip, @RequestParam String securityCode) {
        Credentials credentials = service.getCredentials(ip, securityCode);
        if (credentials == null) {
            modelMap.put("errorMessage", "Invalid Credentials");
            return "firstConnect";
        }
        modelMap.put("ip", ip);
        modelMap.put("identity", credentials.getIdentity());
        modelMap.put("key", credentials.getKey());

        return "firstConnectConfirmation";
    }
}
