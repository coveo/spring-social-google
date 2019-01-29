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
package org.springframework.social.google.api.openid;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Person
{
    @JsonProperty("given_name")
    private String givenName;
    @JsonProperty("family_name")
    private String familyName;
    @JsonProperty("email_verified")
    private Boolean emailVerified;
    @JsonProperty("sub")
    private String subjectIdentifier;
    @JsonProperty("hd")
    private String hostedDomain;

    private String name;
    private String profile;
    private String picture;
    private String email;
    private String locale;

    public String getSubjectIdentifier()
    {
        return subjectIdentifier;
    }

    public void setSubjectIdentifier(String subjectIdentifier)
    {
        this.subjectIdentifier = subjectIdentifier;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getGivenName()
    {
        return givenName;
    }

    public void setGivenName(String givenName)
    {
        this.givenName = givenName;
    }

    public String getFamilyName()
    {
        return familyName;
    }

    public void setFamilyName(String familyName)
    {
        this.familyName = familyName;
    }

    public String getProfile()
    {
        return profile;
    }

    public void setProfile(String profile)
    {
        this.profile = profile;
    }

    public String getPicture()
    {
        return picture;
    }

    public void setPicture(String picture)
    {
        this.picture = picture;
    }

    public String getEmail()
    {
        return email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    public Boolean isEmailVerified()
    {
        return emailVerified;
    }

    public void setEmailVerified(Boolean emailVerified)
    {
        this.emailVerified = emailVerified;
    }

    public String getLocale()
    {
        return locale;
    }

    public void setLocale(String locale)
    {
        this.locale = locale;
    }

    public String getHostedDomain()
    {
        return hostedDomain;
    }

    public void setHostedDomain(String hostedDomain)
    {
        this.hostedDomain = hostedDomain;
    }
}
