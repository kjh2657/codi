
CREATE TABLE MUSINSA_BRAND (
    BRAND_ID     BIGINT NOT NULL AUTO_INCREMENT COMMENT '브랜드 ID',
    BRAND_STATUS VARCHAR(20) NOT NULL COMMENT '브랜드 상태',
    BRAND_NAME   VARCHAR(30) NOT NULL COMMENT '브랜드 이름',
    REG_USER     VARCHAR(50) NOT NULL COMMENT '등록자',
    UPD_USER     VARCHAR(50) NOT NULL COMMENT '수정자',
    REG_DATE     DATETIME(6) NOT NULL COMMENT '등록일시',
    UPD_DATE     DATETIME(6) NOT NULL COMMENT '수정일시'
)


CREATE TABLE MUSINSA_CATEGORY (
    CATEGORY_ID    BIGINT NOT NULL AUTO_INCREMENT COMMENT '카테고리 ID',
    CATEGORY_TYPE  VARCHAR(30) NOT NULL COMMENT '카테고리 타입',
    CATEGORY_NAME  VARCHAR(50) NOT NULL COMMENT '카테고리 이름',
    SORT        INT NOT NULL COMMENT '순서',
    REG_USER    VARCHAR(50) NOT NULL COMMENT '등록자',
    UPD_USER    VARCHAR(50) NOT NULL COMMENT '수정자',
    REG_DATE    DATETIME(6) NOT NULL COMMENT '등록일시',
    UPD_DATE    DATETIME(6) NOT NULL COMMENT '수정일시',
    PRIMARY KEY (CATEGORY_ID)
)


CREATE TABLE MUSINSA_PRODUCT (
    PRODUCT_ID      BIGINT NOT NULL AUTO_INCREMENT COMMENT '브랜드 ID',
    PRODUCT_STATUS  VARCHAR(20) NOT NULL COMMENT '상품 상태',
    CATEGORY_TYPE   VARCHAR(20) NOT NULL COMMENT '카테고리 타입',
    PRODUCT_NAME    VARCHAR(100) COMMENT '상품명',
    BRAND_ID        BIGINT NOT NULL COMMENT '브랜드 ID',
    PRICE           BIGINT NOT NULL COMMENT '상품가격',
    REG_USER        VARCHAR(50) NOT NULL COMMENT '등록자',
    UPD_USER        VARCHAR(50) NOT NULL COMMENT '수정자',
    REG_DATE        DATETIME(6) NOT NULL COMMENT '등록일시',
    UPD_DATE        DATETIME(6) NOT NULL COMMENT '수정일시'
)


insert into MUSINSA_CATEGORY(CATEGORY_TYPE, CATEGORY_NAME, SORT,REG_USER, UPD_USER, REG_DATE, UPD_DATE)
values
        ('TOP', '상의', 1, 'kjh', 'kjh', CURRENT_DATE(), CURRENT_DATE),
        ('OUTER', '아우터', 2, 'kjh', 'kjh', CURRENT_DATE(), CURRENT_DATE),
        ('BOTTOM', '하의', 3, 'kjh', 'kjh', CURRENT_DATE(), CURRENT_DATE),
        ('SNEAKERS', '스니커즈', 4, 'kjh', 'kjh', CURRENT_DATE(), CURRENT_DATE),
        ('BAG', '가방', 5, 'kjh', 'kjh', CURRENT_DATE(), CURRENT_DATE),
        ('CAP', '모자', 6, 'kjh', 'kjh', CURRENT_DATE(), CURRENT_DATE),
        ('SOCKS', '양말', 7, 'kjh', 'kjh', CURRENT_DATE(), CURRENT_DATE),
        ('ACC', '악세서리', 8, 'kjh', 'kjh', CURRENT_DATE(), CURRENT_DATE);





