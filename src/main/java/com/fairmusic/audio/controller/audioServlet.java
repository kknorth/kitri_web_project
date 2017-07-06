package com.fairmusic.audio.controller;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
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
                  if(item.getName()!=""){

                     String[] ex = item.getName().split("\\.");
                     String tempname = randomvalue+"."+ex[1];
                     System.out.println(tempname);
                     File imagefile = new File(imagedir,tempname);
                     item.write(imagefile);
                     System.out.println("audio_image_file saved in "+imagedir.getPath()+"\\"+tempname);
                  }
               }else if(item.getFieldName().equals("audio_file")){
                  if(item.getName()!=""){
                  String[] ex = item.getName().split("\\.");
                  String tempname = randomvalue+"."+ex[1];
                  System.out.println(tempname);
                  File audiofile = new File(filedir,tempname);
                  item.write(audiofile);
                  
                  System.out.println("audio_file saved in "+filedir.getPath()+randomvalue+"."+ex[1]);
                  }
               }else if(item.getFieldName().equals("the-video-file-field")){
                  if(item.getName()!=""){
                  String[] ex = item.getName().split("\\.");
                  String tempname = randomvalue+"."+ex[1];
                  System.out.println(tempname);
                  File vediofile = new File(videodir,tempname);
                  item.write(vediofile);
                  System.out.println("audio_video_file saved in "+videodir.getPath()+randomvalue+"."+ex[1]);
                  }
                  }
         }
         
         audioDTOcreate(items);
      }catch(Exception _ex){
         System.out.println("에러 : ");
         _ex.printStackTrace();
      }
   }
   
   private void audioDTOcreate(List items){
      for(int i =0 ; i <items.size(); i++){
           FileItem item = (FileItem)items.get(i);
           try{
              if(item.getFieldName().equals("audio_title")){
                 System.out.println("타이틀"+item.getString("UTF-8"));
              }else if(item.getFieldName().equals("audio_genre")){
                 System.out.println("장르"+item.getString("UTF-8"));
              }else if(item.getFieldName().equals("audio_album")){
                 System.out.println("앨범"+item.getString("UTF-8"));
              }else if(item.getFieldName().equals("audio_detail")){
                 System.out.println("설명"+item.getString("UTF-8"));
              }else if(item.getFieldName().equals("ccl_check")){
                 System.out.println("체크"+item.getString("UTF-8"));
              }else if(item.getFieldName().equals("audio_value")){
                 System.out.println("밸류"+item.getString("UTF-8"));
              }
           }catch(UnsupportedEncodingException e){
              e.printStackTrace();
           }
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