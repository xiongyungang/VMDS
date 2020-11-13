package com.hd.dao;

import com.hd.entity.Release;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReleaseMapper {
    List<Release> findAll();

    void add(Release release);

    /**
     * 获取程序数
     * @return
     */
    Integer count();

}
