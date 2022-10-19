package pl.mgu95.ikeasmartcontrol.data.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Scene {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Light[] lights;
    private Plug[] plugs;
    private String gatewayID;

    protected Scene() {}

    public Scene(Light[] lights, Plug[] plugs, String gatewayID) {
        this.lights = lights;
        this.plugs = plugs;
        this.gatewayID = gatewayID;
    }

    public Long getId() {
        return id;
    }

    public Light[] getLights() {
        return lights;
    }

    public Plug[] getPlugs() {
        return plugs;
    }

    public String getGatewayID() {
        return gatewayID;
    }
}
