-- 出版社の情報を格納するテーブル
DROP TABLE IF EXISTS publishers;
CREATE TABLE IF NOT EXISTS publishers (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(255) NOT NULL
);

-- 書籍の情報を格納するテーブル
DROP TABLE IF EXISTS books;
CREATE TABLE IF NOT EXISTS books (
    id INT PRIMARY KEY AUTO_INCREMENT, -- 主キーとしてのID, 自動インクリメントされる
    title VARCHAR(255) NOT NULL, -- 書籍のタイトル、NULLを許容しない
    author VARCHAR(255) NOT NULL, -- 書籍の著者名、NULLを許容しない
    publisher_id INT, -- 出版社ID。出版社テーブルと関連づける
    FOREIGN KEY (publisher_id) REFERENCES publishers(id) -- 出版社テーブルへの外部キー制約
);

-- 書籍に対するレビューを格納するテーブル
DROP TABLE IF EXISTS reviews;
CREATE TABLE IF NOT EXISTS reviews (
    id INT PRIMARY KEY AUTO_INCREMENT,
    book_id INT NOT NULL,
    review_text TEXT,
    FOREIGN KEY (book_id) REFERENCES books(id)
);