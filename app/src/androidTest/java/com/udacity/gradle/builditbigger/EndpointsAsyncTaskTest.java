package com.udacity.gradle.builditbigger;

import android.support.test.runner.AndroidJUnit4;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

/**
 * Created by rigel on 7/10/17.
 */
@RunWith(AndroidJUnit4.class)
public class EndpointsAsyncTaskTest implements EndpointsAsyncTask.EndpointCallback{

    EndpointsAsyncTask asyncTask;
    CountDownLatch signal;
    String asyncTaskOutput;

    @Before
    public void setup(){
        asyncTask = new EndpointsAsyncTask(this);
    }

    @Test
    public void testGetJokeFromEndpoint() throws InterruptedException {
        signal = new CountDownLatch(1);
        asyncTask.execute();

        signal.await(5, TimeUnit.SECONDS);

        assertNotNull(asyncTaskOutput);
        assertFalse(asyncTaskOutput.isEmpty());
    }

    @Override
    public void callback(String result) {
        asyncTaskOutput = result;
        signal.countDown();
    }
}