/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.0.44
 * Generated at: 2018-02-27 01:17:10 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = null;
  }

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
  }

  public void _jspDestroy() {
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
      response.setContentType("text/html; charset=ISO-8859-1");
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
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\r\n");
      out.write("<html lang = \"en\">\r\n");
      out.write("\r\n");
      out.write("\t<head>\r\n");
      out.write("\t\t<meta http-equiv=\"Content-Type\" content=\"text/html; charset=ISO-8859-1\">\r\n");
      out.write("\t\t<title>PokeMerch</title>\r\n");
      out.write("\t\t<script type=\"text/javascript\" src=\"jquery-3.2.1.min.js\"></script>\r\n");
      out.write("\t\t<script type=\"text/javascript\" src=\"script/UserProducts.js\"></script>\r\n");
      out.write("\t\t<link rel = \"shortcut icon\" href = \"http://cliparts.co/cliparts/rij/rpj/rijrpj4rT.png\" />\r\n");
      out.write("\t\t<link rel = \"stylesheet\" href = \"https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css\">\r\n");
      out.write("\t\t<style>\r\n");
      out.write("\t\t\t::-webkit-scrollbar-track {\r\n");
      out.write("\t\t\t\t-webkit-box-shadow: inset 0 0 6px rgba(0,0,0,0.3);\r\n");
      out.write("\t\t\t\tborder: 10px;\r\n");
      out.write("\t\t\t\tbackground-color: #F5F5F5;\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\r\n");
      out.write("\t\t\t::-webkit-scrollbar {\r\n");
      out.write("\t\t\t\twidth: 5px;\r\n");
      out.write("\t\t\t\tbackground-color: #F5F5F5;\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\r\n");
      out.write("\t\t\t::-webkit-scrollbar-thumb {\r\n");
      out.write("\t\t\t\tborder: 10px;\r\n");
      out.write("\t\t\t\t-webkit-box-shadow: inset 0 0 6px rgba(0,0,0,.3);\r\n");
      out.write("\t\t\t\tbackground-color: #555;\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\r\n");
      out.write("\t\t\t@font-face {\r\n");
      out.write("\t\t\t    font-family: Montserrat;\r\n");
      out.write("\t\t\t    src: url(\"Montserrat/Montserrat-Regular.ttf\");\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\tbody {\r\n");
      out.write("\t\t\t\toverflow-x: hidden;\r\n");
      out.write("\t\t\t\t/*background: url('images/minimalism_background_macro_chip_board_circuit_74408_1920x1080.jpg');\r\n");
      out.write("\t\t\t\tbackground-size: cover;\r\n");
      out.write("\t\t\t\tbackground-repeat: no-repeat;*/\r\n");
      out.write("                background-color: #FBFCFC;\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\ta {\r\n");
      out.write("\t\t\t\ttext-decoration: none;\r\n");
      out.write("                color: #353535;\r\n");
      out.write("\t\t\t}\r\n");
      out.write("            \r\n");
      out.write("            .separator {\r\n");
      out.write("                padding: 5px;\r\n");
      out.write("            }\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t#container {\r\n");
      out.write("\t\t\t\toverflow: hidden;\r\n");
      out.write("                width: 1350px;\r\n");
      out.write("                position: relative;\r\n");
      out.write("                margin: 0 auto;\r\n");
      out.write("                top: 100px;\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t#registerFormat {\r\n");
      out.write("\t\t\t\tfloat: left;\r\n");
      out.write("\t\t\t\twidth: 65%;\r\n");
      out.write("\t\t\t\theight: 100%;\r\n");
      out.write("\t\t\t\tdisplay: inline-block;\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t#registerContainer {\r\n");
      out.write("\t\t\t\tposition: relative;\r\n");
      out.write("\t\t\t\ttop: 100px;\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t#titleCaption {\r\n");
      out.write("\t\t\t\tposition: relative;\r\n");
      out.write("                width: 175px;\r\n");
      out.write("\t\t\t\tcolor: #353535;\r\n");
      out.write("                float: left;\r\n");
      out.write("                bottom: 15px;\r\n");
      out.write("\t\t\t\tfont-family: Montserrat, Sans-serif;\r\n");
      out.write("                font-size: 14px;\r\n");
      out.write("                font-weight: bold;\r\n");
      out.write("                text-align: left;\r\n");
      out.write("                height: 40px;\r\n");
      out.write("                display: block;\r\n");
      out.write("                text-transform: uppercase;\r\n");
      out.write("                letter-spacing: 1px;\r\n");
      out.write("                line-height: 40px;\r\n");
      out.write("                transition: all .15s ease-in-out;\r\n");
      out.write("\t\t\t}\r\n");
      out.write("            \r\n");
      out.write("            #titleCaption:hover {\r\n");
      out.write("                color: #BBBBBB;\r\n");
      out.write("                text-decoration: none;\r\n");
      out.write("                transition: all .15s ease-in-out;\r\n");
      out.write("            }\r\n");
      out.write("            \r\n");
      out.write("            #header {\r\n");
      out.write("                position: relative;\r\n");
      out.write("                width: 85%;\r\n");
      out.write("                height: 40px;\r\n");
      out.write("                left: 100px;\r\n");
      out.write("                border-bottom: 2px solid #3C5AA6;\r\n");
      out.write("            }\r\n");
      out.write("            \r\n");
      out.write("            #search {\r\n");
      out.write("                display: inline;\r\n");
      out.write("\t\t\t\tposition: relative;\r\n");
      out.write("\t\t\t\theight: 30px;\r\n");
      out.write("\t\t\t\twidth: 35%;\r\n");
      out.write("                margin: 0 auto;\r\n");
      out.write("\t\t\t\tleft: 200px;\r\n");
      out.write("\t\t\t\ttop: 2px;\r\n");
      out.write("\t\t\t\tfont-size: 13px;\r\n");
      out.write("                text-align: center;\r\n");
      out.write("\t\t\t\tborder: 1px solid #E7E7E7;\r\n");
      out.write("                border-radius: 2px;\r\n");
      out.write("\t\t\t\tbackground-color: #F7F7F7;\r\n");
      out.write("\t\t\t\tcolor: #353535;\r\n");
      out.write("\t\t\t\tfont-family: Montserrat, Sans-serif;\r\n");
      out.write("\t\t\t\toutline: none;\r\n");
      out.write("\t\t\t\tfont-weight: bold;\r\n");
      out.write("                transition: all .15s ease-in-out;\r\n");
      out.write("\t\t\t\tletter-spacing: 1px;\r\n");
      out.write("\t\t\t}\r\n");
      out.write("            \r\n");
      out.write("            #search:focus {\r\n");
      out.write("                transition: all .15s ease-in-out;\r\n");
      out.write("                box-shadow: 0px 0px 1px 1px #3C5AA6;\r\n");
      out.write("            }\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t#search::-webkit-input-placeholder {\r\n");
      out.write("\t\t\t\tcolor: #353535;\r\n");
      out.write("\t\t\t\topacity: 0.75;\r\n");
      out.write("\t\t\t\tletter-spacing: 0px;\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t#account {\r\n");
      out.write("\t\t\t\tposition: relative;\r\n");
      out.write("                float: right;\r\n");
      out.write("                display: inline;\r\n");
      out.write("                bottom: 14px;\r\n");
      out.write("                right: 40px;\r\n");
      out.write("                text-align: right;\r\n");
      out.write("\t\t\t\tcolor: #353535;\r\n");
      out.write("\t\t\t\tfont-family: Montserrat, Sans-serif;\r\n");
      out.write("                font-size: 14px;\r\n");
      out.write("                font-weight: bold;\r\n");
      out.write("                height: 40px;\r\n");
      out.write("                text-transform: uppercase;\r\n");
      out.write("                letter-spacing: 1px;\r\n");
      out.write("                line-height: 40px;\r\n");
      out.write("                transition: all .15s ease-in-out;\r\n");
      out.write("\t\t\t\tdisplay: none;\r\n");
      out.write("\t\t\t}\r\n");
      out.write("            \r\n");
      out.write("            #account:hover {\r\n");
      out.write("                color: #BBBBBB;\r\n");
      out.write("                text-decoration: none;\r\n");
      out.write("                transition: all .15s ease-in-out;\r\n");
      out.write("            }\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t#sign-out {\r\n");
      out.write("\t\t\t\tposition: relative;\r\n");
      out.write("                float: right;\r\n");
      out.write("                display: inline;\r\n");
      out.write("                bottom: 14px;\r\n");
      out.write("                right: 20px;\r\n");
      out.write("                text-align: right;\r\n");
      out.write("\t\t\t\tcolor: #353535;\r\n");
      out.write("\t\t\t\tfont-family: Montserrat, Sans-serif;\r\n");
      out.write("                font-size: 14px;\r\n");
      out.write("                font-weight: bold;\r\n");
      out.write("                height: 40px;\r\n");
      out.write("                text-transform: uppercase;\r\n");
      out.write("                letter-spacing: 1px;\r\n");
      out.write("                line-height: 40px;\r\n");
      out.write("                transition: all .15s ease-in-out;\r\n");
      out.write("\t\t\t\tdisplay: none;\r\n");
      out.write("\t\t\t}\r\n");
      out.write("            \r\n");
      out.write("            #sign-out:hover {\r\n");
      out.write("                color: #BBBBBB;\r\n");
      out.write("                text-decoration: none;\r\n");
      out.write("                transition: all .15s ease-in-out;\r\n");
      out.write("            }\r\n");
      out.write("            \r\n");
      out.write("            #sign-in {\r\n");
      out.write("\t\t\t\tposition: relative;\r\n");
      out.write("                float: right;\r\n");
      out.write("                display: inline;\r\n");
      out.write("                bottom: 14px;\r\n");
      out.write("                right: 40px;\r\n");
      out.write("                text-align: right;\r\n");
      out.write("\t\t\t\tcolor: #353535;\r\n");
      out.write("\t\t\t\tfont-family: Montserrat, Sans-serif;\r\n");
      out.write("                font-size: 14px;\r\n");
      out.write("                font-weight: bold;\r\n");
      out.write("                height: 40px;\r\n");
      out.write("                text-transform: uppercase;\r\n");
      out.write("                letter-spacing: 1px;\r\n");
      out.write("                line-height: 40px;\r\n");
      out.write("                transition: all .15s ease-in-out;\r\n");
      out.write("\t\t\t}\r\n");
      out.write("            \r\n");
      out.write("            #sign-in:hover {\r\n");
      out.write("                color: #BBBBBB;\r\n");
      out.write("                text-decoration: none;\r\n");
      out.write("                transition: all .15s ease-in-out;\r\n");
      out.write("            }\r\n");
      out.write("            \r\n");
      out.write("            #join {\r\n");
      out.write("\t\t\t\tposition: relative;\r\n");
      out.write("                float: right;\r\n");
      out.write("                display: inline;\r\n");
      out.write("                bottom: 14px;\r\n");
      out.write("                right: 20px;\r\n");
      out.write("                text-align: right;\r\n");
      out.write("\t\t\t\tcolor: #353535;\r\n");
      out.write("\t\t\t\tfont-family: Montserrat, Sans-serif;\r\n");
      out.write("                font-size: 14px;\r\n");
      out.write("                font-weight: bold;\r\n");
      out.write("                height: 40px;\r\n");
      out.write("                text-transform: uppercase;\r\n");
      out.write("                letter-spacing: 1px;\r\n");
      out.write("                line-height: 40px;\r\n");
      out.write("                transition: all .15s ease-in-out;\r\n");
      out.write("\t\t\t}\r\n");
      out.write("            \r\n");
      out.write("            #join:hover {\r\n");
      out.write("                color: #BBBBBB;\r\n");
      out.write("                text-decoration: none;\r\n");
      out.write("                transition: all .15s ease-in-out;\r\n");
      out.write("            }\r\n");
      out.write("            \r\n");
      out.write("            #myCart {\r\n");
      out.write("\t\t\t\tposition: relative;\r\n");
      out.write("                float: right;\r\n");
      out.write("                display: inline;\r\n");
      out.write("                bottom: 14px;\r\n");
      out.write("                text-align: right;\r\n");
      out.write("\t\t\t\tcolor: #353535;\r\n");
      out.write("\t\t\t\tfont-family: Montserrat, Sans-serif;\r\n");
      out.write("                font-size: 14px;\r\n");
      out.write("                font-weight: bold;\r\n");
      out.write("                height: 40px;\r\n");
      out.write("                text-transform: uppercase;\r\n");
      out.write("                letter-spacing: 1px;\r\n");
      out.write("                line-height: 40px;\r\n");
      out.write("                transition: all .15s ease-in-out;\r\n");
      out.write("\t\t\t}\r\n");
      out.write("            \r\n");
      out.write("            #myCart:hover {\r\n");
      out.write("                color: #BBBBBB;\r\n");
      out.write("                text-decoration: none;\r\n");
      out.write("                transition: all .15s ease-in-out;\r\n");
      out.write("            }\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t#nav {\r\n");
      out.write("                position: relative;\r\n");
      out.write("                width: 85%;\r\n");
      out.write("                height: 5%;\r\n");
      out.write("                left: 100px;\r\n");
      out.write("            }\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t#subCaption {\r\n");
      out.write("\t\t\t\tposition: relative;\r\n");
      out.write("                float: left;\r\n");
      out.write("                width: 130%;\r\n");
      out.write("                padding-top: 20px;\r\n");
      out.write("                bottom: 40px;\r\n");
      out.write("\t\t\t\tfont-size: 12px;\r\n");
      out.write("                letter-spacing: 0.5px;\r\n");
      out.write("                font-weight: bold;\r\n");
      out.write("\t\t\t\tcolor: #353535;\r\n");
      out.write("\t\t\t\tfont-family: Montserrat, Sans-serif; \r\n");
      out.write("            }\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t#homeA:hover {\r\n");
      out.write("                text-decoration: underline;\r\n");
      out.write("            }\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t#productFormat {\r\n");
      out.write("\t\t\t\twidth: 86%;\r\n");
      out.write("\t\t\t\tfloat: left;\r\n");
      out.write("                position: relative;\r\n");
      out.write("                left: 115px;\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t.productContainer {\r\n");
      out.write("\t\t\t\tposition: relative;\r\n");
      out.write("\t\t\t\twidth: 350px;\r\n");
      out.write("\t\t\t\theight: 550px;\r\n");
      out.write("\t\t\t\tmargin-right: 30px;\r\n");
      out.write("\t\t\t\tdisplay: inline-block;\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t.img {\r\n");
      out.write("\t\t\t\twidth: 350px;\r\n");
      out.write("\t\t\t\theight: 550px;\r\n");
      out.write("\t\t\t\tmargin-right: 25px;\r\n");
      out.write("\t\t\t\tmargin-bottom: 5px;\r\n");
      out.write("\t\t\t\tposition: relative;\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t.productDesc {\r\n");
      out.write("\t\t\t\tposition: absolute;\r\n");
      out.write("\t\t\t\twidth: 350px;\r\n");
      out.write("\t\t\t\theight: 550px;\r\n");
      out.write("\t\t\t\tmargin: 0 auto;\r\n");
      out.write("\t\t\t\tbackground-color: rgba(35, 35, 35, 0.75);\r\n");
      out.write("\t\t\t\ttop: 0px;\r\n");
      out.write("\t\t\t\ttext-align: center;\r\n");
      out.write("\t\t\t\tvisibility: hidden;\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t.productContainer:hover .productDesc {\r\n");
      out.write("\t\t\t\tvisibility: visible;\r\n");
      out.write("\t\t\t\tbackground-color: rgba(35, 35, 35, 0.75);\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t.productContainer:hover .productName {\r\n");
      out.write("\t\t\t\tvisibility: visible;\r\n");
      out.write("\t\t\t \topacity: 1;\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t.productContainer:hover .price {\r\n");
      out.write("\t\t\t\tvisibility: visible;\r\n");
      out.write("\t\t\t \topacity: 1;\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t.productName {\r\n");
      out.write("\t\t\t\tposition: relative;\r\n");
      out.write("\t\t\t\tfont-size: 16px;\r\n");
      out.write("\t\t\t\tcolor: #fff;\r\n");
      out.write("\t\t\t\tfont-family: Montserrat, Sans-serif;\r\n");
      out.write("                letter-spacing: 1px;\r\n");
      out.write("\t\t\t\ttext-align: center;\r\n");
      out.write("\t\t\t\ttop: 225px;\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t.price {\r\n");
      out.write("\t\t\t\tposition: relative;\r\n");
      out.write("\t\t\t\tcolor: #fff;\r\n");
      out.write("\t\t\t\tfont-family: Montserrat, Sans-serif;\r\n");
      out.write("                font-size: 16px;\r\n");
      out.write("                font-weight: bold;\r\n");
      out.write("                text-transform: uppercase;\r\n");
      out.write("\t\t\t\ttext-align: center;\r\n");
      out.write("\t\t\t\tletter-spacing: 1px;\r\n");
      out.write("\t\t\t\ttop:225px;\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t#funImage {\r\n");
      out.write("\t\t\t\tposition: fixed;\r\n");
      out.write("\t\t\t\twidth: 150px;\r\n");
      out.write("\t\t\t\theight: 150px;\r\n");
      out.write("\t\t\t\tleft: 0px;\r\n");
      out.write("\t\t\t\ttop: 0px;\r\n");
      out.write("\t\t\t}\r\n");
      out.write("            \r\n");
      out.write("\t\t\t#funImage2 {\r\n");
      out.write("\t\t\t\tposition: fixed;\r\n");
      out.write("\t\t\t\twidth: 150px;\r\n");
      out.write("\t\t\t\theight: 150px;\r\n");
      out.write("\t\t\t\tright: 0px;\r\n");
      out.write("\t\t\t\ttop: 0px;\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t</style>\r\n");
      out.write("\t</head>\r\n");
      out.write("\t<body>\r\n");
      out.write("\t<img src = \"images/a4068434880_5(flipped).png\" id = \"funImage\"></img>\r\n");
      out.write("\t<img src = \"images/a4068434880_5.png\" id = \"funImage2\"></img>\r\n");
      out.write("\t<div id = \"container\">\r\n");
      out.write("        <div id = \"header\">\r\n");
      out.write("            <a href = \"#\"><p id = \"titleCaption\">SHOP ALL PRODUCTS</p></a>\r\n");
      out.write("            <input type = \"text\" placeholder = \"Search our store\" id = \"search\" name = \"searchBar\" />\r\n");
      out.write("            <p id = \"myCart\"><a href = \"cart.jsp\">My Cart (1)</a></p>\r\n");
      out.write("            <p id = \"join\"><a href = \"sign.jsp\">Join</a></p>\r\n");
      out.write("           \t<p id = \"sign-in\"><a href = \"sign.jsp\">Sign In</a></p>\r\n");
      out.write("\t\t\t<p id = \"sign-out\"><a href = \"logout\">Sign Out</a></p>\r\n");
      out.write("\t\t\t<p id = \"account\"><a href = \"sign.jsp\">Account</a></p>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<div id = \"nav\">\r\n");
      out.write("            <p id = \"subCaption\"><a href = \"#\" id = \"homeA\">Home</a> <span class=\"separator\">»</span> Collections</p>\r\n");
      out.write("        </div>\r\n");
      out.write("\t\t<article id = \"productFormat\">\r\n");
      out.write("\t\t\t\r\n");
      out.write("        </article>\r\n");
      out.write("\t</div>\r\n");
      out.write("\t</body>\r\n");
      out.write("\t\r\n");
      out.write("</html>");
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
}
