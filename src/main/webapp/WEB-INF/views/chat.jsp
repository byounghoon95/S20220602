<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="header.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="css/chat.css" rel="stylesheet" />
<title>Insert title here</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script type="text/javascript">
var ws;

function wsOpen(){
	console.log("wsOpen  location.host: " + location.host);
    var wsUri  = "ws://" + location.host + "${pageContext.request.contextPath}/chating";
    // WebSocket 프로토콜을 사용하여 통신하기 위해서는 WebSocket객체를 생성. 
    // 객체는 자동으로 서버로의 연결
	ws = new WebSocket(wsUri);
	wsEvt();
}
function wsEvt() {
	console.log("wsEvt  start... ");
	
	//소켓이 열리면 동작
	ws.onopen = function(data){
		console.log("wsEvt  소켓이 열리면 초기화 세팅하기..");
		}
	
	//메시지를 받으면 동작
	ws.onmessage = function(data) {
		
		var msg = data.data;
		var memberSave = false;
		alert("ws.onmessage->"+msg)
		if(msg != null && msg.trim() != ''){
			memberSave = false;
			// JSON 오브젝트를 자바스크립트 오브젝트로 변환
		    var jsonMsg = JSON.parse(msg);
			// msg가 배열이고, 2개이상의 Count이면 , member 등록 대상 
            if (Array.isArray(jsonMsg)) {
            	if (Object.keys(jsonMsg).length > 1) {
                	memberSave = true;
                   	alert("JSONArray jsonMsg Count->"+ Object.keys(jsonMsg).length);
            	}
            }
			// 파싱한 객체의 type값을 확인하여 getId값이면 초기 설정된 값이므로 채팅창에 값을 입력하는게 아니라
			// 추가한 태그 sessionId에 값을 세팅
			if(jsonMsg.type == "getId"){
				var sid = jsonMsg.sessionId != null ? jsonMsg.sessionId : "";
				if(sid != ''){
					$("#sessionId").val(sid); 
					// session User 등록 수행
					sendUser('Create');
				}
			}else if(jsonMsg.type == "message"){
				// type이 message인 경우엔 채팅이 발생한 경우.
                // 상대방과 자신을 구분하기 위해 여기서 sessionId값을 사용
                // 최초 이름을 입력하고 연결되었을때, 발급받은 sessionId값을 비교하여 같다면 자기 자신이 발신한
                // 메시지이므로 오른쪽으로 정렬하는 클래스를 처리하고 메시지를 출력.     
                // 비교하여 같지 않다면 타인이 발신한 메시지이므로 왼쪽으로 정렬하는 클래스를 처리하고 메시지를 출력
				if(jsonMsg.sessionId == $("#sessionId").val()){
					$(".msg_history").append("<div class='outgoing_msg'><div class='sent_msg'><p>" + jsonMsg.msg + "</p><span class='time_date'> 11:01 AM | June 9</span></div></div>");
				}else{
					$(".msg_history").append("<div class='incoming_msg'><div class='incoming_msg_img'>"
							+ "<img src='/images/mem_profile.jpg' alt='sunil' id='photo' /></div><div class='received_msg'>"
							+ "<div class='received_withd_msg'><p>"+ jsonMsg.msg + "</p><span class='time_date'> 11:01 AM | June 9</span></div></div></div>");
				}
			}else if(memberSave == true){

				$('#member_sub').remove();
				//  memberSave = true 면  -->	User 등록/삭제 일경우
				// div로 감싸주면 재정의시 삭제(Refresh)후 다시 생성 
				//var str = " <div id='member_sub' class='member_sub'> ";
				var str = " ";
				str  += " <select name='member' id='member_sub' class='member_sub'> ";
				str  += " <option value='ALL'>전체 </option> "; 
				$(jsonMsg).each(
					function(){
						var str2 = "";
			            // User를 선택하여 message전송 가능토록 member에 등록 
						if(this.sessionId == $("#sessionId").val()){
							alert("내꺼임"+ $("#sessionId").val())
						} else {  // 타인 session일 경우 추가 등록 
							alert('jsonMsg.sessionId -> ' + this.sessionId)
							alert('$("#sessionId").val() -> ' + $("#sessionId").val())
							str2 += " <option value='"+this.sessionId + "'> "+this.userName  + "</option> ";
							str  += str2 ;
						}
					}
				);
				str += " </select>"
				str += " </div><p>"
				$('#member').append(str);	
				memberSave = false;
				
			}else{
					console.warn("unknown type!");
			}
		}
	}

	document.addEventListener("keypress", function(e){
		if(e.keyCode == 13){ //enter press
			send();
		}
	});
}

