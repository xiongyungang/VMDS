package com.hd.service;

import com.hd.entity.Release;
import com.hd.entity.Role;
import com.hd.entity.User;

import java.util.List;


public interface RpdService {

	List<Release> list();

	void insert(Release release);

	Integer count();
}
