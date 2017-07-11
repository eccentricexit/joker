package com.jokelib;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

/**
 * Created by rigel on 7/10/17.
 */
public class JokerTest {
    Joker testJoker;

    @org.junit.Before
    public void setUp() {
        testJoker = new Joker();
    }

    @org.junit.Test
    public void testGetJoke(){
        assertNotNull(testJoker.getJoke());
        assertFalse(testJoker.getJoke().isEmpty());
    }

}