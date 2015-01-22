package com.github.testgwt.client;

import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.CssResource;
import com.google.gwt.resources.client.ImageResource;

/**
 * 24/11/2014.
 */
public interface ApplicationResources extends ClientBundle {

    Style style();
    
    ImageResource logo();

    public interface Style extends CssResource {
        String animate();
        @ClassName("class-name")
        String className();
        
        String col1();
        String col2();
        String col3();
        String col4();
        String mySpriteClass();
        String demi();
    }
}
