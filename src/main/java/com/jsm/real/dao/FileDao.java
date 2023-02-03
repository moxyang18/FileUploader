package com.jsm.real.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jsm.real.entity.File;
@Repository
public interface FileDao extends JpaRepository<File, Long> {

}
