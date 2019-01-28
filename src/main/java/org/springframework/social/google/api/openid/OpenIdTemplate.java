/**
 * Copyright (c) 2011 - 2018, Coveo Solutions Inc.
 */
package org.springframework.social.google.api.openid;

import org.springframework.web.client.RestTemplate;

public class OpenIdTemplate implements OpenIdOperations
{
    private static final String USER_INFO_ENDPOINT = "https://www.googleapis.com/oauth2/v3/userinfo";

    private final RestTemplate restTemplate;

    public OpenIdTemplate(RestTemplate restTemplate)
    {
        this.restTemplate = restTemplate;
    }

    @Override
    public Person getGoogleProfile()
    {
        return getEntity(USER_INFO_ENDPOINT, Person.class);
    }

    private <T> T getEntity(String url, Class<T> type)
    {
        return restTemplate.getForObject(url, type);
    }
}