insert into MUSINSA_BRAND(BRAND_STATUS, BRAND_NAME,REG_USER, UPD_USER, REG_DATE, UPD_DATE)
values
       ('USE','A', 'kjh', 'kjh', CURRENT_DATE(), CURRENT_DATE),
       ('USE','B', 'kjh', 'kjh', CURRENT_DATE(), CURRENT_DATE),
       ('USE','C', 'kjh', 'kjh', CURRENT_DATE(), CURRENT_DATE),
       ('USE','D', 'kjh', 'kjh', CURRENT_DATE(), CURRENT_DATE),
       ('USE','E', 'kjh', 'kjh', CURRENT_DATE(), CURRENT_DATE),
       ('USE','F', 'kjh', 'kjh', CURRENT_DATE(), CURRENT_DATE),
       ('USE','G', 'kjh', 'kjh', CURRENT_DATE(), CURRENT_DATE),
       ('USE','H', 'kjh', 'kjh', CURRENT_DATE(), CURRENT_DATE),
       ('USE','I', 'kjh', 'kjh', CURRENT_DATE(), CURRENT_DATE);


insert into musinsa_product(PRODUCT_STATUS,CATEGORY_TYPE,PRODUCT_NAME, BRAND_ID, PRICE, REG_USER, UPD_USER, REG_DATE, UPD_DATE)
values ('USE','TOP', 'A TOP 1', 1, 11200, 'kjh', 'kjh', CURRENT_DATE(), CURRENT_DATE),
       ('USE','OUTER', 'A OUTER 1', 1, 5500, 'kjh', 'kjh', CURRENT_DATE(), CURRENT_DATE),
       ('USE','BOTTOM', 'A BOTTOM 1', 1, 4200, 'kjh', 'kjh', CURRENT_DATE(), CURRENT_DATE),
       ('USE','SNEAKERS', 'A SNEAKERS 1', 1, 9000, 'kjh', 'kjh', CURRENT_DATE(), CURRENT_DATE),
       ('USE','BAG', 'A BAG 1', 1, 2000, 'kjh', 'kjh', CURRENT_DATE(), CURRENT_DATE),
       ('USE','CAP', 'A CAP 1', 1, 1700, 'kjh', 'kjh', CURRENT_DATE(), CURRENT_DATE),
       ('USE','SOCKS', 'A SOCKS 1', 1, 1800, 'kjh', 'kjh', CURRENT_DATE(), CURRENT_DATE),
       ('USE','ACC', 'A ACC 1', 1, 2300, 'kjh', 'kjh', CURRENT_DATE(), CURRENT_DATE),

       ('USE','TOP', 'B TOP 1', 2, 10500, 'kjh', 'kjh', CURRENT_DATE(), CURRENT_DATE),
       ('USE','OUTER', 'B OUTER 1', 2, 5900, 'kjh', 'kjh', CURRENT_DATE(), CURRENT_DATE),
       ('USE','BOTTOM', 'B BOTTOM 1', 2, 3800, 'kjh', 'kjh', CURRENT_DATE(), CURRENT_DATE),
       ('USE','SNEAKERS', 'B SNEAKERS 1', 2, 9100, 'kjh', 'kjh', CURRENT_DATE(), CURRENT_DATE),
       ('USE','BAG', 'B BAG 1', 2, 2100, 'kjh', 'kjh', CURRENT_DATE(), CURRENT_DATE),
       ('USE','CAP', 'B CAP 1', 2, 2000, 'kjh', 'kjh', CURRENT_DATE(), CURRENT_DATE),
       ('USE','SOCKS', 'B SOCKS 1', 2, 2000, 'kjh', 'kjh', CURRENT_DATE(), CURRENT_DATE),
       ('USE','ACC', 'B ACC 1', 2, 2200, 'kjh', 'kjh', CURRENT_DATE(), CURRENT_DATE),

       ('USE','TOP', 'C TOP 1', 3, 10000, 'kjh', 'kjh', CURRENT_DATE(), CURRENT_DATE),
       ('USE','OUTER', 'C OUTER 1', 3, 6200, 'kjh', 'kjh', CURRENT_DATE(), CURRENT_DATE),
       ('USE','BOTTOM', 'C BOTTOM 1', 3, 3300, 'kjh', 'kjh', CURRENT_DATE(), CURRENT_DATE),
       ('USE','SNEAKERS', 'C SNEAKERS 1', 3, 9200, 'kjh', 'kjh', CURRENT_DATE(), CURRENT_DATE),
       ('USE','BAG', 'C BAG 1', 3, 2200, 'kjh', 'kjh', CURRENT_DATE(), CURRENT_DATE),
       ('USE','CAP', 'C CAP 1', 3, 1900, 'kjh', 'kjh', CURRENT_DATE(), CURRENT_DATE),
       ('USE','SOCKS', 'C SOCKS 1', 3, 2200, 'kjh', 'kjh', CURRENT_DATE(), CURRENT_DATE),
       ('USE','ACC', 'C ACC 1', 3, 2100, 'kjh', 'kjh', CURRENT_DATE(), CURRENT_DATE),

       ('USE','TOP', 'D TOP 1', 4, 10100, 'kjh', 'kjh', CURRENT_DATE(), CURRENT_DATE),
       ('USE','OUTER', 'D OUTER 1', 4, 5100, 'kjh', 'kjh', CURRENT_DATE(), CURRENT_DATE),
       ('USE','BOTTOM', 'D BOTTOM 1', 4, 3000, 'kjh', 'kjh', CURRENT_DATE(), CURRENT_DATE),
       ('USE','SNEAKERS', 'D SNEAKERS 1', 4, 9500, 'kjh', 'kjh', CURRENT_DATE(), CURRENT_DATE),
       ('USE','BAG', 'D BAG 1', 4, 2500, 'kjh', 'kjh', CURRENT_DATE(), CURRENT_DATE),
       ('USE','CAP', 'D CAP 1', 4, 1500, 'kjh', 'kjh', CURRENT_DATE(), CURRENT_DATE),
       ('USE','SOCKS', 'D SOCKS 1', 4, 2400, 'kjh', 'kjh', CURRENT_DATE(), CURRENT_DATE),
       ('USE','ACC', 'D ACC 1', 4, 2000, 'kjh', 'kjh', CURRENT_DATE(), CURRENT_DATE),

       ('USE','TOP', 'E TOP 1', 5, 10700, 'kjh', 'kjh', CURRENT_DATE(), CURRENT_DATE),
       ('USE','OUTER', 'E OUTER 1', 5, 5000, 'kjh', 'kjh', CURRENT_DATE(), CURRENT_DATE),
       ('USE','BOTTOM', 'E BOTTOM 1', 5, 3800, 'kjh', 'kjh', CURRENT_DATE(), CURRENT_DATE),
       ('USE','SNEAKERS', 'E SNEAKERS 1', 5, 9900, 'kjh', 'kjh', CURRENT_DATE(), CURRENT_DATE),
       ('USE','BAG', 'E BAG 1', 5, 2300, 'kjh', 'kjh', CURRENT_DATE(), CURRENT_DATE),
       ('USE','CAP', 'E CAP 1', 5, 1800, 'kjh', 'kjh', CURRENT_DATE(), CURRENT_DATE),
       ('USE','SOCKS', 'E SOCKS 1', 5, 2100, 'kjh', 'kjh', CURRENT_DATE(), CURRENT_DATE),
       ('USE','ACC', 'E ACC 1', 5, 2100, 'kjh', 'kjh', CURRENT_DATE(), CURRENT_DATE),

       ('USE','TOP', 'F TOP 1', 6, 11200, 'kjh', 'kjh', CURRENT_DATE(), CURRENT_DATE),
       ('USE','OUTER', 'F OUTER 1', 6, 7200, 'kjh', 'kjh', CURRENT_DATE(), CURRENT_DATE),
       ('USE','BOTTOM', 'F BOTTOM 1', 6, 4000, 'kjh', 'kjh', CURRENT_DATE(), CURRENT_DATE),
       ('USE','SNEAKERS', 'F SNEAKERS 1', 6, 9300, 'kjh', 'kjh', CURRENT_DATE(), CURRENT_DATE),
       ('USE','BAG', 'F BAG 1', 6, 2100, 'kjh', 'kjh', CURRENT_DATE(), CURRENT_DATE),
       ('USE','CAP', 'F CAP 1', 6, 1600, 'kjh', 'kjh', CURRENT_DATE(), CURRENT_DATE),
       ('USE','SOCKS', 'F SOCKS 1', 6, 2300, 'kjh', 'kjh', CURRENT_DATE(), CURRENT_DATE),
       ('USE','ACC', 'F ACC 1', 6, 1900, 'kjh', 'kjh', CURRENT_DATE(), CURRENT_DATE),

       ('USE','TOP', 'G TOP 1', 7, 10500, 'kjh', 'kjh', CURRENT_DATE(), CURRENT_DATE),
       ('USE','OUTER', 'G OUTER 1', 7, 5800, 'kjh', 'kjh', CURRENT_DATE(), CURRENT_DATE),
       ('USE','BOTTOM', 'G BOTTOM 1', 7, 3900, 'kjh', 'kjh', CURRENT_DATE(), CURRENT_DATE),
       ('USE','SNEAKERS', 'G SNEAKERS 1', 7, 9000, 'kjh', 'kjh', CURRENT_DATE(), CURRENT_DATE),
       ('USE','BAG', 'G BAG 1', 7, 2200, 'kjh', 'kjh', CURRENT_DATE(), CURRENT_DATE),
       ('USE','CAP', 'G CAP 1', 7, 1700, 'kjh', 'kjh', CURRENT_DATE(), CURRENT_DATE),
       ('USE','SOCKS', 'G SOCKS 1', 7, 2100, 'kjh', 'kjh', CURRENT_DATE(), CURRENT_DATE),
       ('USE','ACC', 'G ACC 1', 7, 2000, 'kjh', 'kjh', CURRENT_DATE(), CURRENT_DATE),

       ('USE','TOP', 'H TOP 1', 8, 10800, 'kjh', 'kjh', CURRENT_DATE(), CURRENT_DATE),
       ('USE','OUTER', 'H OUTER 1', 8, 6300, 'kjh', 'kjh', CURRENT_DATE(), CURRENT_DATE),
       ('USE','BOTTOM', 'H BOTTOM 1', 8, 3100, 'kjh', 'kjh', CURRENT_DATE(), CURRENT_DATE),
       ('USE','SNEAKERS', 'H SNEAKERS 1', 8, 9700, 'kjh', 'kjh', CURRENT_DATE(), CURRENT_DATE),
       ('USE','BAG', 'H BAG 1', 8, 2100, 'kjh', 'kjh', CURRENT_DATE(), CURRENT_DATE),
       ('USE','CAP', 'H CAP 1', 8, 1600, 'kjh', 'kjh', CURRENT_DATE(), CURRENT_DATE),
       ('USE','SOCKS', 'H SOCKS 1', 8, 2000, 'kjh', 'kjh', CURRENT_DATE(), CURRENT_DATE),
       ('USE','ACC', 'H ACC 1', 8, 2000, 'kjh', 'kjh', CURRENT_DATE(), CURRENT_DATE),

       ('USE','TOP', 'I TOP 1', 9, 11400, 'kjh', 'kjh', CURRENT_DATE(), CURRENT_DATE),
       ('USE','OUTER', 'I OUTER 1', 9, 6700, 'kjh', 'kjh', CURRENT_DATE(), CURRENT_DATE),
       ('USE','BOTTOM', 'I BOTTOM 1', 9, 3200, 'kjh', 'kjh', CURRENT_DATE(), CURRENT_DATE),
       ('USE','SNEAKERS', 'I SNEAKERS 1', 9, 9500, 'kjh', 'kjh', CURRENT_DATE(), CURRENT_DATE),
       ('USE','BAG', 'I BAG 1', 9, 2400, 'kjh', 'kjh', CURRENT_DATE(), CURRENT_DATE),
       ('USE','CAP', 'I CAP 1', 9, 1700, 'kjh', 'kjh', CURRENT_DATE(), CURRENT_DATE),
       ('USE','SOCKS', 'I SOCKS 1', 9, 1700, 'kjh', 'kjh', CURRENT_DATE(), CURRENT_DATE),
       ('USE','ACC', 'I ACC 1', 9, 2400, 'kjh', 'kjh', CURRENT_DATE(), CURRENT_DATE),