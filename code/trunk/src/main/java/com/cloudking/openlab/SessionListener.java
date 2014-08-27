package com.cloudking.openlab;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class SessionListener implements HttpSessionListener{
    public static long sessionCount;

    @Override
    public void sessionCreated(HttpSessionEvent arg0) {
        sessionCount++;
        arg0.getSession().setAttribute(PropertyManager.VISITOR_COUNT, sessionCount);
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent arg0) {
        
    }

}
