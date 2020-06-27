package com.hd.controller;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.hd.entity.Release;
import com.hd.service.RpdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.List;

@Controller
public class RpdController {
    @Autowired
    RpdService rpdService;

    /**
     * 导入rpdRelease
     * @param xml
     * @param file
     * @return
     * @throws IOException
     */
    @PostMapping(value = "/pnet/importRPD", produces = "application/xml;charset=utf-8")
    @ResponseBody
    public String importRpd(@RequestParam(value = "tel", required = false) String xml, @RequestParam(value = "file", required = false) MultipartFile file) throws IOException {
        String fileName = file.getOriginalFilename();

        // xml转对象
        XmlMapper xmlMapper = new XmlMapper();
        Release release = xmlMapper.readValue(xml, Release.class);
        release.setReleasefilepath("D:\\" + fileName);
        release.setReleasenr(String.valueOf(System.currentTimeMillis()));

        // 插入数据库
        rpdService.insert(release);

        // 写入本地
        file.transferTo(new File("D:\\"+fileName));

        return "<?xml version=\"1.0\" encoding=\"ISO-8859-1\"?><tel><success>0</success></tel>";
    }

    /**
     * 校验
     * @param request
     * @return
     */
    @PostMapping(value = "/pnet", produces = "application/xml;charset=utf-8")
    @ResponseBody
    public String verify(HttpServletRequest request) {

        return "<?xml version=\"1.0\" encoding=\"ISO-8859-1\"?><tel><success>0</success></tel>";
    }

    /**
     * 程序管理
     * @return
     */
    @GetMapping("/rpdrelease")
    public String rpdRelease(ModelMap map) {
        List<Release> list = rpdService.list();
        map.addAttribute("rels", list);

        return "rpdrelease";
    }
}
