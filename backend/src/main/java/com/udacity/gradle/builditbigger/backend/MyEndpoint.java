package com.udacity.gradle.builditbigger.backend;

import com.example.javajokes.Joker;
import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.ApiNamespace;

import javax.inject.Named;

/** An endpoint class we are exposing */
@Api(
        name = "myApi",
        version = "v1",
        namespace = @ApiNamespace(
                ownerDomain = "backend.builditbigger.gradle.udacity.com",
                ownerName = "backend.builditbigger.gradle.udacity.com",
                packagePath = ""
        )
)
public class MyEndpoint {

    /** Endpoint method that fetches a joke from
     * the javaJokes java library and returns it */
    @ApiMethod(name = "fetchJoke")
    public MyBean fetchJoke() {
        MyBean response = new MyBean();
        Joker joker = new Joker();
        response.setData(joker.getJoke());

        return response;
    }

}
