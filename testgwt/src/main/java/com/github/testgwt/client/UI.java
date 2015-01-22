package com.github.testgwt.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.js.JsExport;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.HTMLPanel;

/**
 * Created by b002kla on 26/11/2014.
 */
public class UI extends Composite {
    interface UIUiBinder extends UiBinder<HTMLPanel, UI> {
    }

    private static UIUiBinder ourUiBinder = GWT.create(UIUiBinder.class);

    public UI() {
        initWidget(ourUiBinder.createAndBindUi(this));
    }
    
    @JsExport("$wnd.gwtExport")
    public static void gwtExport(String name) {
  	  DialogBox dialog = new DialogBox(true);
  	  dialog.setText(name);
  	  dialog.setWidget(new UI());
  	  dialog.center();
    }
}