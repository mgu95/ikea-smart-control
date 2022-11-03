package pl.mgu95.ikeasmartcontrol.services;

import nl.stijngroenen.tradfri.device.Device;
import nl.stijngroenen.tradfri.device.Gateway;
import nl.stijngroenen.tradfri.util.Credentials;
import org.springframework.stereotype.Service;
import pl.mgu95.ikeasmartcontrol.tools.IPScanner;

import java.io.*;
import java.net.InetAddress;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

@Service
public class LoginService {

    public String autoLogin(String identity, String key) {
        IPScanner ipScanner = new IPScanner(50);
        InetAddress[] candidates = ipScanner.searchCandidates();
        for (InetAddress address : candidates) {
            Gateway gateway = new Gateway(address.toString().substring(1));
            Credentials credentials = new Credentials(identity, key);
            gateway.connect(credentials);

            Device[] devices = gateway.getDevices();
            if (devices != null) {
                return address.toString().substring(1);
            }
        }

        return null;
    }

    public boolean manualLogin(String ip, String identity, String key) {
        Gateway gateway = new Gateway(ip);
        Credentials credentials = new Credentials(identity, key);
        gateway.connect(credentials);

        Device[] devices = gateway.getDevices();
        if (devices != null) {
            return true;
        }
        return false;
    }
}
