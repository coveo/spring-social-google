/**
 * Copyright (c) 2011 - 2018, Coveo Solutions Inc.
 */
package org.springframework.social.google.api.plus;

public interface OpenIdOperations
{
    /**
     * Retrieves the authenticated user's Google profile.
     *
     * @return the retrieved {@link Person}
     */
    Person getGoogleProfile();
}
