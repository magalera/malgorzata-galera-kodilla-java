package com.kodilla.testing.user;

import org.junit.*;

public class SimpleUserTestSuite {
    @Before
    public void before() {
        System.out.println("Test case: begin");
    }

    @After
    public void after() {
        System.out.println("Test case: end");
    }

    @BeforeClass
    public static void beforeClass() {
        System.out.println("Test suit: begin");
    }

    @AfterClass
    public static void afterClass() {
        System.out.println("Test suit: end");
    }

    @Test
    public void testCaseUsername() {
        //Given
        SimpleUser simpleUser = new SimpleUser("theForumUser", "Tommy Sullivan");
        //When
        String result = simpleUser.getUsername();
        //Then
        System.out.println("Testing " + result);
        Assert.assertEquals("theForumUser", result);
    }

    @Test
    public void testCaseRealName() {
        SimpleUser simpleUser = new SimpleUser("theForumUser", "Tommy Sullivan");
        String result = simpleUser.getRaelName();
        System.out.println("Testing " + result);
        Assert.assertEquals("Tommy Sullivan", result);
    }
}

