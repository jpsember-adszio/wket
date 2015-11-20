package com.js;

import org.apache.wicket.protocol.http.WebSession;
import org.apache.wicket.request.Request;

public class OurSession extends WebSession {

  protected OurSession(Request request) {
    super(request);
  }

  public StringBuilder getNotebook() {
    return mNotebook;
  }

  private StringBuilder mNotebook = new StringBuilder("Notebook\n");
}
