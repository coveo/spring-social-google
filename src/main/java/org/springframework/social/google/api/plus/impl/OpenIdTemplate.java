/**
 * Copyright (c) 2011 - 2018, Coveo Solutions Inc.
 */
package org.springframework.social.google.api.plus.impl;

import org.springframework.social.google.api.impl.AbstractGoogleApiOperations;
import org.springframework.social.google.api.plus.OpenIdOperations;
import org.springframework.social.google.api.plus.Person;
import org.springframework.web.client.RestTemplate;

public class OpenIdTemplate extends AbstractGoogleApiOperations implements OpenIdOperations
{
    private static final String USER_INFO_ENDPOINT = "https://www.googleapis.com/oauth2/v3/userinfo";

    public OpenIdTemplate(RestTemplate restTemplate, boolean isAuthorized)
    {
        super(restTemplate, isAuthorized);
    }

    @Override
    public Person getGoogleProfile()
    {
        return getEntity(USER_INFO_ENDPOINT, Person.class);
    }
}
