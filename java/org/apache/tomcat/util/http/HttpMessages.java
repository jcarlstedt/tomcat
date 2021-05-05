/*
 *  Licensed to the Apache Software Foundation (ASF) under one or more
 *  contributor license agreements.  See the NOTICE file distributed with
 *  this work for additional information regarding copyright ownership.
 *  The ASF licenses this file to You under the Apache License, Version 2.0
 *  (the "License"); you may not use this file except in compliance with
 *  the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */
package org.apache.tomcat.util.http;

import org.apache.tomcat.util.res.StringManager;

/**
 * Handle (internationalized) HTTP messages.
 *
 * @author James Duncan Davidson [duncan@eng.sun.com]
 * @author James Todd [gonzo@eng.sun.com]
 * @author Jason Hunter [jch@eng.sun.com]
 * @author Harish Prabandham
 * @author costin@eng.sun.com
 */
public class HttpMessages {

    private final StringManager sm;

    private String st_200 = null;
    private String st_302 = null;
    private String st_400 = null;
    private String st_404 = null;
    private String st_500 = null;

    public HttpMessages(StringManager sm) {
        this.sm = sm;
    }

    /**
     * Get the status string associated with a status code. Common messages are
     * cached.
     *
     * @param status The HTTP status code to retrieve the message for
     *
     * @return The HTTP status string that conforms to the requirements of the
     *         HTTP specification
     */
    public String getMessage(int status) {
        // method from Response.

        // Does HTTP requires/allow international messages or
        // are pre-defined? The user doesn't see them most of the time
        switch( status ) {
        case 200:
            if(st_200 == null ) {
                st_200 = sm.getString("sc.200");
            }
            return st_200;
        case 302:
            if(st_302 == null ) {
                st_302 = sm.getString("sc.302");
            }
            return st_302;
        case 400:
            if(st_400 == null ) {
                st_400 = sm.getString("sc.400");
            }
            return st_400;
        case 404:
            if(st_404 == null ) {
                st_404 = sm.getString("sc.404");
            }
            return st_404;
        case 500:
            if (st_500 == null) {
                st_500 = sm.getString("sc.500");
            }
            return st_500;
        }
        return sm.getString("sc."+ status);
    }
}