/*
 * Copyright 2012-2015 Institute of Computer Science,
 * Foundation for Research and Technology - Hellas
 *
 * Licensed under the EUPL, Version 1.1 or - as soon they will be approved
 * by the European Commission - subsequent versions of the EUPL (the "Licence");
 * You may not use this work except in compliance with the Licence.
 * You may obtain a copy of the Licence at:
 *
 * http://ec.europa.eu/idabc/eupl
 *
 * Unless required by applicable law or agreed to in writing, software distributed
 * under the Licence is distributed on an "AS IS" basis,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the Licence for the specific language governing permissions and limitations
 * under the Licence.
 *
 * Contact:  POBox 1385, Heraklio Crete, GR-700 13 GREECE
 * Tel:+30-2810-391632
 * Fax: +30-2810-391638
 * E-mail: isl@ics.forth.gr
 * http://www.ics.forth.gr/isl
 *
 * Authors : Georgios Samaritakis, Konstantina Konsolaki.
 *
 * This file is part of the SchemaReader project.
 */
package schemareader;

import org.xml.sax.ErrorHandler;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

/**
 * Customized ErrorHandler for SchemaFile
 * @author samarita
 */
public class MyErrorHandler implements ErrorHandler {

    StringBuffer errorLog = new StringBuffer();

    public void warning(SAXParseException ex) {
        setLog(ex);
    }

    public void error(SAXParseException ex) throws SAXException {
        setLog(ex);
        throw ex;
    }

    public void fatalError(SAXParseException ex) throws SAXException {
        setLog(ex);
        System.err.println(ex.getMessage());
        throw ex;
    }

   

    private void setLog(SAXParseException e) {
            errorLog = errorLog.append("XML File: ").append(e.getSystemId());
            errorLog = errorLog.append("\nLine: ").append(e.getLineNumber());
            errorLog = errorLog.append("\nColumn: ").append(e.getColumnNumber());
            errorLog = errorLog.append("\nMessage: ").append(e.getMessage());
      
    }

    /**
     *
     * @return
     */
    public String getLog() {
        return this.errorLog.toString();
    }
}
