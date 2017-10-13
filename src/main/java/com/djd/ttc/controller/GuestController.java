package com.djd.ttc.controller;

import com.djd.ttc.model.Guest;
import com.djd.ttc.service.IGuestService;
import org.apache.commons.io.FileUtils;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Iterator;
import java.util.List;

@Controller
public class GuestController {

    private IGuestService guestService;

    @Autowired
    public void setGuestService(IGuestService guestService) {
        this.guestService = guestService;
    }

    /**
     * 文件下载
     * @param fileName
     * @param file
     * @return
     * @throws IOException
     */
    public ResponseEntity<byte[]> download(String fileName, File file) throws IOException {

        String dfileName = new String(fileName.getBytes("gb2312"), "iso8859-1");

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        headers.setContentDispositionFormData("attachment", dfileName);

        return new ResponseEntity<byte[]>(FileUtils.readFileToByteArray(file), headers, HttpStatus.CREATED);
    }

    /**
     * 啊啊啊
     * 文件上传
     * @param file
     * @param filename
     * @return
     */
    public String uf(@RequestParam MultipartFile file, String filename) {
        OutputStream outputStream = null;
        try {
            FileCopyUtils.copy(file.getInputStream(), outputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "ok";
    }

    @RequestMapping(value = "g/json", method = RequestMethod.GET)
    @ResponseBody
    public List<Guest> getJson() {
        List<Guest> lgs = guestService.findall();
        return lgs;
    }

    @RequestMapping(value = "g/l", method = RequestMethod.GET)
    public ModelAndView findall() {
        List<Guest> lgs = guestService.findall();
        System.out.print(lgs.size());
        for (Iterator iterator = lgs.iterator(); iterator.hasNext(); ) {
            Guest g = (Guest) iterator.next();
            System.out.println(g.getUserid());
        }
        System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
        ModelAndView mav = new ModelAndView("rolelist");

        mav.addObject("lgs", lgs);
        return mav;
    }
}
