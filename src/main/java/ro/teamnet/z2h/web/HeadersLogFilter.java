/**
 * HeadersLogFilter.java
 *
 * Copyright (c) 2014 Teamnet. All Rights Reserved.
 *
 * This source file may not be copied, modified or redistributed,
 * in whole or in part, in any form or for any reason, without the express
 * written consent of Teamnet.
 **/

package ro.teamnet.z2h.web;

import ro.teamnet.z2h.file.LogFileWriter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Enumeration;

public class HeadersLogFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        Enumeration headers=((HttpServletRequest) request).getHeaderNames();
        while (headers.hasMoreElements()){
            String headerName= (String) headers.nextElement();
            String headerValue=((HttpServletRequest) request).getHeader(headerName);
            LogFileWriter.logHeader(headerName,headerValue);
        }
    }

    @Override
    public void destroy() {

    }
}
