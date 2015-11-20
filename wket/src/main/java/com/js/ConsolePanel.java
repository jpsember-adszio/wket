package com.js;

import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.markup.html.basic.MultiLineLabel;
import org.apache.wicket.model.Model;

public class ConsolePanel extends Panel {

  public ConsolePanel(String id) {
    super(id);

    add(new MultiLineLabel("text", new Model<String>() {
      @Override
      public String getObject() {
        OurSession session = OurSession.get();
        StringBuilder notebook = session.getNotebook();
        return notebook.toString();
      }
    }));
  }
}
