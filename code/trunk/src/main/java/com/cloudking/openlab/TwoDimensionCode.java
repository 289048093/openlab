package com.cloudking.openlab;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cloudking.openlab.util.TwoDimensionCodeUtil;

public class TwoDimensionCode extends HttpServlet {

    /**
     * The doPost method of the servlet. <br>
     * 
     * This method is called when a form has its tag value method equals to post.
     * 
     * @param request
     *            the request send by the client to the server
     * @param response
     *            the response send by the server to the client
     * @throws ServletException
     *             if an error occurred
     * @throws IOException
     *             if an error occurred
     */
    public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("image/png");
        String code = request.getParameter("code");
        if (code == null) {
            code = " ";
        }
        TwoDimensionCodeUtil.newInstance().encoderQRCode(code, response.getOutputStream());
//        ByteArrayInputStream baIs = TwoDimensionCodeUtil.newInstance();
//        byte[] bytes = new byte[1024];
//        int len = 0;
//        while ((len = baIs.read(bytes)) != -1) {
//            response.getOutputStream().write(bytes, 0, len);
//        }
//        baIs.close();
    }

}