function chatName(){
	// 김준수
	var userName = $("#userName").val();
	console.log("chatName  userName: " + userName);
	if(userName == null || userName.trim() == ""){
		alert("사용자 이름을 입력해주세요.");
		$("#userName").focus();
	}else{
		wsOpen();
		$("#meName").append('나의이름:'+userName);
		$("#yourName").hide();
		$("#yourNameDel").show();
	}
}

// User 등록  Message 전송       saveStatus --> Create / Delete
function sendUser(saveStatus) {
	
	var userOption ={
			type       : "userSave",
			sessionId  : $("#sessionId").val(),
			userName   : $("#userName").val(),
			saveStatus : saveStatus
		}
	alert("sendUser Start..")
	// 자바스크립트의 값을 JSON 문자열로 변환
	ws.send(JSON.stringify(userOption));
	if(saveStatus == "Delete") {
		alert("sendUser saveStatus-->"+saveStatus);
		//자기자신창을 닫습니다.
		//window.open('','_self').close(); 
		 window.open(location.href, "_self", "");
		 window.close()
	}
	// $('#chatting').val("");
}
// 전체 Message 전송
function send() {
	var option ={
		type: "message",
		sessionId : $("#sessionId").val(),
		userName : $("#userName").val(),
		yourName : $("#member_sub").val(),
		msg : $(".write_msg").val()
	}
	// 자바스크립트의 값을 JSON 문자열로 변환
	ws.send(JSON.stringify(option));
	$('.write_msg').val("");
}
</script>
</head>
<body>
    <div id="blank_5vh"></div>
    <!-- 삭제용 -->
    <input type="hidden" id="sessionId" value="" />
    <div id="member" class="member"></div>
    <div id="meName"></div>
    <div id="yourName">
      <table class="inputTable">
        <tr>
          <th>사용자명</th>
          <th><input type="text" name="userName" id="userName" /></th>
          <th><button onclick="chatName()">이름 등록</button></th>
        </tr>
      </table>
    </div>
    <!-- 삭제용 -->
    <div class="container">
      <div class="messaging">
        <div class="inbox_msg">
          <div class="inbox_people">
            <div class="inbox_chat scroll">
              <li>
                <div class="card_item" style="width: 18rem">
                  <a href="itemDetail">
                    <img
                      src="images/cheese.png"
                      class="card-img-top"
                      alt="..."
                    />
                  </a>
                  <div class="card-body">
                    <div class="card-itemTitle">안녕하세요</div>
                    <p class="card-text"><span>30000원</span><br /></p>

                    <div class="item_boxbottom">
                      <a
                        href="reservationDetail?itemno=${itemList.itemno }"
                        class="btn itembtn"
                        >예약하기</a
                      >
                    </div>
                  </div>
                </div>
              </li>
            </div>
          </div>
          <div class="mesgs">
            <div class="msg_history">
              <div class="incoming_msg">
                <div class="incoming_msg_img">
                  <img src="images/mem_profile.jpg" alt="sunil" id="photo" />
                </div>
                <div class="received_msg">
                  <div class="received_withd_msg">
                    <p>Test which is a new approach to have all solutions</p>
                    <span class="time_date"> 11:01 AM | June 9</span>
                  </div>
                </div>
              </div>
              <div class="outgoing_msg">
                <div class="sent_msg">
                  <p>Test which is a new approach to have all solutions</p>
                  <span class="time_date"> 11:01 AM | June 9</span>
                </div>
              </div>
            </div>
            <div class="type_msg">
              <div class="input_msg_write">
                <input
                  type="text"
                  class="write_msg"
                  placeholder="보내실 메시지를 입력하세요."
                />
                <button class="msg_send_btn" type="button" onclick="send()">
                  <i class="fa fa-paper-plane" aria-hidden="true"></i>
                </button>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
</body>
</html>
