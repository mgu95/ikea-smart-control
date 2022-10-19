package pl.mgu95.ikeasmartcontrol.tools;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

public class IPScanner {

    private byte[] ip;
    private int timeout;  //default 5000

    public IPScanner(int timeout) {
        this.timeout = timeout;
        try {
            ip = InetAddress.getLocalHost().getAddress();
        } catch (UnknownHostException e) {
            System.out.println("IP might not have been initialized.");
            throw new RuntimeException(e);
        }
    }

    public String getGatewayIP() {
        // to be introduced in the future

        return null;
    }

    public InetAddress[] searchCandidates() {
        List<InetAddress> candidatesList = new ArrayList<>();
        System.out.println("= SEARCHING DEVICES IN LOCAL NETWORK =");
        for (int i = 1; i <= 254; i++) { // 254
            try {
                ip[3] = (byte) i;
                InetAddress address = InetAddress.getByAddress(ip);
                System.out.print("[ " + address.toString().substring(1) + " ] ");
                if (isOnTheNetwork(address)) {
                    candidatesList.add(address);
                    System.out.println("ACTIVE");
                } else {
                    System.out.println("IDLE");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        System.out.println("= ACTIVE DEVICES IN LOCAL NETWORK =");
        for (InetAddress address : candidatesList) {
            System.out.println(address.toString().substring(1));
        }

        InetAddress[] candidates = new InetAddress[candidatesList.size()];
        candidates = candidatesList.toArray(candidates);
        return candidates;
    }

    private boolean isOnTheNetwork(InetAddress address) {
        try {
            if (address.isReachable(timeout)) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            return false;
        }
    }

}
