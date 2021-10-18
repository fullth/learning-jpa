# Overview 
JPA학습과 API문서화  
(향후 추가학습한 소스로 변경예정)


# Search Posts
## Request
|항목|값|
|---|---|
|URL|GET /api/v1/boards|
  
## Response
```json
  {
      "id": 7,
      "title": "게시판 등록 테스트",
      "content": "JPA를 이용한 게시판, 등록 테스트 입니다.",
      "writer": "fullth",
      "hits": 0,
      "deleteYn": "N",
      "createdDate": "2021-10-17T22:16:20",
      "modifiedDate": null
  },
  {
      "id": 6,
      "title": "게시판 등록 테스트",
      "content": "JPA를 이용한 게시판, 등록 테스트 입니다.",
      "writer": "fullth",
      "hits": 0,
      "deleteYn": "N",
      "createdDate": "2021-10-17T22:15:29",
      "modifiedDate": null
  },
```  
# Register Posts
## Request
|항목|값|
|---|---|
|URL|POST /api/v1/boards|
|Body|title, content, writer, deleteYn|
```json
{
    "title": "게시물 등록",
    "content": "게시물 등록",
    "writer": "fullth",
    "deleteYn": "N"
}
```  
## Response
```json
5(id)
```  
# Fetch Posts
## Request
|항목|값|
|---|---|
|URL|FETCH /api/v1/boards/{id}|
|Body|title, content, writer, deleteYn|
```json
{
    "title": "게시물 수정",
    "content": "게시물 수정",
    "writer": "fullth",
    "deleteYn": "N"
}
```  
## Response
```json
5(id)

# 수정 후 조회 결과
{
    "id": 7,
    "title": "수정테스트",
    "content": "수정테스트",
    "writer": "fullth",
    "hits": 0,
    "deleteYn": "N",
    "createdDate": "2021-10-17T22:16:20",
    "modifiedDate": "2021-10-18T14:59:16"
}
```  
