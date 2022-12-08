# 게시판 프로젝트
<h2>1. API 설계</h2>
<img width="504" alt="스크린샷_20221208_080617" src="https://user-images.githubusercontent.com/100077017/206431448-599eecc9-2935-42fc-97b6-0eb3f5eacdcb.png">
<img width="564" alt="스크린샷_20221208_073549" src="https://user-images.githubusercontent.com/100077017/206425249-43013312-071c-499a-be46-9e5cc1362a91.png">
<br>
<h2>2. 구현내용</h2>
1) 회원 가입 API<br>
&nbsp;&nbsp;&nbsp;&nbsp;- username, password를 Client에서 전달받기<br>
&nbsp;&nbsp;&nbsp;&nbsp;- username은  `최소 4자 이상, 10자 이하이며 알파벳 소문자(a~z), 숫자(0~9)`로 구성<br>
&nbsp;&nbsp;&nbsp;&nbsp;- password는  `최소 8자 이상, 15자 이하이며 알파벳 대소문자(a~z, A~Z), 숫자(0~9), 특수문자`로 구성<br>
&nbsp;&nbsp;&nbsp;&nbsp;- DB에 중복된 username이 없다면 회원을 저장하고 Client 로 성공했다는 메시지, 상태코드 반환<br><br>
2) 로그인 API<br>
&nbsp;&nbsp;&nbsp;&nbsp;- username, password를 Client에서 전달받기<br>
&nbsp;&nbsp;&nbsp;&nbsp;- DB에서 username을 사용하여 저장된 회원의 유무를 확인하고 있다면 password 비교<br>
&nbsp;&nbsp;&nbsp;&nbsp;- 로그인 성공 시, 로그인에 성공한 유저의 정보와 JWT를 활용하여 토큰을 발급하고, <br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;발급한 토큰을 Header에 추가하고 성공했다는 메시지, 상태코드 와 함께 Client에 반환<br><br>
3) 전체 게시글 목록 조회 API<br>
&nbsp;&nbsp;&nbsp;&nbsp;- 제목, 작성자명(username), 작성 내용, 작성 날짜를 조회하고 날짜 기준 내림차순으로 정렬<br><br>
4) 게시글 작성 API<br>
&nbsp;&nbsp;&nbsp;&nbsp;- 토큰을 검사하여, 유효한 토큰일 경우에만 게시글 작성 가능<br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;제목, 작성자명(username), 작성 내용을 저장하고 저장된 게시글을 Client 로 반환<br><br>
5) 선택한 게시글 조회 API<br>
&nbsp;&nbsp;&nbsp;&nbsp;- 선택한 게시글의 제목, 작성자명, 작성 날짜, 작성 내용 조회<br><br>
6) 선택한 게시글 수정 API<br>
&nbsp;&nbsp;&nbsp;&nbsp;- 토큰을 검사한 후, 유효한 토큰이면서 해당 사용자가 작성한 게시글만 수정 가능<br>
&nbsp;&nbsp;&nbsp;&nbsp;- 제목, 작성 내용을 수정하고 수정된 게시글을 Client 로 반환<br><br>
7) 선택한 게시글 삭제 API<br>
&nbsp;&nbsp;&nbsp;&nbsp;- 토큰을 검사한 후, 유효한 토큰이면서 해당 사용자가 작성한 게시글만 삭제 가능<br>
&nbsp;&nbsp;&nbsp;&nbsp;- 선택한 게시글을 삭제하고 Client 로 성공했다는 표시 반환<br>

