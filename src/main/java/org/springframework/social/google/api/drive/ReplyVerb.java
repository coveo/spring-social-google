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
package org.springframework.social.google.api.drive;

import org.springframework.social.google.api.drive.impl.ReplyVerbDeserializer;
import org.springframework.social.google.api.impl.ApiEnumSerializer;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

/**
 * Enum representing a comment reply verb (resolve or reopen)
 * @author Gabriel Axel
 */
@JsonSerialize(using = ApiEnumSerializer.class)
@JsonDeserialize(using = ReplyVerbDeserializer.class)
public enum ReplyVerb
{

    RESOLVE, REOPEN
}