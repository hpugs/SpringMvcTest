package com.hpugs.spring.mvc.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

@Controller
public class FileController {

	/**
	 * 通过流的方式进行文件保存
	 * @param file
	 * @return
	 * @throws IOException
	 */
	@RequestMapping("/updateFileOnStream")
	public String updateFileOnStream(@RequestParam("file") MultipartFile file) throws IOException{
		InputStream inputStream = file.getInputStream();
		File newFile = new File("F:/fileTest/"+file.getOriginalFilename());
		if(!newFile.exists()){
			newFile.createNewFile();
		}
		FileOutputStream fileOutputStream = new FileOutputStream(newFile);
		int n = 0;
		while ((n = inputStream.read()) != -1) {
			fileOutputStream.write(n);
		}
		fileOutputStream.flush();
		fileOutputStream.close();
		inputStream.close();
		return "success";
	}
	
	/**
	 * 使用Spring mvc保存单文件
	 * @param file
	 * @return
	 * @throws IOException
	 */
	@RequestMapping("/updateFileOnTransto")
	public String updateFileOnTransto(@RequestParam("file") MultipartFile file) throws IOException{
		File newFile = new File("F:/fileTest/"+file.getOriginalFilename());
		if(!newFile.exists()){
			newFile.createNewFile();
		}
		file.transferTo(newFile);
		return "success";
	}
	
	/**
	 * 使用Spring mvc保存多文件
	 * @param files
	 * @return
	 * @throws IOException
	 */
	@RequestMapping("/updateFilesOnTransto")
	public String updateFilesOnTransto(@RequestParam("files") MultipartFile[] files) throws IOException{
		for (MultipartFile multipartFile : files) {
			File newFile = new File("F:/fileTest/"+multipartFile.getOriginalFilename());
			if(!newFile.exists()){
				newFile.createNewFile();
			}
			multipartFile.transferTo(newFile);
		}
		return "success";
	}
	
	/**
	 * 通过request方式获取文件，使用spring mvc的方式保存
	 * @param request
	 * @return
	 * @throws IOException
	 */
	@RequestMapping("/updateFile")
	public String updateFile(HttpServletRequest request) throws IOException{
		//将当前上下文初始化给  CommonsMutipartResolver （多部分解析器）
        CommonsMultipartResolver multipartResolver=new CommonsMultipartResolver(
                request.getSession().getServletContext());
        //检查form中是否有enctype="multipart/form-data"
        if(multipartResolver.isMultipart(request))
        {
            //将request变成多部分request
            MultipartHttpServletRequest multiRequest=(MultipartHttpServletRequest)request;
            //获取multiRequest 中所有的文件名
            Iterator iter=multiRequest.getFileNames();
            while(iter.hasNext())
            {
                //一次遍历所有文件
                MultipartFile file=multiRequest.getFile(iter.next().toString());
                if(file!=null)
                {
                    String path="F:/fileTest/"+file.getOriginalFilename();
                    //上传
                    file.transferTo(new File(path));
                }
            }
        }
		return "success";
	}
	
}
