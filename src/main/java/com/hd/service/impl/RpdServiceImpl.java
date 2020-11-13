package com.hd.service.impl;

import com.hd.dao.ReleaseMapper;
import com.hd.entity.Release;
import com.hd.service.RpdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;


@Service
public class RpdServiceImpl implements RpdService {
	@Autowired
    ReleaseMapper releaseMapper;

	@Override
	public List<HashMap<String, Object>> list() {
		return releaseMapper.findAll();
	}
}
