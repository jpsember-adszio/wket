package com.js;

import org.apache.wicket.Session;
import org.apache.wicket.protocol.http.WebSession;
import org.apache.wicket.request.Request;

public class OurSession extends WebSession {

  protected OurSession(Request request) {
    super(request);
  }

  public StringBuilder getNotebook() {
    return mNotebook;
  }

  public static OurSession get() {
    return (OurSession) Session.get();
  }

  private StringBuilder mNotebook = new StringBuilder("Notebook\n");
}
