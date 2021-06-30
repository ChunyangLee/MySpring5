package com.lcy.dao.impl;

import com.lcy.bean.Book;
import com.lcy.dao.BookDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class BookDAOimpl implements BookDAO {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void add(Book book) {
        String sql = "insert into t_book(name,price,author,sales,stock,img_path) values(?,?,?,?,?,?)";
        int update = jdbcTemplate.update(sql, book.getName(), book.getPrice(), book.getAuthor(), book.getSales(), book.getStock(), book.getImgPath());
    }
}
