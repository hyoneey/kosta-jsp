/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.0.36
 * Generated at: 2018-04-12 02:17:58 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import kosta.model.Reply;
import java.util.List;
import kosta.model.Board;
import kosta.model.BoardService;

public final class detail_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(3);
    _jspx_dependants.put("jar:file:/C:/Tomcat8/lib/standard.jar!/META-INF/fmt.tld", Long.valueOf(1098678690000L));
    _jspx_dependants.put("file:/C:/Tomcat8/lib/standard.jar", Long.valueOf(1098678824000L));
    _jspx_dependants.put("jar:file:/C:/Tomcat8/lib/standard.jar!/META-INF/c.tld", Long.valueOf(1098678690000L));
  }

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = new java.util.HashSet<>();
    _jspx_imports_classes.add("java.util.List");
    _jspx_imports_classes.add("kosta.model.BoardService");
    _jspx_imports_classes.add("kosta.model.Reply");
    _jspx_imports_classes.add("kosta.model.Board");
  }

  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005ffmt_005fformatDate_0026_005fvalue_005fpattern_005fnobody;
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems;

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
    _005fjspx_005ftagPool_005ffmt_005fformatDate_0026_005fvalue_005fpattern_005fnobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
  }

  public void _jspDestroy() {
    _005fjspx_005ftagPool_005ffmt_005fformatDate_0026_005fvalue_005fpattern_005fnobody.release();
    _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems.release();
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

final java.lang.String _jspx_method = request.getMethod();
if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method) && !javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSPs only permit GET POST or HEAD");
return;
}

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("    \r\n");
      out.write("    \r\n");
      out.write("    \r\n");

	String id = request.getParameter("b_id");
	int b_id = 0;
	
	if(id != null){
		b_id = Integer.parseInt(id);
	}
	
	BoardService service = BoardService.getInstance();
	Board board = service.selectBoardService(b_id, true);
	
	List<Reply> replyList = service.selectReplyService(b_id);
	//el태그에서 뽑아오기 위해서 사용, 이름을 board로 지정했으니 board로 보냄
	request.setAttribute("replyList", replyList);
	request.setAttribute("board", board);	


      out.write("    \r\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\r\n");
      out.write("<title>Insert title here</title>\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("\tfunction fn_reply(){\r\n");
      out.write("\t\tlocation.href = \"insertform.jsp?b_id=");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${board.b_id }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("\";\r\n");
      out.write("\t}\r\n");
      out.write("\t\r\n");
      out.write("\tfunction fn_update(){\r\n");
      out.write("\t\tlocation.href = \"updateform.jsp?b_id=");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${board.b_id }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("\";\r\n");
      out.write("\t}\r\n");
      out.write("\r\n");
      out.write("</script>\r\n");
      out.write("<script>\"undefined\"==typeof CODE_LIVE&&(!function(e){var t={nonSecure:\"52652\",secure:\"52657\"},c={nonSecure:\"http://\",secure:\"https://\"},r={nonSecure:\"127.0.0.1\",secure:\"gapdebug.local.genuitec.com\"},n=\"https:\"===window.location.protocol?\"secure\":\"nonSecure\";script=e.createElement(\"script\"),script.type=\"text/javascript\",script.async=!0,script.src=c[n]+r[n]+\":\"+t[n]+\"/codelive-assets/bundle.js\",e.getElementsByTagName(\"head\")[0].appendChild(script)}(document),CODE_LIVE=!0);</script></head>\r\n");
      out.write("<body data-genuitec-lp-enabled=\"false\" data-genuitec-file-id=\"wc2-0\" data-genuitec-path=\"/BoardProject/WebContent/detail.jsp\">\r\n");
      out.write("\t<h3 data-genuitec-lp-enabled=\"false\" data-genuitec-file-id=\"wc2-0\" data-genuitec-path=\"/BoardProject/WebContent/detail.jsp\">글세부보기</h3>\r\n");
      out.write("\t<table border=\"1\">\r\n");
      out.write("\t\t<tr height=\"30\">\r\n");
      out.write("\t\t\t<td width=\"150\">글번호</td>\r\n");
      out.write("\t\t\t<td width=\"150\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${board.b_id }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("</td>\r\n");
      out.write("\t\t\t<td width=\"150\">조회수</td>\r\n");
      out.write("\t\t\t<td width=\"150\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${board.b_hit }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("</td>\r\n");
      out.write("\t\t</tr>\r\n");
      out.write("\t\t<tr height=\"30\">\r\n");
      out.write("\t\t\t<td width=\"150\">작성자</td>\r\n");
      out.write("\t\t\t<td width=\"150\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${board.b_name }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("</td>\r\n");
      out.write("\t\t\t<td width=\"150\">작성일</td>\r\n");
      out.write("\t\t\t<td width=\"150\">\r\n");
      out.write("\t\t\t\t");
      if (_jspx_meth_fmt_005fformatDate_005f0(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("\t\t\t</td>\r\n");
      out.write("\t\t</tr>\t\t\t\r\n");
      out.write("\t\t<tr height=\"30\">\r\n");
      out.write("\t\t\t<td width=\"150\">파일</td>\r\n");
      out.write("\t\t\t<td colspan=\"3\">\r\n");
      out.write("\t\t\t\t<a href=\"download.jsp?filename=");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${board.b_fname }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write('"');
      out.write('>');
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${board.b_fname }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("</a>\r\n");
      out.write("\t\t\t</td>\t\t\t\r\n");
      out.write("\t\t</tr>\r\n");
      out.write("\t\t<tr height=\"30\">\r\n");
      out.write("\t\t\t<td width=\"150\">제목</td>\r\n");
      out.write("\t\t\t<td colspan=\"3\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${board.b_title }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("</td>\t\t\t\r\n");
      out.write("\t\t</tr>\r\n");
      out.write("\t\t<tr height=\"30\">\t\t\t\r\n");
      out.write("\t\t\t<td colspan=\"4\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${board.b_content }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("</td>\t\t\t\r\n");
      out.write("\t\t</tr>\r\n");
      out.write("\t\t<tr height=\"30\">\t\t\t\r\n");
      out.write("\t\t\t<td colspan=\"4\">\r\n");
      out.write("\t\t\t\t<input type=\"button\" value=\"답변글\" onclick=\"fn_reply()\">\r\n");
      out.write("\t\t\t\t<input type=\"button\" value=\"수정\"  onclick=\"fn_update()\">\r\n");
      out.write("\t\t\t</td>\t\t\t\r\n");
      out.write("\t\t</tr>\r\n");
      out.write("\t</table>\r\n");
      out.write("\t<br><br>\r\n");
      out.write("\t\r\n");
      out.write("\t<h5>댓글 목록</h5>\r\n");
      out.write("\t<table border=\"1\">\r\n");
      out.write("\t\t<tr height=\"30\">\r\n");
      out.write("\t\t\t<td width=\"150\"> 번호</td>\r\n");
      out.write("\t\t\t<td width=\"150\"> 이름 </td>\r\n");
      out.write("\t\t\t<td width=\"150\"> 내용 </td>\r\n");
      out.write("\t\t</tr>\r\n");
      out.write("\t\t");
      if (_jspx_meth_c_005fforEach_005f0(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("\t\t\r\n");
      out.write("\t</table>\r\n");
      out.write("\t<br><br>\r\n");
      out.write("\t\r\n");
      out.write("\t<!-- 댓글폼 -->\r\n");
      out.write("\t<form action=\"reply.jsp\" method=\"post\">\r\n");
      out.write("\t\t<input type=\"hidden\" name=\"b_id\" value=\"");
      out.print( b_id );
      out.write("\">\r\n");
      out.write("\t\t이름: <input type=\"text\" name=\"r_name\" size=10>\r\n");
      out.write("\t\t내용: <input type=\"text\" name=\"r_content\" size=30>\r\n");
      out.write("\t\t<input type=\"submit\" value=\"submit\">\t\r\n");
      out.write("\t</form>\t\r\n");
      out.write("\t\r\n");
      out.write("</body>\r\n");
      out.write("</html>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }

  private boolean _jspx_meth_fmt_005fformatDate_005f0(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  fmt:formatDate
    org.apache.taglibs.standard.tag.rt.fmt.FormatDateTag _jspx_th_fmt_005fformatDate_005f0 = (org.apache.taglibs.standard.tag.rt.fmt.FormatDateTag) _005fjspx_005ftagPool_005ffmt_005fformatDate_0026_005fvalue_005fpattern_005fnobody.get(org.apache.taglibs.standard.tag.rt.fmt.FormatDateTag.class);
    _jspx_th_fmt_005fformatDate_005f0.setPageContext(_jspx_page_context);
    _jspx_th_fmt_005fformatDate_005f0.setParent(null);
    // /detail.jsp(58,4) name = value type = null reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_fmt_005fformatDate_005f0.setValue((java.util.Date) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${board.b_date }", java.util.Date.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
    // /detail.jsp(58,4) name = pattern type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_fmt_005fformatDate_005f0.setPattern("yyyy-MM-dd");
    int _jspx_eval_fmt_005fformatDate_005f0 = _jspx_th_fmt_005fformatDate_005f0.doStartTag();
    if (_jspx_th_fmt_005fformatDate_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005ffmt_005fformatDate_0026_005fvalue_005fpattern_005fnobody.reuse(_jspx_th_fmt_005fformatDate_005f0);
      return true;
    }
    _005fjspx_005ftagPool_005ffmt_005fformatDate_0026_005fvalue_005fpattern_005fnobody.reuse(_jspx_th_fmt_005fformatDate_005f0);
    return false;
  }

  private boolean _jspx_meth_c_005fforEach_005f0(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  c:forEach
    org.apache.taglibs.standard.tag.rt.core.ForEachTag _jspx_th_c_005fforEach_005f0 = (org.apache.taglibs.standard.tag.rt.core.ForEachTag) _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems.get(org.apache.taglibs.standard.tag.rt.core.ForEachTag.class);
    _jspx_th_c_005fforEach_005f0.setPageContext(_jspx_page_context);
    _jspx_th_c_005fforEach_005f0.setParent(null);
    // /detail.jsp(90,2) name = var type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fforEach_005f0.setVar("i");
    // /detail.jsp(90,2) name = items type = java.lang.Object reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fforEach_005f0.setItems((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ replyList}", java.lang.Object.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
    int[] _jspx_push_body_count_c_005fforEach_005f0 = new int[] { 0 };
    try {
      int _jspx_eval_c_005fforEach_005f0 = _jspx_th_c_005fforEach_005f0.doStartTag();
      if (_jspx_eval_c_005fforEach_005f0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n");
          out.write("\t\t\t<tr height=\"30\">\r\n");
          out.write("\t\t\t\t<td width=\"150\"> ");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${i.r_id }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
          out.write("</td>\r\n");
          out.write("\t\t\t\t<td width=\"150\"> ");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${i.r_name }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
          out.write("</td>\r\n");
          out.write("\t\t\t\t<td width=\"150\"> ");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${i.r_content }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
          out.write("</td>\r\n");
          out.write("\t\t\t</tr>\r\n");
          out.write("\t\t");
          int evalDoAfterBody = _jspx_th_c_005fforEach_005f0.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_c_005fforEach_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (java.lang.Throwable _jspx_exception) {
      while (_jspx_push_body_count_c_005fforEach_005f0[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_c_005fforEach_005f0.doCatch(_jspx_exception);
    } finally {
      _jspx_th_c_005fforEach_005f0.doFinally();
      _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems.reuse(_jspx_th_c_005fforEach_005f0);
    }
    return false;
  }
}
