package com.github.momentjsgwt.client;

import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.CssResource;

/**
 * 24/11/2014.
 */
public interface ApplicationResources extends ClientBundle {

    Style style();

    public interface Style extends CssResource {
        String animate();
        @ClassName("class-name")
        String className();
    }
}
