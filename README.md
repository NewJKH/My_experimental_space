# 이 공간은 제가 독학하며 학습한 기록을 남기는 공간입니다.
독학이 자랑은 아니지만, "나는 스스로 이정도 해낼 수 있다."를 보여주고 싶습니다.
나의 "노력"을 보여주고 싶은 공간이기도 합니다.
누군가는 이런걸 보면서 자극을 받고 같이 공부할 수 있을거라 생각이 됩니다.

제 공간에서는 실패와 경험을 많이 하며 성장하고 싶습니다.
```
"Play is the highest form of research."
놀이는 최고의 연구다.
– 알베르트 아인슈타인
```

남들이 보기엔 하찮은 놀이일지라도 나에게는 최고의 연구 장소 입니다.

| 기능 | 설명 | Method | URL | 필드 | 예시 요청 | 예시 응답 | 상태코드 | 로그인 필요 |
| --- | --- | --- | --- | --- | --- | --- | --- | --- |
| 회원가입 (회원 생성) | 새로운 회원을 등록합니다. | POST | /member/register | member_name (String, 필수), email (String, 필수), password (String, 필수) | {'member_name': '홍길동', 'email': 'hong@example.com', 'password': '1234'} | {'id': 1, 'member_name': '홍길동', 'email': 'hong@example.com', 'create_at': '2025-05-23T13:30:00.000+09:00', 'modified_at': '2025-05-23T13:30:00.000+09:00'} | 201: 회원 생성 성공, 400: 유효성 실패, 500: 서버 내부 오류 | X |
| 회원조회 (회원 번호) | 회원 ID로 단일 회원 정보를 조회합니다. | GET | /member?id={id} | id (Long, 필수) | - | {'id': 1, 'member_name': '홍길동', 'email': 'hong@example.com', 'create_at': '2025-05-23T13:30:00.000+09:00', 'modified_at': '2025-05-23T13:30:00.000+09:00'} | 200: 회원 조회 성공, 404: 회원 없음, 500: 서버 오류 | O |
| 회원조회 (전체 조회) | 모든 회원 목록을 조회합니다. | GET | /member/all | - | - | [{'id': 1, 'member_name': '홍길동', 'email': 'hong@example.com'}] | 200: 회원 목록 조회 성공, 500: 서버 오류 | O |
| 회원수정 (이름 수정) | 회원의 이름을 수정합니다. | PUT | /member/update | member_name (String, 필수) | {'member_name': '임꺽정'} | {'id': 1, 'member_name': '임꺽정', 'email': 'hong@example.com'} | 200: 수정 성공, 401: 인증 실패, 500: 서버 오류 | O |
| 회원삭제 (회원 번호) | 회원 탈퇴를 처리합니다. | DELETE | /member/delete/{id} | password (String, 필수) | {'password': '1234'} | - | 200: 삭제 성공, 401: 비밀번호 불일치, 404: 회원 없음 | O |
