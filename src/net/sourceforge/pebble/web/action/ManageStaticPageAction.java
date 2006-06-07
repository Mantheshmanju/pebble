/*
 * Copyright (c) 2003-2006, Simon Brown
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 *   - Redistributions of source code must retain the above copyright
 *     notice, this list of conditions and the following disclaimer.
 *
 *   - Redistributions in binary form must reproduce the above copyright
 *     notice, this list of conditions and the following disclaimer in
 *     the documentation and/or other materials provided with the
 *     distribution.
 *
 *   - Neither the name of Pebble nor the names of its contributors may
 *     be used to endorse or promote products derived from this software
 *     without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE
 * LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
 * CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF
 * SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS
 * INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN
 * CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE)
 * ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE
 * POSSIBILITY OF SUCH DAMAGE.
 */
package net.sourceforge.pebble.web.action;

import net.sourceforge.pebble.Constants;
import net.sourceforge.pebble.domain.Blog;
import net.sourceforge.pebble.domain.BlogEntry;
import net.sourceforge.pebble.domain.BlogException;
import net.sourceforge.pebble.domain.BlogService;
import net.sourceforge.pebble.web.view.ForwardView;
import net.sourceforge.pebble.web.view.NotFoundView;
import net.sourceforge.pebble.web.view.View;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Allows the user to manage (edit and remove) a static page.
 *
 * @author    Simon Brown
 */
public class ManageStaticPageAction extends SecureAction {

  /** the log used by this class */
  private static final Log log = LogFactory.getLog(ManageStaticPageAction.class);

  /**
   * Peforms the processing associated with this action.
   *
   * @param request  the HttpServletRequest instance
   * @param response the HttpServletResponse instance
   * @return the name of the next view
   */
  public View process(HttpServletRequest request, HttpServletResponse response) throws ServletException {
//    Blog blog = (Blog)getModel().get(Constants.BLOG_KEY);
//    String id = request.getParameter("entry");
//    String confirm = request.getParameter("confirm");
//    String submit = request.getParameter("submit");
//
//    BlogService service = new BlogService();
//    BlogEntry blogEntry = service.getStaticPage(blog, id);
//
//    if (blogEntry == null) {
//      return new NotFoundView();
//    }
//
//    if (submit.equals("Edit")) {
//      return new ForwardView("/editStaticPage.secureaction?entry=" + id);
//    } else if (submit.equalsIgnoreCase("Remove") && confirm != null && confirm.equals("true")) {
//      try {
//        service.removeStaticPage(blogEntry);
//      } catch (BlogException be) {
//        throw new ServletException(be);
//      }
//    }
//
    return new ForwardView("/viewStaticPages.secureaction");
  }

  /**
   * Gets a list of all roles that are allowed to access this action.
   *
   * @return  an array of Strings representing role names
   * @param request
   */
  public String[] getRoles(HttpServletRequest request) {
    String submit = request.getParameter("submit");

    if (submit != null) {
      if (submit.equalsIgnoreCase("Approve")) {
        return new String[]{Constants.BLOG_OWNER_ROLE};
      } else if (submit.equalsIgnoreCase("Reject")) {
        return new String[]{Constants.BLOG_OWNER_ROLE};
      } else if (submit.equalsIgnoreCase("Remove")) {
        return new String[]{Constants.BLOG_CONTRIBUTOR_ROLE};
      }
    }

    // default back to blog owner role
    return new String[]{Constants.BLOG_OWNER_ROLE};
  }

}