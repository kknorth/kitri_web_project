<%@ page language="java" contentType="text/html; charset=EUC-KR"

   pageEncoding="EUC-KR"%>

<!DOCTYPE html>

<html>

<head>

<title>Insert title here</title>

<script

   src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

<script

   src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

<link rel="stylesheet"

   href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

<link href="//cdnjs.cloudflare.com/ajax/libs/foundation/5.3.3/css/foundation.min.css" rel="stylesheet" />



<style type="text/css">

#audio_fan_02.row.paddong {

   padding-top: 1px;

}



#dropzone {

   position: relative;

   border: 10px dotted #ff7088;

   border-radius: 20px;

   color: #ff7088;

   font: bold 24px/200px arial;

   height: 300px;

   margin: 30px auto;

   text-align: center;

   width: 300px;

}



#dropzone.hover {

   border: 10px solid #ffd0d1;

   color: #ffd0d1;

}



#dropzone.dropped {

   background: #ffd0d1;

   border: 10px solid #ff7088;

}



#dropzone div {

   position: absolute;

   top: 0;

   right: 0;

   bottom: 0;

   left: 0;

}



#dropzone img {

   border-radius: 10px;

   vertical-align: middle;

   max-width: 95%;

   max-height: 95%;

}



#dropzone [type="file"] {

   cursor: pointer;

   position: absolute;

   opacity: 0;

   top: 0;

   right: 0;

   bottom: 0;

   left: 0;

}



.real_audio_file {

   position: relative;

   left: 25%;

   background: #ffeeee;

   width: 500px;

   height: 200px;

   border: 4px dashed #ff7088;

}



.real_audio_file p {

   width: 100%;

   height: 100%;

   text-align: center;

   line-height: 170px;

   color: #ff7088;

   font-family: Arial;

}



.real_audio_file input {

   position: absolute;

   margin: 0;

   padding: 0;

   width: 100%;

   height: 100%;

   outline: none;

   opacity: 0;

   padding: 0;

}

</style>

</head>



