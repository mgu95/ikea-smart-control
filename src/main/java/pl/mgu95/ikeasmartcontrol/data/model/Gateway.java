package pl.mgu95.ikeasmartcontrol.data.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class Gateway {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String ip;
    private String securityCode;
    private String identity;
    private String passkey;
    private Date lastTimeUse;

    protected Gateway() {}

    public Gateway(String ip, String securityCode, String identity, String passkey) {
        this.ip = ip;
        this.securityCode = securityCode;
        this.identity = identity;
        this.passkey = passkey;
    }

    public Long getId() {
        return id;
    }

    public String getIp() {
        return ip;
    }

    public String getSecurityCode() {
        return securityCode;
    }

    public String getIdentity() {
        return identity;
    }

    public String getKey() {
        return passkey;
    }

    public Date getLastTimeUse() {
        return lastTimeUse;
    }
}
