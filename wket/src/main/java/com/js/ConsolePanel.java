package com.js;

import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.markup.html.basic.MultiLineLabel;

public class ConsolePanel extends Panel {

  public ConsolePanel(String id) {
    super(id);

    String text = "\n...console text here...\n";

    add(new MultiLineLabel("text", text));
  }
}
