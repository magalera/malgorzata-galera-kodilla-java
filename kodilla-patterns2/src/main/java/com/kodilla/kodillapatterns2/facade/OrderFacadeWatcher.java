package com.kodilla.kodillapatterns2.facade;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;


@Aspect
@Component
public class OrderFacadeWatcher {
    private static final Logger LOGGER = LoggerFactory.getLogger(OrderFacadeWatcher.class);

    @Before("execution(* com.kodilla.kodillapatterns2.facade.api.OrderFacade.processOrder(..))" + "&& args(theNumber) && target(object)")
    public void logEvent(Long theNumber, Object object) {
        LOGGER.info("Class: " + object.getClass().getName() + ", Args: " + theNumber);
    }
}
