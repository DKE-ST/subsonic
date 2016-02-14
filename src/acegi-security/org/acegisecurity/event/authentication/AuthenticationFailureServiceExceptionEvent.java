/* Copyright 2004, 2005, 2006 Acegi Technology Pty Limited
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.acegisecurity.event.authentication;

import org.acegisecurity.Authentication;
import org.acegisecurity.AuthenticationException;


/**
 * Application event which indicates authentication failure due to there being a problem internal to the
 * <code>AuthenticationManager</code>.
 *
 * @author Ben Alex
 * @version $Id: AuthenticationFailureServiceExceptionEvent.java 1496 2006-05-23 13:38:33Z benalex $
 */
public class AuthenticationFailureServiceExceptionEvent extends AbstractAuthenticationFailureEvent {
    //~ Constructors ===================================================================================================

    public AuthenticationFailureServiceExceptionEvent(Authentication authentication, AuthenticationException exception) {
        super(authentication, exception);
    }
}
