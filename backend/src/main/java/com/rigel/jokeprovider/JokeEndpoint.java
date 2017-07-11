/*
   For step-by-step instructions on connecting your Android application to this backend module,
   see "App Engine Java Endpoints Module" template documentation at
   https://github.com/GoogleCloudPlatform/gradle-appengine-templates/tree/master/HelloEndpoints
*/

package com.rigel.jokeprovider;

import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.ApiNamespace;
import com.jokelib.Joker;

/**
 * An endpoint class we are exposing
 */
@Api(
        name = "jokeApi",
        version = "v1",
        namespace = @ApiNamespace(
                ownerDomain = "jokeprovider.rigel.com",
                ownerName = "jokeprovider.rigel.com",
                packagePath = ""
        )
)
public class JokeEndpoint {

    @ApiMethod(name = "getJoke")
    public Joke getJoke() {
        Joke response = new Joke();
        response.setData(new Joker().getJoke());

        return response;
    }

}
