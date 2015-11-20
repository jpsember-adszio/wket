package com.js;

import org.apache.wicket.Session;
import org.apache.wicket.protocol.http.WebSession;
import org.apache.wicket.request.Request;

public class OurSession extends WebSession {

  protected OurSession(Request request) {
    super(request);
  }

  public static OurSession get() {
    return (OurSession) Session.get();
  }

  public String getLog() {
    return mConsoleText.toString();
  }

  public static void pr(Object message) {
    get().log(message);
  }

  public void log(Object message) {
    final int MAX_CONSOLE_ROWS = 8;
    String str = message.toString().trim();
    String[] rows = mConsoleText.toString().split("\n");
    int cursor = Math.max(0, rows.length - MAX_CONSOLE_ROWS);
    mConsoleText.setLength(0);
    for (; cursor < rows.length; cursor++) {
      mConsoleText.append(rows[cursor]);
      mConsoleText.append("\n");
    }
    mConsoleText.append(str);
  }

  private StringBuilder mConsoleText = new StringBuilder();
}
