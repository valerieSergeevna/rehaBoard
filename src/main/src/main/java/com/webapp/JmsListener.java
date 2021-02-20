package com.webapp;

import org.apache.log4j.Logger;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.EJB;
import javax.ejb.MessageDriven;
import javax.inject.Inject;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;


@MessageDriven(name = "TestQueue", activationConfig = {
        @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue"),
        @ActivationConfigProperty(propertyName = "destination", propertyValue = "notificationsQueue"),
        @ActivationConfigProperty(propertyName = "acknowledgeMode", propertyValue = "Auto-acknowledge")
})
public class JmsListener implements MessageListener {
    private static final Logger logger = Logger.getLogger(JmsListener.class);

    @EJB
    EventBean eventBean;

    public void onMessage(Message rcvMessage) {
        //  logger.info(rcvMessage);
        try {
            eventBean.updateEvents();
            logger.info("receive");
            System.out.println("RECEIVE______" +  ((TextMessage)rcvMessage).getText());
        } catch (JMSException e) {
            logger.info("on Message problem");
            e.printStackTrace();
        }
    }
}