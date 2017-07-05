package com.fairmusic.audio.controller;
import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;




public class audioServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServletContext context = this.getServletContext();
		String realPath = context.getRealPath("/");
		String dirName = realPath+ "uploadFiles";
		File dir = new File(dirName);
		if(!dir.exists()){
			dir.mkdir();
		}
		
		System.out.println("dirName : "+ dirName);
		
		DiskFileItemFactory factory = new DiskFileItemFactory();
		factory.setSizeThreshold(10*1024);
		factory.setRepository(dir);
		ServletFileUpload upload = new ServletFileUpload(factory);
		upload.setSizeMax(10*1024*1024);
		upload.setHeaderEncoding("EUC-KR");
		try{
		List items = upload.parseRequest(request);
		
			for(int i =0 ; i <items.size(); i++){
				FileItem item = (FileItem)items.get(i);
					if(item.getFieldName().equals("image_file")){
						File file = new File(dir, item.getName());
						item.write(file);
						System.out.println("file saved in "+dir.getPath());
						
					}
			}
		}catch(Exception _ex){
			System.out.println("¿¡·¯ : "+_ex.getLocalizedMessage());
		}
    }
}
