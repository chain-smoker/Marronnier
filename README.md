# Maronnier, 칵테일 추천 시스템 🍸

## 🏝️Intro: 서비스 소개
<br/>
<strong>Maronnier, 술 추천 시스템</strong>이란 술을 사랑하는, 또는 술에 대해 잘 모르는 사람들을 위한 취향 기반 술 추천 시스템으로,<br/>
자신의 취향에 맞는 술을 적합하게 찾을 수 있습니다.<br/>
추가로 피드 게시판에서 유저간의 소통이 가능하며, <br/>
각자의 술 경험을 공유할 수 있습니다.

<br/>

### ⭐️ Feat: 주요 기능 소개

#### 1) 칵테일 추천 기능
유저가 무엇을 마시고 싶은지 모를 때, 또는 가장 본인에게 적합한 술을 찾기 위해 술 추천 기능을 사용할 수 있습니다.
몇 가지 질문을 통해 유저에게 근접한 술을 추천해주며, 술 제조법과 재료 정보를 알 수 있습니다.

#### 2) 피드
유저의 술 장바구니에 담긴 술들을 유저가 리뷰하고 해당 술을 끌어다가 새로운 내용들을 작성할 수 있습니다.
이를 통해 유저들간의 새로운 제조법과 다양한 팁과 정보들을 알 수 있습니다.

#### 3) 취향 기반 술 추천 시스템
쌓여온 DB를 통해, 자신의 취향에 맞는 술을 자동으로 추천해주는 시스템입니다.

<br/>
📅 <strong>프로젝트 기간</strong> : 2023.07.07 ~ 2023.07.30 (약 24일)


## 🛠 개발 환경

- Language  : Java 11 (OpenJDK 11.0.15.9-1)
- Front : Bootstrap(2.7.12)
- 형상 관리 : Github

