package com.udacity.gradle.builditbigger;

import android.content.Context;
import android.os.AsyncTask;

import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.google.api.client.googleapis.services.AbstractGoogleClientRequest;
import com.google.api.client.googleapis.services.GoogleClientRequestInitializer;
import com.rigel.jokeprovider.jokeApi.JokeApi;

import java.io.IOException;

/**
 * Created by rigel on 7/9/17.
 */

public class EndpointsAsyncTask extends AsyncTask<Context, Void, String> {
    private static JokeApi jokeAPiService = null;
    private Context context;
    private EndpointCallback callback;

    public EndpointsAsyncTask(EndpointCallback callback){
        this.callback = callback;
    }

    @Override
    protected String doInBackground(Context... contexts) {
        if(jokeAPiService == null) {  // Only do this once
            JokeApi.Builder builder = new JokeApi.Builder(AndroidHttp.newCompatibleTransport(),
                    new AndroidJsonFactory(), null)
                    .setRootUrl("http://192.168.1.125:8080/_ah/api/")
                    .setGoogleClientRequestInitializer(new GoogleClientRequestInitializer() {
                        @Override
                        public void initialize(AbstractGoogleClientRequest<?> abstractGoogleClientRequest) throws IOException {
                            abstractGoogleClientRequest.setDisableGZipContent(true);
                        }
                    });
            // end options for devappserver

            jokeAPiService = builder.build();
        }
        this.context = contexts[0];

        try {
            return jokeAPiService.getJoke().execute().getData();
        } catch (IOException e) {
            return e.getMessage();
        }
    }



    @Override
    protected void onPostExecute(String result) {
        callback.callback(result);
    }

    public interface EndpointCallback{
        void callback(String callback);
    }
}