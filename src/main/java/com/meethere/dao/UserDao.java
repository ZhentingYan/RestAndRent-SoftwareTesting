package com.meethere.dao;

import com.meethere.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserDao extends JpaRepository<User,Integer> {
    User findByUserIDAndPassword(String userID, String password);
    User findByUserID(String userID);
    Page<User> findAllByIsadmin(int isadmin, Pageable pageable);
    int countByUserID(String userID);
    User findById(int id);
    List<User> findAll();
}
