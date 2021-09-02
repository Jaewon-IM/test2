// id 중복확인
			function idCheck(){
				var id = $("input:text").val();
				//console.log("memberId: " + memberId);
				
				if(id.length < 4 || id.length > 12) {
					alert("ID는 4~12자리로 입력해주세요.");
					return;
				}
				
				// id 정보 ajax
				$.ajax({
					url: "/member/idCheck"
					,type : "post"
					,data : { id : id }
					,success : successFunc
					,error : function(e){ console.log(e); }
				});
			}
			
			// 성공적으로 데이터 전송시 발생 함수
			function successFunc(data){
				if(data == "yes"){
					alert("사용할 수 있는 ID입니다.");
					$("#useBtn").show();
					$("#resetBtn").show();
					$("input:text").prop("disabled", "disabled");
				} else{
					alert("중복된 ID입니다.");
				}
			}
			
			// id 사용하기 함수
			function useId(){
				// 회원가입 창의 id입력 텍스트에 중복검사 창에서 검사 완료된 값을 넣어준다.
				window.opener.document.getElementById("id").value = $("input:text").val();
				window.close();
			}
			
			// 다른 id 사용하기 함수(리셋)
			function resetId(){
				$("#useBtn").hide();
				$("#resetBtn").hide();
				$("input:text").prop("disabled", "");
				$("input:text").val("");
			}