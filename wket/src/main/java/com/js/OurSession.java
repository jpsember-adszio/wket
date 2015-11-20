package com.js;

import org.apache.wicket.Session;
import org.apache.wicket.protocol.http.WebSession;
import org.apache.wicket.request.Request;

public class OurSession extends WebSession {

  private static final int MAX_CONSOLE_ROWS = 8;

  protected OurSession(Request request) {
    super(request);
  }

  public static OurSession get() {
    return (OurSession) Session.get();
  }

  public String getLog() {
    return mNotebook.toString();
  }

  public static void pr(Object message) {
    get().log(message);
  }

  public void log(Object message) {
    String str = message.toString().trim();
    String[] rows = mNotebook.toString().split("\n");
    int cursor = Math.max(0, rows.length - MAX_CONSOLE_ROWS);
    mNotebook.setLength(0);
    for (; cursor < rows.length; cursor++) {
      mNotebook.append(rows[cursor]);
      mNotebook.append("\n");
    }
    mNotebook.append(str);
  }

  private StringBuilder mNotebook = new StringBuilder();
}
