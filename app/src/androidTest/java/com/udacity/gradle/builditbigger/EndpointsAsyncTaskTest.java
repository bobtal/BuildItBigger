package com.udacity.gradle.builditbigger;

import android.content.Context;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;

import java.util.concurrent.CountDownLatch;

import static org.junit.Assert.*;

@RunWith(AndroidJUnit4.class)
public class EndpointsAsyncTaskTest {

    @Mock
    Context mockContext;

    @Test
    public void AsyncTaskRetrievesNonEmptyString() throws InterruptedException {
        final CountDownLatch latch = new CountDownLatch(1);
        EndpointsAsyncTask task = new EndpointsAsyncTask(mockContext) {
            @Override
            protected void onPostExecute(String s) {
                assertNotNull(s);
                assertTrue(s.length() > 0);
                latch.countDown();
            }
        };
        task.execute();
        latch.await();
    }

}