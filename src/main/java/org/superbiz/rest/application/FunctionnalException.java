package org.superbiz.rest.application;

import java.io.Serializable;

/**
 * Created by eric on 20/05/16.
 */
public class FunctionnalException  extends Exception implements Serializable{

    public FunctionnalException() {
        super();
    }

    public FunctionnalException(String text) {
        super(text);
    }

    public FunctionnalException(String text, Exception e) {
        super(text,e);
    }
}
