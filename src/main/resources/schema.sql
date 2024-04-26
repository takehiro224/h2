-- booksテーブルの作成
CREATE TABLE IF NOT EXISTS books (
    -- 主キーとしてのID, 自動インクリメントされる
    id INT PRIMARY KEY AUTO_INCREMENT,
    -- 書籍のタイトル、NULLを許容しない
    title VARCHAR(255) NOT NULL,
    -- 書籍の著者名、NULLを許容しない
    author VARCHAR(255) NOT NULL
);