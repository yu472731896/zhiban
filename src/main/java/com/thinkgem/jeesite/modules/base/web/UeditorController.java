package com.thinkgem.jeesite.modules.base.web;

import java.io.File;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.thinkgem.jeesite.common.utils.DateUtils;
import com.thinkgem.jeesite.common.utils.FileUtils;


@Controller
public class UeditorController {

	 protected final Logger logger = LoggerFactory.getLogger(getClass());  
	
	 	@RequestMapping(value = { "/ueditor/config" }, method = { RequestMethod.POST, RequestMethod.GET })  
	    @ResponseBody  
	    public Object ueditorConfig(@RequestParam(value = "action", required = false) String action, HttpServletRequest request, HttpServletRequest response)  
	            throws Exception {  
	        logger.info("百度编辑器action=[{}]", action);  
	        if ("config".equals(action)) {  
	            UeditorConfigBean ucb = new UeditorConfigBean();  
	            return ucb;  
	        } else if ("/ueditor/uploadImg".equals(action)) {// 图片上传  
	            return uploadImg(((MultipartHttpServletRequest) request)  
	                    .getFile("upfile"));  
	        }  
	        return action;  
	    }  
	 
	 /** 
	     * 图片上传 
	     *  
	     * @return 
	     * @throws Exception 
	     */  
	    public Object uploadImg(MultipartFile upfile) throws Exception {  
	  
	        String orgName = upfile.getOriginalFilename(), houzui = orgName .substring(orgName.lastIndexOf("."), orgName.length()), fileName = DateUtils.formatDate(new Date(), "yyyyMMddHHmmss"), contentType = upfile  
	                .getContentType(), imgName = fileName + houzui;  
	        
	       /* String imgPath = CommonDef.FS_ROOT + "annex/baidueditor/" + imgName;*/  
	        String imgPath =  "annex/baidueditor/" + imgName;
	        logger.info("百度编辑器上传图片orgName=[{}],contentType=[{}],imgPath=[{}]",  
	                orgName, contentType, imgPath);  
	        FileUtils.writeByteArrayToFile(new File(imgPath), upfile.getBytes());  
	        String imgUrl = "ueditor/readImg/" + fileName + "/"  
	                + houzui.replace(".", "");  
	        logger.info("imgUrl=[{}]", imgUrl);  
	        return "{'url':'" + imgUrl + "','state':'SUCCESS'}";  
	    }  
	    
	    
	    
	    class UeditorConfigBean {  
	    	  
	        /** 
	         * <pre> 
	         * 通过在 php/config.json 文件，配置 imageUrlPrefix 可以给返回的路径添加指定的前缀。 
	         *  
	         * 编辑器和图片地址同域的情况下，可以直接使用后台返回的路径，不需要额外配置前缀 假如编辑器和图片不在一个域名下，需要给返回路径添加域名前缀，可以设置 
	         * imageUrlPrefix 配置项为 "http://img.domain"，这时插入编辑器的图片会是这样： 
	         *  
	         * "http://img.domain/ueditor/php/upload/2014/06/06/123.jpg"  
	         * [默认值：""]图片访问路径前缀 
	         * </pre> 
	         */  
	     /*   private String imageUrlPrefix = CommonDef.WEBSITE_URL;  */
	      
	        /** 
	         * <pre> 
	         *  [默认值："uploadimage"] //执行上传图片的action名称, 
	         * </pre> 
	         */  
	        private String imageActionName = "/ueditor/uploadImg";  
	       /* private String fileUrlPrefix = CommonDef.WEBSITE_URL;  
	        private String videoUrlPrefix = CommonDef.WEBSITE_URL;  */
	        @Deprecated  
	        private String imagePathFormat = "/ueditor/image/{yyyy}{mm}{dd}/{time}{rand:6}";  
	        @Deprecated  
	        private String filePathFormat = "/ueditor/file/{yyyy}{mm}{dd}/{time}{rand:6}";  
	        @Deprecated  
	        private String videoPathFormat = "/ueditor/video/{yyyy}{mm}{dd}/{time}{rand:6}";  
	        /** 
	         * imageFieldName {String} [默认值："upfile"] //提交的图片表单名称 
	         */  
	        private String imageFieldName = "upfile";  
	        private String[] imageAllowFiles = { ".png", ".jpg", ".jpeg", ".gif",  
	                ".bmp" };  
	        private String[] fileAllowFiles = { ".doc", ".docx", ".txt", ".pdf",  
	                ".xlsx", ".xls", ".png", ".jpg", ".jpeg", ".gif", ".bmp" };  
	      
	    /*    public String getImageUrlPrefix() {  
	            return imageUrlPrefix;  
	        }  
	      
	        public void setImageUrlPrefix(String imageUrlPrefix) {  
	            this.imageUrlPrefix = imageUrlPrefix;  
	        }  */
	      
	        public String getImageActionName() {  
	            return imageActionName;  
	        }  
	      
	        public void setImageActionName(String imageActionName) {  
	            this.imageActionName = imageActionName;  
	        }  
	      
	        public String getImagePathFormat() {  
	            return imagePathFormat;  
	        }  
	      
	        public void setImagePathFormat(String imagePathFormat) {  
	            this.imagePathFormat = imagePathFormat;  
	        }  
	      
	        public String getFilePathFormat() {  
	            return filePathFormat;  
	        }  
	      
	        public void setFilePathFormat(String filePathFormat) {  
	            this.filePathFormat = filePathFormat;  
	        }  
	      
	      /*  public String getFileUrlPrefix() {  
	            return fileUrlPrefix;  
	        }  
	      
	        public void setFileUrlPrefix(String fileUrlPrefix) {  
	            this.fileUrlPrefix = fileUrlPrefix;  
	        }  */
	      
	        public String getVideoPathFormat() {  
	            return videoPathFormat;  
	        }  
	      
	        public void setVideoPathFormat(String videoPathFormat) {  
	            this.videoPathFormat = videoPathFormat;  
	        }  
	      
	       /* public String getVideoUrlPrefix() {  
	            return videoUrlPrefix;  
	        }  
	      
	        public void setVideoUrlPrefix(String videoUrlPrefix) {  
	            this.videoUrlPrefix = videoUrlPrefix;  
	        }  */
	      
	        public String[] getImageAllowFiles() {  
	            return imageAllowFiles;  
	        }  
	      
	        public void setImageAllowFiles(String[] imageAllowFiles) {  
	            this.imageAllowFiles = imageAllowFiles;  
	        }  
	      
	        public String[] getFileAllowFiles() {  
	            return fileAllowFiles;  
	        }  
	      
	        public void setFileAllowFiles(String[] fileAllowFiles) {  
	            this.fileAllowFiles = fileAllowFiles;  
	        }  
	      
	        public String getImageFieldName() {  
	            return imageFieldName;  
	        }  
	      
	        public void setImageFieldName(String imageFieldName) {  
	            this.imageFieldName = imageFieldName;  
	        }  
	        
	    } 
}
