package org.gameontext.iotboard.registration;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.client.Invocation.Builder;
import javax.ws.rs.core.Response;

public class DeviceRegistration {

    public DeviceRegistrationResponse registerDevice(DeviceRegistrationRequest request) {
        Client client = ClientBuilder.newClient();
        
        WebTarget target = client.target("https://iotboard.mybluemix.net/iotboard/v1/devices");
        Builder requestBuilder = target.request();
        
//        requestBuilder.header("Authorization", ioTConfig.getAuthHeader());
//        System.out.println("Registering device with ID " + registration.getDeviceId());
        
        Response response = requestBuilder.post(Entity.json(request));
        System.out.println("Got back: " + response.getStatus());
        
        DeviceRegistrationResponse drr = response.readEntity(DeviceRegistrationResponse.class);
        
        System.out.println("Returned payload: " + drr);
        return drr;
        
    }
}
