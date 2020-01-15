package com.kodilla.patterns.strategy.social;

import org.junit.Assert;
import org.junit.Test;


public class UserTestSuite {

    @Test
    public void testDefaultSharingStrategies() {
        //Given
        User sheldon = new Millenials("Sheldon Cooper");
        User leonard = new YGeneration("Leonard Hofstadter");
        User raj = new ZGeneration("Rajesh Koothrappali");

        //When
        String actualSheldonSocialPublisher = sheldon.sharePost();
        String actualLeonardSocialPublisher = leonard.sharePost();
        String actualRajSocialPublisher = raj.sharePost();

        //Then
        Assert.assertEquals("Facebook", actualSheldonSocialPublisher);
        Assert.assertEquals("Twitter", actualLeonardSocialPublisher);
        Assert.assertEquals("Snapchat", actualRajSocialPublisher);
    }

    @Test
    public void testIndividualSharingStrategy() {
        //Given
        User sheldon = new Millenials("Sheldon Cooper");

        //When
        sheldon.setSocialPublisher(new TwitterPublisher());
        String actualSheldonSocialPublisher = sheldon.sharePost();

        //Then
        Assert.assertEquals("Twitter", actualSheldonSocialPublisher);
    }
}