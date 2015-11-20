package com.js;

import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.panel.Panel;

public class LoginPanel extends Panel {

  public LoginPanel(String id) {
    super(id);

    Form form = new Form("form_login") {
      @Override
      protected void onSubmit() {
        System.out.println("form was submitted!");
      }
    };
    add(form);

    form.add(new Label("username"));
    form.add(new Label("password"));
  }
}
