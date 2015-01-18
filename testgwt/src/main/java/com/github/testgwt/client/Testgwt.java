package com.github.testgwt.client;

import com.github.testgwt.shared.FieldVerifier;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.KeyCodes;
import com.google.gwt.event.dom.client.KeyUpEvent;
import com.google.gwt.event.dom.client.KeyUpHandler;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.*;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class Testgwt implements EntryPoint, ClickHandler, KeyUpHandler {

  private final ApplicationResources resources = GWT.create(ApplicationResources.class);
  final TextBox nameField = new TextBox();
  final Button sendButton = new Button( "Envoyer" );
  final Label errorLabel = new Label();
  final DialogBox dialogBox = new DialogBox();
  final Button closeButton = new Button("Close");
  final Label textToServerLabel = new Label();

  /**
   * This is the entry point method.
   */
  public void onModuleLoad() {
    resources.style().ensureInjected();

    sendButton.addStyleName(resources.style().animate());
    GWT.log("toto");

    nameField.setText( "Entrer votre nom" );
    errorLabel.addStyleName(resources.style().className());

    // We can add style names to widgets
    sendButton.addStyleName("sendButton");

    // Add the nameField and sendButton to the RootPanel
    // Use RootPanel.get() to get the entire body element
    RootPanel.get("nameFieldContainer").add(nameField);
    RootPanel.get("sendButtonContainer").add(sendButton);
    RootPanel.get("errorLabelContainer").add(errorLabel);

    // Focus the cursor on the name field when the app loads
    nameField.setFocus(true);
    nameField.selectAll();
    GWT.debugger();
    // Create the popup dialog box
    dialogBox.setText("Remote Procedure Call");
    dialogBox.setAnimationEnabled(true);
    dialogBox.setAnimationType(PopupPanel.AnimationType.ROLL_DOWN);
    // We can set the id of a widget by accessing its Element
    closeButton.getElement().setId("closeButton");
    VerticalPanel dialogVPanel = new VerticalPanel();
    dialogVPanel.addStyleName("dialogVPanel");
    dialogVPanel.add(new HTML("<b>Setting name:</b>"));
    dialogVPanel.add(textToServerLabel);
    dialogVPanel.setHorizontalAlignment(VerticalPanel.ALIGN_RIGHT);
    dialogVPanel.add(closeButton);
    dialogBox.setWidget(dialogVPanel);

    // Add a handler to close the DialogBox
    closeButton.addClickHandler(new ClickHandler() {
      public void onClick(ClickEvent event) {
        dialogBox.hide();
        sendButton.setEnabled(true);
        sendButton.setFocus(true);
      }
    });

    sendButton.addClickHandler(this);
    nameField.addKeyUpHandler(this);
  }

  /**
   * Fired when the user clicks on the sendButton.
   */
  public void onClick(ClickEvent event) {
    sendNameToServer();
  }

  /**
   * Fired when the user types in the nameField.
   */
  public void onKeyUp(KeyUpEvent event) {
    if (event.getNativeKeyCode() == KeyCodes.KEY_ENTER) {
      sendNameToServer();
    }
  }

  /**
   * Send the name from the nameField to the server and wait for a response.
   */
  private void sendNameToServer(String name) {
    // Then, we send the input to the server.
    sendButton.setEnabled(false);
    textToServerLabel.setText(name);
    dialogBox.setText("Remote Procedure Call");
  }
}
