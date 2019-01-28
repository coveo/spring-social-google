/*
 * Copyright 2011 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.springframework.social.google.connect;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.social.ApiException;
import org.springframework.social.connect.ApiAdapter;
import org.springframework.social.connect.ConnectionValues;
import org.springframework.social.connect.UserProfile;
import org.springframework.social.connect.UserProfileBuilder;
import org.springframework.social.google.api.Google;
import org.springframework.social.google.api.openid.Person;

/**
 * Google ApiAdapter implementation.
 *
 * @author Gabriel Axel
 */
public class GoogleAdapter implements ApiAdapter<Google>
{
    private static final Logger logger = LoggerFactory.getLogger(GoogleAdapter.class);

    @Override
    public boolean test(Google google)
    {
        try {
            google.openIdOperations().getGoogleProfile();
            return true;
        } catch (ApiException e) {
            return false;
        }
    }

    @Override
    public void setConnectionValues(Google google, ConnectionValues values)
    {
        Person profile = google.openIdOperations().getGoogleProfile();
        values.setProviderUserId(profile.getSub());
        values.setDisplayName(profile.getName());
        values.setProfileUrl(profile.getProfile());
        values.setImageUrl(profile.getPicture());
    }

    @Override
    public UserProfile fetchUserProfile(Google google)
    {
        Person profile = google.openIdOperations().getGoogleProfile();
        Boolean emailVerified = profile.isEmailVerified();
        if (emailVerified == null) {
            logger.warn("User '{}' has a null email_verified field.", profile.getEmail());
        } else if (!emailVerified) {
            logger.warn("User '{}' has an email not verified!", profile.getEmail());
        }
        return new UserProfileBuilder().setUsername(profile.getSub())
                                       .setEmail(profile.getEmail())
                                       .setName(profile.getName())
                                       .setFirstName(profile.getGivenName())
                                       .setLastName(profile.getFamilyName())
                                       .build();
    }

    @Override
    public void updateStatus(Google google, String message)
    {
        throw new UnsupportedOperationException();
    }
}