[//]: # (여기는 참고용)
- Language  : Java (OpenJDK 8)
- DBMS : Oracle (11g)
- Server : Apache Tomcat (8.5)
- Front : HTML5, CSS3, JavaScript, jQuery, Bootstrap
- Server Programming : JSP/Servlet, AJAX
- Framework : Spring, MyBatis
- Build Tool : Maven
- IDE : Eclipse, Visual Studio Code, sqldeveloper
- Modeling Tool : StarUML, erdcloud, 카카오오븐
- 형상 관리 : Github
- API : Summernote, I'm port, Kakao sendLink, Naver login, Daum map

[//]: # (여기는 참고용)

<br>



## 🗂 Directory: 디렉토리 구조

```
/src/main
├── board
│   ├── controller
│   ├── domain
│   │    ├── entity
│   │    └── repository
│   ├── dto
│   └── service
├── members
│   └── login
│        ├── application
│        │    ├── controller
│        │    └── dto
│        ├── common
│        │    ├── argumentresolver
│        │    ├── interceptor
│        │    └── session
│        └── domain
│              ├── entity
│              ├── repository
│              └── service
└── reservation
     ├── controller
     ├── dto
     ├── entity
     ├── repository
     └── service

/main/resources
├── static
│   ├── css
│   └── img
└── static
     ├── board
     ├── common
     ├── css
     ├── error
     ├── login
     ├── members
      └── reservation

/src/test
└── test                                   
```

## 테스트
```
1. login - Domain - service의 LoginServiceTest        
2. login - Domain - service의 MemberServiceTest
3. reservation - controller의 reserveServiceTest
``` 

<br/>

`api` : 서버와의 통신을 위한 폴더입니다. axios를 활용한 작업을 주로 담당합니다.

`assets` : 컴포넌트를 구성하는 이미지파일들을 저장하기위한 폴더 입니다.

`components` : 페이지를 구성하는 컴포넌트들을 정리하기위한 폴더입니다.

`hooks` : 커스텀 훅을 정리하기 위한 폴더입니다.

`pages` : 서비스를 구성하는 페이지를 정리하기 위한 폴더입니다.

`redux` : 전역변수를 관리하는 store와 modules를 정리하기 위한 폴더입니다.

`shared` : 라우팅을 위한 폴더입니다. 서브라우터를 활용하여 더 세분화하여 정리하였습니다.

`utils` : 유용하게 쓸 수 있는 함수와 글로벌하게 적용되는 컴포넌트들을 관리하기 위한 폴더입니다.


## 📔 Architecture: 서비스 아키텍쳐

![Slice 4](https://user-images.githubusercontent.com/102432453/194732437-e582ef0a-5d9a-4772-8f46-95208a556585.jpg)

![image](https://user-images.githubusercontent.com/103619605/182366619-1c5ad67d-7b9d-4844-bcef-00ca75498f61.png)
<br>
<br>
<br>



## 📌 SW유스케이스
위키 - [USECASE](https://github.com/MTVS-CodeMagician/MTVS-reserve/wiki/USECASE)

![image](https://github.com/MTVS-CodeMagician/MTVS-reserve/assets/136250818/4b428dd6-c93c-4213-8d21-743f1d1681fc)
<br>
<br>
<br>


## 🧾 서비스 흐름도
위키 - [FlowChart](https://github.com/MTVS-CodeMagician/MTVS-reserve/wiki/Flow-Chart)

![image](https://github.com/MTVS-CodeMagician/MTVS-reserve/assets/136250818/a76c1027-3ade-4284-aec0-96be084f5995)
<br>
<br>
<br>

## 📊 E-R Diagram
위키 - [ERD](https://github.com/MTVS-CodeMagician/MTVS-reserve/wiki/ERD)

![MagicPot_ERD](https://user-images.githubusercontent.com/78246187/127444877-dda61529-a8ff-40ce-bb8b-bff21db3ea05.png) <br><br>

![image](https://user-images.githubusercontent.com/103619605/182579207-e5070ca5-2cde-43d1-94f7-5414a2d56a9f.png)
<br>
<br>
<br>

## ✅ 화면 구성

### 회원가입 / 메인화면 / 사용자 튜토리얼 화면
![image](https://user-images.githubusercontent.com/103620466/182588812-326be119-90cb-4264-b3f1-bb7eb059888f.png)
<br>
<br>

### 매장 보기 화면 (전체 매장 / 카테고리 선택 / 매장명 검색)
![image](https://user-images.githubusercontent.com/103620466/182589092-43fdf433-026b-47da-9d48-a5c5105ecdf3.png)
<br>
<br>

### 커뮤니티 게시판 화면 / 리뷰 등록 / 리뷰 수정
![image](https://user-images.githubusercontent.com/103620466/182589351-00081d31-ca43-4193-9fb2-23fa1b506990.png)
<br>
<br>

### 등급 시각화 / 리워드 화면 / 신규 매장등록 화면
![image](https://user-images.githubusercontent.com/103620466/182589764-d97e7c59-957b-47aa-a884-1e62ba9cd57d.png)
<br>
<br>
<br>



## 💻 팀원 소개

<table>
  <tr>
    <td align="center"><img src="https://item.kakaocdn.net/do/fd49574de6581aa2a91d82ff6adb6c0115b3f4e3c2033bfd702a321ec6eda72c" width="100" height="100"/></td>
    <td align="center"><img src="https://mb.ntdtv.kr/assets/uploads/2019/01/Screen-Shot-2019-01-08-at-4.31.55-PM-e1546932545978.png" width="100" height="100"/></td>
    <td align="center"><img src="https://www.rcreplicas.co.kr/shopimages/rcreplicas/0540030004873.jpg?1662014818" width="100" height="100"/></td>
    <td align="center"><img src="https://i.pinimg.com/236x/ed/bb/53/edbb53d4f6dd710431c1140551404af9.jpg" width="100" height="100"/></td>
    <td align="center"><img src="https://i.pinimg.com/236x/ed/bb/53/edbb53d4f6dd710431c1140551404af9.jpg" width="100" height="100"/></td>
    <td align="center"><img src="https://search.pstatic.net/common/?src=http%3A%2F%2Fpost.phinf.naver.net%2FMjAxOTA1MTZfMTk5%2FMDAxNTU3OTM3Nzk5OTc2.RYHaYoOO6PJpy1jJB3aphq0xufqtFmXAKcbUrxRIoyIg.hRUVOlJAPZf8GvyovPIkDmhC6ZqhIF5pKkibnDTCBKYg.JPEG%2FIAGU9C6_iwxod_Z2Q7dYWNGdnGx4.jpg&type=sc960_832" width="100" height="100"/></td>
  </tr>

  <tr>
    <td align="center"><a href="https://github.com/jinvvoo" target='_blank'>김진우</a></td>
    <td align="center"><a href="https://github.com/" target='_blank'>전태현</a></td>
    <td align="center"><a href="https://github.com/" target='_blank'>정지원</a></td>
    <td align="center"><a href="https://github.com/" target='_blank'>조명환</a></td>
    <td align="center"><a href="https://github.com/CodeJugller" target='_blank'>진용민</a></td>
    <td align="center"><a href="https://github.com/" target='_blank'>추민경</a></td>

  </tr>

  <tr>
    <td align="center"><b>서버개발</b></td>
    <td align="center"><b>서버개발</b></td>
    <td align="center"><b>서버개발</b></td>
    <td align="center"><b>서버개발</b></td>
    <td align="center"><b>서버개발</b></td>
    <td align="center"><b>서버개발</b></td>
  </tr>

</table>

## 업무 분담
확실
- 회원 (술 바구니) -> @정지원 
- 칵테일 (조주법, 재료, 카테고리) -> @김진우 + @진용민 
- 요청글 + 신고 -> @조명환 
- 피드 (좋아요) + 관리자 -> @전태현 


<br>


## 📌 Trouble Shooting: 트러블 슈팅

<details> <summary>➡️ 😛전태현: 새로고침시 데이터가 안불러와지는 문제가 있었습니다. </summary> <div markdown="1">
  <br/>

**`문제원인`**
* 인터셉터를 사용하기에 토큰이 자동으로 담겨 서버에 요청을 보내는 줄 알았는데 새로고침을 할 경우 인터셉터가 실행되기전에 요청을 보내고 있었습니다. [개발자도구]의 [네트워크]에서 로그를 보고 토큰이 담겨지지 않은 것을 확인할 수 있었습니다.

**`해결방안`**
* useEffect를 통해 axios인스턴스를 실행시켜 데이터를 불러왔었는데, 인스턴스가 실행되기전에 sessionStorage.setItem으로 토큰을 담는 코드를 작성해주었습니다.

**`자세한 내용`**
* [React | 새로고침시 데이터가 안불러와지는 문제](https://velog.io/@shackstack/React-%EC%83%88%EB%A1%9C%EA%B3%A0%EC%B9%A8%EC%8B%9C-%EB%8D%B0%EC%9D%B4%ED%84%B0%EA%B0%80-%EC%95%88%EB%B6%88%EB%9F%AC%EC%99%80%EC%A7%80%EB%8A%94-%EB%AC%B8%EC%A0%9C)


  </div>
  </details>

<details> <summary>➡️ 🥸정지원: React slick 각 자식요소에 Margin 및 Padding css 설정이 안 되는 이슈를 발견하였습니다. </summary> <div markdown="1">
  <br/>

**`문제원인`**
* 라이브러리 특성상 기본적으로 설정되어 있는 css 파일들이 있기에, 기존의 설정되어 있는 css가 우선적으로 선언되어 내가 선언하는 css가 적용이 되지 않는 문제를 발견하였습니다.


**`해결방안`**
* react slick build시 사용되는 slick.css와 slick-theme.css를 따로 빼와서 margin과 padding default 값을 삭제 해, 원하는 대로 css 수정을 가능하게 변경하였습니다.

  </div>
  </details>
 
<br>

# Wiki
### [Home](https://github.com/MTVS-CodeMagician/MTVS-reserve/wiki)

### 프로젝트 세부 사항
* [Notion] <br>
* [Testcode] <br>
* [API] <br>

### 협업
* [ProjectBoard] <br>
* [깃플로우](https://github.com/MTVS-CodeMagician/MTVS-reserve/wiki/%EA%B9%83%ED%94%8C%EB%A1%9C%EC%9A%B0) <br>

### 적용 기술 및 전략
* [USECASE](https://github.com/MTVS-CodeMagician/MTVS-reserve/wiki/USECASE)
* [ERD](https://github.com/MTVS-CodeMagician/MTVS-reserve/wiki/ERD)
* [Github-Flow](https://github.com/MTVS-CodeMagician/MTVS-reserve/wiki/Github-Flow)
* [Flow-Chart](https://github.com/MTVS-CodeMagician/MTVS-reserve/wiki/Flow-Chart)
* [Figma](https://github.com/MTVS-CodeMagician/MTVS-reserve/wiki/Figma)
