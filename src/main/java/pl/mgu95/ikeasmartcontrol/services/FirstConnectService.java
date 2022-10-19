package pl.mgu95.ikeasmartcontrol.services;

import nl.stijngroenen.tradfri.device.Gateway;
import nl.stijngroenen.tradfri.util.Credentials;
import org.springframework.stereotype.Service;

@Service
public class FirstConnectService {

    public Credentials getCredentials(String ip, String securityCode) {
        Gateway gateway = new Gateway(ip);
        Credentials credentials = gateway.connect(securityCode);

        if (credentials != null) {
            return credentials;
        }

        return null;
    }
}
