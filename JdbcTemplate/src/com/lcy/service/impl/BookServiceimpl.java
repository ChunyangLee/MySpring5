package com.lcy.service.impl;

import com.lcy.bean.Book;
import com.lcy.dao.BookDAO;
import com.lcy.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookServiceimpl implements BookService {
    @Autowired
    private BookDAO bookDAOimpl;

}
