package com.udacity.gradle.builditbigger;

import android.support.test.runner.AndroidJUnit4;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

/**
 * Created by rigel on 7/10/17.
 */
@RunWith(AndroidJUnit4.class)
public class EndpointsAsyncTaskTest implements EndpointsAsyncTask.EndpointCallback{

    EndpointsAsyncTask asyncTask;

    @Before
    public void setup(){
        asyncTask = new EndpointsAsyncTask(this);
    }

    @Test
    public void testGetJokeFromEndpoint(){
        asyncTask.execute();
    }

    @Override
    public void callback(String result) {
        assertNotNull(result);
        assertFalse(result.isEmpty());
    }
}