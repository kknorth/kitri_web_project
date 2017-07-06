package com.fairmusic.audio.controller;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;


import com.fairmusic.seong.fm_Code;




public class audioServlet extends HttpServlet {

   private File dirPath(String type){
      ServletContext context = this.getServletContext();
      String realPath = context.getRealPath("/");
      String dirName = realPath+ "FM_"+type+"Files";
      File dir = new File(dirName);
      if(!dir.exists()){
         dir.mkdir();
      }
      return dir;
   }
   private void SeongfileUpload(HttpServletRequest request, String randomvalue){
      File settingdir = dirPath("factoryset");
      File imagedir = dirPath("audio_image");
      File filedir = dirPath("audio_file");
      File videodir = dirPath("audio_video");
      
      DiskFileItemFactory factory = new DiskFileItemFactory();
      factory.setSizeThreshold(10*1024);
      factory.setRepository(settingdir);
      ServletFileUpload upload = new ServletFileUpload(factory);
      upload.setSizeMax(100*1024*1024);
      upload.setHeaderEncoding("EUC-KR");
      try{
      List items = upload.parseRequest(request);
      System.out.println(items.size()+"개수");
         for(int i =0 ; i <items.size(); i++){
            FileItem item = (FileItem)items.get(i);
               if(item.getFieldName().equals("image_file")){
                  String[] ex = item.getName().split(".");
                  File imagefile = new File(imagedir, randomvalue+"."+ex[1]);
                  item.write(imagefile);
                  
                  System.out.println("audio_image_file saved in "+imagedir.getPath()+randomvalue+"."+ex[1]);
                  
               }else if(item.getFieldName().equals("audio_file")){
                  String[] ex = item.getName().split(".");
                  File audiofile = new File(filedir, randomvalue);
                  item.write(audiofile);
                  
                  System.out.println("audio_file saved in "+filedir.getPath()+randomvalue+"."+ex[1]);
                  
               }else if(item.getFieldName().equals("the-video-file-field")){
                  String[] ex = item.getName().split(".");
                  File vediofile = new File(videodir, randomvalue);
                  item.write(vediofile);
                  System.out.println("audio_video_file saved in "+videodir.getPath()+randomvalue+"."+ex[1]);
               }
         }
      }catch(Exception _ex){
         System.out.println("에러 : "+_ex.getLocalizedMessage());
      }
   }
   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      
      request.setCharacterEncoding("utf-8");
      response.setHeader("cache-control", "no-cache,no-store");
      response.setContentType("text/html;charset=utf-8");
      
      fm_Code code = new fm_Code();
      
      String audio_code = code.uniqueCode(20);
      System.out.println("오디오 코드"+audio_code);
      SeongfileUpload(request,audio_code);
   
      
      /*audioDTO audio = new audioDTO(audio_code, request.getParameter(""), artist_code, audio_jenre, audio_image, audio_detail, album_code, string, audio_link, audio_price, audio_copyrighter)
      */
      PrintWriter pw=response.getWriter();
      
      pw.write("");
      
    }
   
   
}