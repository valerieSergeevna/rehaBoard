package com.webapp;

import org.apache.log4j.Logger;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.faces.push.Push;
import javax.faces.push.PushContext;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

@Named("eventBean")
@Stateless
public class EventBean implements Serializable {

    private static final Logger logger = Logger.getLogger(EventBean.class);

    @EJB
    private EventService eventService;

    @Inject
    @Push(channel = "updateEvents")
    PushContext pushContext;


    private List<JmsMessageTreatmentEvent> events;

    public void setEvents(List<JmsMessageTreatmentEvent> events) {
        this.events = events;
    }

    public List<JmsMessageTreatmentEvent> getEvents() {
        return eventService.getEvents();
    }

    public void updateEvents() {
        logger.info("update pushed");
        pushContext.send("UPDATE");
    }
}