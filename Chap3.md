홈 화면
API Endpoint
GET /appname/home

Request Body

```json
{
	"userInfo": {
	"username" : "String"
	"email" : "String"
	},
	"missionSummary": {
	"totalMissions": 10,
	"completedMissions": 6,
	"ongoingMissions": 4
	}
}
```

Request Header
Authorization: Bearer {token}
사용자가 로그인을 하고 JWT 토큰 또는 다른 인증 토큰을 받으면, 그 토큰을 Authorization 헤더에 포함시켜 API 요청을 합니다. 이를 통해 서버는 토큰을 검증하고 사용자 ID를 파악하게 됩니다.

query String
쿼리 스트링을 사용할 필요가 없음

Path variable
Path variable 사용할 필요가 없음

미션 목록 조회
API Endpoint
GET /appname/user/missions

Request Body

```json
{
	"missions": [
		{
		"id": 1,
		"title": "재밌는 미션",
		"description": "이 미션을 수행 완료했어요!"
		},
		{
		"id": 2,
		"title": "어려웠던 미션",
		"description": "이 미션은 어려웠지만 그만큼 재밌어요!"
		}
	]
}
```

Request Header
Authorization : accessToken (String)

query String
GET /appname/user/missions?status=ongoing&status=completed

Path variable
Path variable 사용할 필요가 없음

마이페이지 리뷰 작성
API Endpoint
POST /appname/user/reviews

Request Body

```json
{
	"title": "리뷰 제목",
	"content": "리뷰 내용",
	"missionId": 1
}
```

Request Header
Authorization: Bearer {token}
Content-Type: application/json

query String
쿼리 스트링을 사용할 필요가 없음.

Path variable
사용할 필요가 없음.

미션 성공 누르기
API Endpoint
PATCH /appname/missions/{missionId}/success

Request Body
Request Body가 필요하지 않음.

Request Header
Authorization: Bearer {token}

query String
쿼리 스트링을 사용할 필요가 없음.

Path variable
POST /appname/missions/{missionId}/success

회원 가입하기
API Endpoint
POST /appname/auth/register

Request Body

```json
{
    "username": "string",
    "email": "string",
    "password": "string",
    "confirmPassword": "string"
}
```

Request Header
Content-Type: application/json

query String
쿼리 스트링을 사용할 필요가 없음.

Path variable
사용할 필요가 없음.