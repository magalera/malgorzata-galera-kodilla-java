package com.kodilla.patterns.singleton;

import org.junit.Assert;
import org.junit.Test;

public class LoggerTestSuite {

    @Test
    public void testGetLastLog() {
        //Given
        //When
        Logger.getInstance().log("Opening new message");


        //Then
        Assert.assertEquals("Opening new message", Logger.getInstance().getLastLog());
    }
}