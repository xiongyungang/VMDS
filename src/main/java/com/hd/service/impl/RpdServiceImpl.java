package com.hd.service.impl;

import com.hd.dao.ReleaseMapper;
import com.hd.dao.UserMapper;
import com.hd.entity.Release;
import com.hd.entity.Role;
import com.hd.entity.User;
import com.hd.service.RpdService;
import com.hd.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class RpdServiceImpl implements RpdService {
	@Autowired
	ReleaseMapper releaseMapper;

	@Override
	public List<Release> list() {
		return releaseMapper.findAll();
	}

	@Override
	public void insert(Release release) {
		releaseMapper.add(release);
	}

	@Override
	public Integer count() {
		return releaseMapper.count();
	}
}
