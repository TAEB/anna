/*
 * Copyright 2003-2004 The Apache Software Foundation
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
package org.apache.commons.net.telnet;

/***
 * The InvalidTelnetOptionException is the exception that is
 * thrown whenever a TelnetOptionHandler with an invlaid
 * option code is registered in TelnetClient with addOptionHandler.
 * <p>
 * @author Bruno D'Avanzo
 ***/
public class InvalidTelnetOptionException extends Exception
{

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/***
     * Option code
     ***/
    private int optionCode = -1;

    /***
     * Error message
     ***/
    private String msg;

    /***
     * Constructor for the exception.
     * <p>
     * @param message - Error message.
     * @param optcode - Option code.
     ***/
    public InvalidTelnetOptionException(String message, int optcode)
    {
        optionCode = optcode;
        msg = message;
    }

    /***
     * Gets the error message of ths exception.
     * <p>
     * @return the error message.
     ***/
    public String getMessage()
    {
        return (msg + ": " + optionCode);
    }
}
