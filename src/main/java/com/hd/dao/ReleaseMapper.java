package com.hd.dao;

import com.hd.entity.Release;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;

@Repository
public interface ReleaseMapper {
    List<HashMap<String, Object>> findAll();

}
