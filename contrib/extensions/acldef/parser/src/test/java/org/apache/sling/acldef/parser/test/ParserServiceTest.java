/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.sling.acldef.parser.test;

import java.io.Reader;
import java.io.StringReader;

import org.apache.sling.acldef.parser.AclParsingException;
import org.apache.sling.acldef.parser.impl.ACLDefinitionsParserService;
import org.junit.Test;

public class ParserServiceTest {
    @Test
    public void noErrors() throws AclParsingException {
        final Reader r = new StringReader("create service user foo");
        new ACLDefinitionsParserService().parse(r);
    }
    
    @Test(expected = AclParsingException.class)
    public void syntaxError() throws AclParsingException {
        final Reader r = new StringReader("not a valid statement");
        new ACLDefinitionsParserService().parse(r);
    }
}