<body>



   <form id="audioUploadForm" name="audioUploadForm" method="post"

      enctype="multipart/form-data" action="/FairMusic/audio.do">

      <div role="tabpanel">

         <ul class="nav nav-tabs" role="tablist">

            <li role="presentation" class="active"><a href="#audio_fan_01"

               data-toggle="tab" role="tab" aria-controls="tab1">음원 기본정보</a></li>

            <li role="presentation"><a href="#audio_fan_02"

               data-toggle="tab" role="tab" aria-controls="tab2">수익 분배 설정</a></li>

            <li role="presentation"><a href="#audio_fan_03"

               data-toggle="tab" role="tab" aria-controls="tab3">음원파일 업로드</a></li>

            <li role="presentation"><a href="#audio_fan_04"

               data-toggle="tab" role="tab" aria-controls="tab4">+뮤직비디오</a></li>



         </ul>

         <div id="tabContent1" class="tab-content">

            <div role="tabpanel" class="tab-pane fade in active"

               id="audio_fan_01">

               <div class="row">

                  <div class="col-xs-4">

                     <div id="dropzone">

                        <div>dropzone</div>

                        <input type="file" accept="image/png, application/pdf" id = "image_file" name ="image_file"/>

                     </div>

                  </div>

                  <div class="col-xs-8">

                     <div class="row">

                        <div class="col-xs-2">

                           <span class="label label-info">음원 명</span>

                        </div>

                        <div class="col-xs-10">

                           <input type="text" name="audio_title" id="audio_title"

                              required="required">

                        </div>

                        <div class="col-xs-2">

                           <span class="label label-info">장르</span>

                        </div>

                        <div class="col-xs-10">

                           <select name="audio_genre" id="audio_genre">

                           </select> &nbsp;

                        </div>

                        <div class="col-xs-2">

                           <span class="label label-info">앨범</span>

                        </div>

                        <div class="col-xs-10">

                           <select name="audio_album" id="audio_album">

                           </select> &nbsp;

                        </div>

                        <div class="col-xs-2">

                           <span class="label label-info">소개</span>

                        </div>

                        <div class="col-xs-10">

                           <textarea name="audio_detail" id="audio_detail"></textarea>



                        </div>

                     </div>

                  </div>

               </div>

               

            </div>

            <div role="tabpanel" class="tab-pane fade" id="audio_fan_02">

               <div class="row">

                  <div class="col-sm-12">

                     <select class="form-control" id="ccl_check">

                        <option>무료</option>

                        <option>기부-조성원에게-</option>

                        <option>상업적 이용 금지</option>

                        <option>유료</option>

                     </select>

                     <div id = "audio_price" hidden = "true">

                        <input type = "number"  value = "0">

                     </div>

                  </div>

               </div>

               <div class="row">

                  <div class="col-sm-1"></div>



                  <div class="col-sm-10">

                     <div id="copy_money" hidden = "true">

                        <div class="row">

                           <div class="col-sm-6">

                              <span class="label label-primary">저작권자 명</span>

                           </div>

                           <div class="col-sm-3">

                              <span class="label label-primary">수익 비율</span>

                           </div>

                           <div class="col-sm-3">

                              <span class="label label-primary">계좌 등록</span>

                           </div>

                        </div>

                        <div class="row" class="cp1">

                           <div class="col-sm-6">

                              <input type="text" name="cp1name" id="cp1name">

                           </div>

                           <div class="col-sm-3">

                              <input type="text" name="cp1rate" id="cp1rate">

                           </div>

                           <div class="col-sm-3">

                              <button type="button" class="btn btn-info">등록</button>

                           </div>

                        </div>

                        <div class="row" class="cp2">

                           <div class="col-sm-6">

                              <input type="text" name="cp2name" id="cp2name">

                           </div>

                           <div class="col-sm-3">

                              <input type="text" name="cp2rate" id="cp2rate">

                           </div>

                           <div class="col-sm-3">

                              <button type="button" class="btn btn-info">등록</button>

                           </div>

                        </div>

                        <div class="row" class="cp3">

                           <div class="col-sm-6">

                              <input type="text" name="cp3name" id="cp3name">

                           </div>

                           <div class="col-sm-3">

                              <input type="text" name="cp3rate" id="cp3rate">

                           </div>

                           <div class="col-sm-3">

                              <button type="button" class="btn btn-info">등록</button>

                           </div>

                        </div>

                        <div class="row" class="cp4">

                           <div class="col-sm-6">

                              <input type="text" name="cp4name" id="cp4name">

                           </div>

                           <div class="col-sm-3">

                              <input type="text" name="cp4rate" id="cp4rate">

                           </div>

                           <div class="col-sm-3">

                              <button type="button" class="btn btn-info">등록</button>

                           </div>

                        </div>

                        <div class="row" class="cp5">

                           <div class="col-sm-6">

                              <input type="text" name="cp5name" id="cp5name">

                           </div>

                           <div class="col-sm-3">

                              <input type="text" name="cp5rate" id="cp5rate">

                           </div>

                           <div class="col-sm-3">

                              <button type="button" class="btn btn-info">등록</button>

                           </div>

                        </div>

                        <div class="row" class="cp6">

                           <div class="col-sm-6">

                              <input type="text" name="cp6name" id="cp6name">

                           </div>

                           <div class="col-sm-3">

                              <input type="text" name="cp6rate" id="cp6rate">

                           </div>

                           <div class="col-sm-3">

                              <button type="button" class="btn btn-info">등록</button>

                           </div>

                        </div>

                        <div class="row" class="cp7">

                           <div class="col-sm-6">

                              <input type="text" name="cp7name" id="cp7name">

                           </div>

                           <div class="col-sm-3">

                              <input type="text" name="cp7rate" id="cp7rate">

                           </div>

                           <div class="col-sm-3">

                              <button type="button" class="btn btn-info">등록</button>

                           </div>

                        </div>

                     </div>

                     <div id="ccl_info" hidden = "true">

                        <div class="row">

                           <div class="col-sm-6">

                              <span class="label label-primary">조심하세용~~~</span>

                           </div>

                        </div>

                     </div>

                  </div>





                  <div class="col-sm-1"></div>

               </div>

            </div>



            <div role="tabpanel" class="tab-pane fade" id="audio_fan_03">

               <div class="row">



                  <div class="col-xs-12">

                     <fieldset>

                        <legend>Audio File</legend>

                        <div class="real_audio_file" id="real_audio_div" name = "real_audio_div">

                           <input type="file" id = "audio_file">

                           <p>

                              Drag your <b>Audio</b> here! or click in this area.

                           </p>

                        </div>

                     </fieldset>

                  </div>

               </div>

               <div class="row">

                  <div class="col-xs-12">

                     <fieldset>

                        <legend>설명</legend>

                        당신의 음원파일을 업로드하십시오.

                     </fieldset>

                  </div>

               </div>

            </div>

            <div role="tabpanel" class="tab-pane fade" id="audio_fan_04">

               <div class="row">

                  <div class="col-xs-12">

                     <fieldset>



                              <h1>Load An mp4 file</h1>

                              <input type="file" id="the-video-file-field" name = "the-video-file-field">

                                    <div id="data-vid" class="large-8 columns">

                                    <!--video will be inserted here.-->

                                    </div>

                                   <h2 id="name-vid"></h2>

                                     <p id="size-vid"></p>

                                     <p id="type-vid"></p>



                     </fieldset>

                  </div>

               </div>



            </div>

         </div>

         <div></div>

      </div>

   </form>





</body>

</html>