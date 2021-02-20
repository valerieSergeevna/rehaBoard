package com.webapp;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.GenericType;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import com.sun.jersey.api.json.JSONConfiguration;
import org.apache.log4j.Logger;

import javax.ejb.Singleton;
import javax.inject.Inject;
import javax.ws.rs.client.ClientBuilder;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;


@Singleton
public class EventService {
    private static final Logger logger = Logger.getLogger(EventService.class);

    public List<JmsMessageTreatmentEvent> getEvents() {
        ClientConfig clientConfig = new DefaultClientConfig();
        clientConfig.getFeatures().put(JSONConfiguration.FEATURE_POJO_MAPPING, Boolean.TRUE);
        Client client = Client.create(clientConfig);

        try {
            WebResource webResource = client.resource("http://localhost:8080/todaysTreatmentsEvents");

            return webResource.type("application/json").get(new GenericType<List<JmsMessageTreatmentEvent>>() {
            });
        }
        catch(Exception e) {
            //  LOGGER.info("ArticleServiceImpl Exception");
            logger.info("Can't connect");
            return new ArrayList<>();
        }
    }
}