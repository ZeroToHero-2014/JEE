/**
 * ZeroToHeroServlet.java
 *
 * Copyright (c) 2014 Teamnet. All Rights Reserved.
 *
 * This source file may not be copied, modified or redistributed,
 * in whole or in part, in any form or for any reason, without the express
 * written consent of Teamnet.
 **/

package ro.teamnet.z2h.web;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ZeroToHeroServlet extends HttpServlet {

    public String handleRequest(HttpServletRequest req) {

        String response = "Hello <b>" + req.getParameter("firstName") + " " +
                req.getParameter("lastName") + "</b>! Enjoy Zero To Hero!!!";
        return response;
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //todo
        resp.setContentType("text/html");
        resp.getWriter().write(handleRequest(req));
    }
}
