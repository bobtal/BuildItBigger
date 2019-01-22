package com.udacity.gradle.builditbigger;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;

import com.example.androidjokes.JokeActivity;
import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.google.api.client.googleapis.services.AbstractGoogleClientRequest;
import com.google.api.client.googleapis.services.GoogleClientRequestInitializer;
import com.udacity.gradle.builditbigger.backend.myApi.MyApi;

import java.io.IOException;
import java.lang.ref.WeakReference;

public class EndpointsAsyncTask extends AsyncTask<Void, Void, String> {

    private final WeakReference<Context> contextWeakReference;
    private static MyApi myApiService = null;

    EndpointsAsyncTask(Context context) {
        this.contextWeakReference = new WeakReference<>(context);
    }

    @Override
    protected String doInBackground(Void... voids) {
        if (myApiService == null) { // Only do this once
            MyApi.Builder builder = new MyApi.Builder(AndroidHttp.newCompatibleTransport(),
                    new AndroidJsonFactory(), null)
                    // options for running against local devappserver
                    // - 10.0.2.2 is localhost's IP address in Android emulator
                    // - turn off compression when running against local devappserver
                    .setRootUrl("http://10.0.2.2:8080/_ah/api/")
                    .setGoogleClientRequestInitializer(new GoogleClientRequestInitializer() {
                        @Override
                        public void initialize(AbstractGoogleClientRequest<?> request) throws IOException {
                            request.setDisableGZipContent(true);
                        }
                    });
            // end options for devappserver

            myApiService = builder.build();
        }


        try {
            return myApiService.fetchJoke().execute().getData();
        } catch (IOException exception) {
            return exception.getMessage();
        }
    }

    @Override
    protected void onPostExecute(String s) {
        Intent intent = new Intent(contextWeakReference.get(), JokeActivity.class);
        intent.putExtra(JokeActivity.JOKE_EXTRA, s);
        contextWeakReference.get().startActivity(intent);
    }
}
