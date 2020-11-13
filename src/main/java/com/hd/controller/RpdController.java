package com.hd.controller;

import com.hd.entity.Release;
import com.hd.service.RpdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.HashMap;
import java.util.List;

@Controller
public class RpdController {
    @Autowired
    RpdService rpdService;

    /**
     * 程序管理
     * @return
     */
    @RequestMapping(value = "/rpdrelease", method = RequestMethod.GET)
    public String rpdRelease(ModelMap map) {
        List<HashMap<String, Object>> list = rpdService.list();
        map.addAttribute("rels", list);

        return "rpdrelease";
    }
}
