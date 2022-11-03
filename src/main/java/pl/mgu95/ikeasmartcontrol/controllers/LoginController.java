package pl.mgu95.ikeasmartcontrol.controllers;

import nl.stijngroenen.tradfri.device.Gateway;
import nl.stijngroenen.tradfri.util.Credentials;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import pl.mgu95.ikeasmartcontrol.services.LoginService;

@Controller
@SessionAttributes({"ip", "devices"})
public class LoginController {

    @Autowired
    LoginService loginService;

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String showLoginPage(ModelMap modelMap) {
        return "login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String showHomePage(ModelMap modelMap, @RequestParam String ip, @RequestParam(required = false) String autoIP,
                               @RequestParam String identity, @RequestParam String key) {

        if (autoIP == null) {
            if (!loginService.manualLogin(ip, identity, key)) {
                modelMap.put("errorMessage", "Invalid Credentials");
                return "login";
            }
            Gateway gateway = new Gateway(ip);
            Credentials credentials = new Credentials(identity, key);
            gateway.connect(credentials);
            modelMap.put("devices", gateway.getDevices());
            modelMap.put("ip", ip);
        } else {
            String foundIp = loginService.autoLogin(identity, key);
            if (foundIp == null) {
                modelMap.put("errorMessage", "Invalid Credentials");
                return "login";
            }
            Gateway gateway = new Gateway(ip);
            Credentials credentials = new Credentials(identity, key);
            gateway.connect(credentials);
            modelMap.put("devices", gateway.getDevices());
            modelMap.put("ip", foundIp);
        }

        return "redirect:/home";
    }

}
