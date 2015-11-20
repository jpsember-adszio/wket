package com.js;

import org.apache.wicket.request.mapper.parameter.PageParameters;
import org.apache.wicket.markup.html.WebPage;

public class HomePage extends WebPage {

  public HomePage(final PageParameters parameters) {
    super(parameters);

    add(new LoginPanel("panel"));
    add(new ConsolePanel("console"));

  }

  public OurSession getOurSession() {
    return (OurSession) getSession();
  }

}
