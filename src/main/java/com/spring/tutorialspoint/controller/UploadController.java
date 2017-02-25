package com.spring.tutorialspoint.controller;

import com.spring.tutorialspoint.dao.PersonDao;
import com.spring.tutorialspoint.dao.StudentDao;
import com.spring.tutorialspoint.exception.SpringException;
import com.spring.tutorialspoint.po.PersonDo;
import com.spring.tutorialspoint.po.Student;
import com.utils.FileUtilsUp;
import com.utils.StringUtilsUp;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by sky on 2016/12/18.
 */
@Controller
public class UploadController {

    //通过Spring的autowired注解获取spring默认配置的request
    @Autowired
    private HttpServletRequest httpServletRequest;

    static Logger log = Logger.getLogger(UploadController.class.getName());


    @RequestMapping(value = "/upload.do1", method = {RequestMethod.GET, RequestMethod.POST})
    public ModelAndView Upload() {
        return new ModelAndView("upload");
    }

    /*
     * 采用file.Transto 来保存上传的文件
     */
    @RequestMapping(value = "/filesUpload.do1", method = RequestMethod.POST)
    public String fileUpload2(@RequestParam("files") CommonsMultipartFile[] files) throws IOException {
        long startTime = System.currentTimeMillis();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String fileDir = httpServletRequest.getSession().getServletContext().getRealPath("/") + "/upload/" + sdf.format(new Date());
        File fdir = new File(fileDir);
        if (!fdir.exists()) {
            fdir.mkdirs();
        }
        if (null != files && files.length > 0) {
            for (int i = 0; i < files.length; i++) {
                CommonsMultipartFile file = files[i];
                String filePath = fileDir + "/" + file.getOriginalFilename();
                FileUtilsUp.saveFile(file, filePath);
            }
        } else {
            return "请先选择需要上传的文件";
        }
        long endTime = System.currentTimeMillis();
        System.out.println("方法二的运行时间：" + String.valueOf(endTime - startTime) + "ms");
        return "redirect:/fileList.do1";
    }

    /***
     * 读取上传文件中得所有文件并返回
     *
     * @return
     */
    @RequestMapping(value = "/fileList.do1", method = {RequestMethod.GET, RequestMethod.POST})
    public ModelAndView fileList(ModelMap model) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String filePath = httpServletRequest.getSession().getServletContext().getRealPath("/") + "/upload/" + sdf.format(new Date()) + "/";
        ModelAndView mav = new ModelAndView("final");
        File uploadDest = new File(filePath);
        String[] fileNames = uploadDest.list();
        for (int i = 0; i < fileNames.length; i++) {
            //打印出文件名
            System.out.println(fileNames[i]);
        }
        model.addAttribute("fileNames", fileNames);
        return mav;
    }


}
