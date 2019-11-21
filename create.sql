/* 형태타입 (공간, 건물형태, 철거대상 등) */
CREATE TABLE IF NOT EXISTS space_type (
  space_type_no INTEGER PRIMARY KEY AUTOINCREMENT,
  space_type_name VARCHAR(50) NOT NULL
);

/*
형태 (공간, 건물형태, 철거대상 등)
공간구분, 건물형태, 철거대상의 값들이 저장된다.
*/
CREATE TABLE IF NOT EXISTS space (
  space_type_no INTEGER NOT NULL,
  space_no INTEGER NOT NULL,
  space_name VARCHAR(50) NOT NULL,
  sequence_order INTEGER NOT NULL,
  PRIMARY KEY (space_type_no, space_no),
  CONSTRAINT fk_space_space_type1 FOREIGN KEY (space_type_no) REFERENCES space_type(space_type_no)
);
CREATE INDEX IF NOT EXISTS space_idx1 ON space(space_type_no, space_no);
CREATE INDEX IF NOT EXISTS space_idx1 ON space(space_no);

/*
형태의 depth
공간구분3, 건물형태, 철거대상 등의 연결 관계를 위한 테이블
*/
CREATE TABLE IF NOT EXISTS space_depth (
  space_type_no INTEGER NOT NULL,
  parent_space_no INTEGER NOT NULL,
  child_space_no INTEGER NOT NULL,
  PRIMARY KEY (space_type_no, parent_space_no, child_space_no),
  CONSTRAINT fk_space_space_space0 FOREIGN KEY (space_type_no) REFERENCES space_type(space_type_no),
  CONSTRAINT fk_space_space_space1 FOREIGN KEY (parent_space_no) REFERENCES space(space_no),
  CONSTRAINT fk_space_space_space2 FOREIGN KEY (child_space_no) REFERENCES space(space_no)
);
CREATE INDEX IF NOT EXISTS space_depth_idx1 ON space_depth(space_type_no, parent_space_no);
CREATE INDEX IF NOT EXISTS space_depth_idx2 ON space_depth(space_type_no, parent_space_no, child_space_no);
CREATE INDEX IF NOT EXISTS space_depth_idx3 ON space_depth(space_type_no, child_space_no);
CREATE INDEX IF NOT EXISTS space_depth_idx4 ON space_depth(child_space_no);

/*
형태의 계산식
특정 공간의 계산식을 수정한 경우에만 사용
*/
CREATE TABLE IF NOT EXISTS formula (
  space_no INTEGER NOT NULL,
  formula TEXT NOT NULL,
  PRIMARY KEY (space_no),
  CONSTRAINT fk_formula_space1 FOREIGN KEY (space_no) REFERENCES space(space_no)
);
CREATE INDEX IF NOT EXISTS formula_idx1 ON formula(space_no);

/*
형태의 가격
공간구분3, 건물형태, 철거대상등의 가격 설정을 위한 테이블
*/
CREATE TABLE IF NOT EXISTS price (
  space_type_no INTEGER NOT NULL,
  parent_space_no INTEGER NOT NULL,
  child_space_no INTEGER NOT NULL,
  price INTEGER NOT NULL,
  PRIMARY KEY (space_type_no, parent_space_no, child_space_no),
  CONSTRAINT fk_price_space_depth1 FOREIGN KEY (space_type_no, parent_space_no, child_space_no) REFERENCES space_depth(space_type_no, parent_space_no, child_space_no)
);
CREATE INDEX IF NOT EXISTS price_idx1 ON price(space_type_no, parent_space_no);
CREATE INDEX IF NOT EXISTS price_idx2 ON price(space_type_no, parent_space_no, child_space_no);
CREATE INDEX IF NOT EXISTS price_idx3 ON price(space_type_no, child_space_no);
CREATE INDEX IF NOT EXISTS price_idx4 ON price(child_space_no);

/*
기본 계산식
공간구분3의 기본 계산식
*/
CREATE TABLE IF NOT EXISTS default_formula (
  default_formula_no INTEGER PRIMARY KEY AUTOINCREMENT,
  default_formula TEXT NOT NULL
);

/*
아이콘 이미지
아이콘 이미지를 base64로 저장
*/
CREATE TABLE IF NOT EXISTS icon_image (
  space_no INT NOT NULL,
  icon_image TEXT NOT NULL,
  image_type TEXT NOT NULL,
  PRIMARY KEY (space_no),
  CONSTRAINT fk_icon_image_space1 FOREIGN KEY (space_no) REFERENCES space(space_no)
);
CREATE INDEX IF NOT EXISTS icon_image_idx1 ON icon_image(space_no);

/*
최소층 기준으로 이상일때 추가요금
ex) 2층부터 2000, 10층부터 3000, 20층 부터 4000
*/
CREATE TABLE IF NOT EXISTS surcharge_layer (
  surcharge_layer_no INTEGER PRIMARY KEY AUTOINCREMENT,
  min_layer INTEGER NOT NULL,
  surcharge_per_layer VARCHAR(45) NOT NULL,
  description TEXT NULL
);