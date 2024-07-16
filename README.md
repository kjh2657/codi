# codi


 1) 스키마 구조
    
 - 상품, 브랜드, 카테고리 3개의 테이블이 존재
 - 상품에는 브랜드ID, 카테고리ID 등 다른 테이블과 조인을 위한 키 값이 존재 
 - 문제에 나온 A,B... 는 브랜드 이름으로 해석하여 테이블 설계
 - 상품과 브랜드는 등록/수정/삭제가 가능하도록 status 필드 값 추가(CREATE, USE, DELETE 로 컨트롤)


 2) 프로젝트 구조
    
 - springboot 3.3.1 java 21로 프로젝트 진행
 - 프로젝트는 admin, api(service api), core 3개의 모듈로 존재
 - 각각의 yml을 따로 두지 않고 core yml을 우선적으로 참조하도록 구현
 - 각각(admin/service) API에는 controller, service과 존재하고 core에 entity에 접근하는 service layer를 추가로 구현해, admin, service에서 공통적으로 사용할 수 있도록 설계
 - entity에 접근할 수 있는 객체인 command를 두어, entity에 접근하여 CRUD 실행
 - 잘못된 요청은 Valid를 통해 제어하고, 비지니스 로직에 대한 예외는 Error Code와 Advice로 제어
 - ./data에 h2 데이터베이스가 존재하고, ./ddl에 테이블 dml과 데이터 존재
 - 포트는 api : 8080, admin : 8081

 3) 실행방법
    
 - VM Option : -Dspring.profiles.active=local 추가 후 구동 

 4) API
    
 4-1 카테고리 별로 최저가격인 브랜드와 가격을 조회하고 총액
  - @Query(native=false)를 통해 window fuction을 사용하고 직접 Dto에 projection 하여 사용
    
 4-2 단일 브랜드로 전체 카테고리 상품을 구매할 경우 최저가격인 브랜드와 총액
  - @Query(native=false)를 통해 window fuction을 사용하고 직접 Dto에 projection 하여 사용
  - 전체 카테고리에 대한 상품이 존재해야하므로 category 테이블의 모든 카테고리가 존재하는지 확인 후, 코디가 가능한 카테고리, 브랜드이름, 전체금액을 1차적으로 조회
  - 해당 브랜드의 각 카테고리별 최저가 상품 조회 후 response 세팅

 4-3 특정 카테고리에서 최저가격 브랜드와 최고가격 브랜드를 확인하고 각 브랜드 상품의 가격
  - 카테 고리별 최저가 최고가를 각각 querydsl로 조회하여 값 세팅
    
 4-4 새로운 브랜드를 등록하고, 모든 브랜드의 상품을 추가, 변경, 삭제
  4-4-1 브랜드
   - 브랜드 단일조회 / 등록 / 수정 / 삭제 / 리스트 조회 구현
   - 삭제의 경우, 브랜드에 등록된 상품들 모두 삭제 되도록 처리
   - 리스트의 경우 몇개의 조건을 추가하여 페이징 처리
  4-4-2 상품
   - 상품 단일 조회 / 등록 / 수정 / 삭제 / 리스트 조회 구현
   - 리스트의 경우 몇개의 조건을 추가하여 페이징 처리 
