/**
 * 
 */	 
    function sample6_execDaumPostcode() {
        new daum.Postcode({
            oncomplete: function(data) {
                // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

                // 각 주소의 노출 규칙에 따라 주소를 조합한다.
                // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
                var addr = ''; // 주소 변수
                var extraAddr = ''; // 참고항목 변수

                //사용자가 선택한 주소 타입에 따라 해당 주소 값을 가져온다.
                if (data.userSelectedType === 'R') { // 사용자가 도로명 주소를 선택했을 경우
                    addr = data.roadAddress;
                } else { // 사용자가 지번 주소를 선택했을 경우(J)
                    addr = data.jibunAddress;
                }

                // 사용자가 선택한 주소가 도로명 타입일때 참고항목을 조합한다.
                if(data.userSelectedType === 'R'){
                    // 법정동명이 있을 경우 추가한다. (법정리는 제외)
                    // 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
                    if(data.bname !== '' && /[동|로|가]$/g.test(data.bname)){
                        extraAddr += data.bname;
                    }
                    // 건물명이 있고, 공동주택일 경우 추가한다.
                    if(data.buildingName !== '' && data.apartment === 'Y'){
                        extraAddr += (extraAddr !== '' ? ', ' + data.buildingName : data.buildingName);
                    }
                    // 표시할 참고항목이 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
                    if(extraAddr !== ''){
                        extraAddr = ' (' + extraAddr + ')';
                    }
                    // 조합된 참고항목을 해당 필드에 넣는다.
                    document.getElementById("sample6_extraAddress").value = extraAddr;
                
                } else {
                    document.getElementById("sample6_extraAddress").value = '';
                }

                // 우편번호와 주소 정보를 해당 필드에 넣는다.
                document.getElementById('sample6_postcode').value = data.zonecode;
                document.getElementById("sample6_address").value = addr;
                // 커서를 상세주소 필드로 이동한다.
                document.getElementById("sample6_detailAddress").focus();
            }
        }).open();
    }


/**
* onclick
*/


    
    window.onload = function(){

	inset.id.focus();

	document.getElementById("btnId").onclick = checkid;

	document.getElementById("btnZip").onclick = checkzip;

	document.getElementById("btnSubmit").onclick = inputCheck;

}

 

//null point error



/**
*id 찾기
*/


	function idCheck(form){
		//아이디 입력확인
		if(form.id.value==""){
			alert("아이디 입력 후 중복확인 버튼을 눌러주세요");
			form.id.focus();
			return;
		}
		
			url = "idCheck.jsp?id=" + inset.id.value;

			// 두 번째 파라미터는 메소드 전송방식이 아니고 타이틀

			window.open(url, "id check", "toolbar=no, width=350, height=150, top=150, left=150");
		
		}
	

/**
 * pass 정규식 확인
 */	
 
 
 function check_pw(){
 
            var pw = document.getElementById('pass').value;
            var pw2 = document.getElementById('pass2').value;
            var SC = ["!","@","#","$","%","*"];
            var check_SC = 0;
 
            if(pw.length < 6 || pw.length>16){
                window.alert('비밀번호는 6글자 이상, 16글자 이하만 이용 가능합니다.');
                document.getElementById('pass').value='';
            }
            for(var i=0;i<SC.length;i++){
                if(pw.indexOf(SC[i]) != -1){
                    check_SC = 1;
                }
            }
            if(check_SC == 0){
                window.alert('!,@,#,$,%,* 의 특수문자가 들어가 있지 않습니다.');
                document.getElementById('pass').value='';
            }
            if(pw !='' && pw2 !=''){
                if(pw == pw2){
                    
                	document.getElementById('check').innerHTML='비밀번호가 일치합니다.';
                	
                }else{
                 	
					document.getElementById('check').innerHTML='비밀번호가 일치하지 않습니다.';
                    
                }
            }
  	}
 