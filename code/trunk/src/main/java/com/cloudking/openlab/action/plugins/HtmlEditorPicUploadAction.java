/**
 * Copyright(c) 2013 ShenZhen CloudKing Technology Co., Ltd.
 * All rights reserved.
 * Created on  Nov 6, 2013  3:13:23 PM
 */
package com.cloudking.openlab.action.plugins;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import org.apache.commons.io.IOUtils;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.cloudking.openlab.BaseAction;
import com.cloudking.openlab.PropertyManager;
import com.cloudking.openlab.vo.FileVo;

/**
 * @author CloudKing
 */
@Controller
@Scope("prototype")
@ParentPackage("openlab-default")
@Namespace("/htmlEditorPicUploadManager")
@Results( { @Result(name = "success", type = "dispatcher", location = "/index.jsp"),
                @Result(name = "jump", type = "dispatcher", location = "/jump.jsp") })
public class HtmlEditorPicUploadAction extends BaseAction<FileVo> {

    /**
     * 
     */
    private static final long serialVersionUID = -1933148880945809626L;

    @Action("/htmlEditorPicUpload")
    public String execute() throws Exception {
        return INPUT;
    }

    public String showPic() {
        String url = PropertyManager.getInstance().getXMLProperty(PropertyManager.XML_OPENLAB_COREMANAGER_HOST)
                        + "/htmlEditorPicUploadManager/htmlEditorPicUpload!showPic.action?cloudContext.params.picName="
                        + cloudContext.getStringParam("picName");
        try {
            URLConnection conn = new URL(url).openConnection();
            IOUtils.copy(conn.getInputStream(), getResponse().getOutputStream());
        } catch (MalformedURLException e) {
        } catch (IOException e) {
        }
        return NONE;
    }
}
