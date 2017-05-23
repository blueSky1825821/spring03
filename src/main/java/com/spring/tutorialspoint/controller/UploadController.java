package com.spring.tutorialspoint.controller;

import com.google.common.collect.Lists;
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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by sky on 2016/12/18.
 */
@Controller
public class UploadController {

    //通过Spring的autowired注解获取spring默认配置的request
    @Autowired
    private HttpServletRequest httpServletRequest;

    static Logger log = Logger.getLogger(UploadController.class.getName());

    //定义一个数组，用于保存可上传的图片类型       
    private List<String> fileTypes =
            Lists.newArrayList(
                    "jpg", "jpeg", "bmp", "gif"
            );


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
        log.error("方法二的运行时间：" + String.valueOf(endTime - startTime) + "ms");
        return "redirect:/fileList.do1";
    }

    /*
     * 采用file.Transto 来保存上传的文件
     */
    @RequestMapping(value = "/picUpload.do1", method = RequestMethod.POST)
    public String picsUpload(@RequestParam("pics") CommonsMultipartFile[] pics, ModelMap model) throws IOException {
        long startTime = System.currentTimeMillis();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String fileDir = httpServletRequest.getSession().getServletContext().getRealPath("/") + "/upload/pics/" + sdf.format(new Date());
        File fdir = new File(fileDir);
        if (!fdir.exists()) {
            fdir.mkdirs();
        }
        //限制只上传一张照片
        if (null != pics && pics.length > 0) {
            for (int i = 0; i < pics.length; i++) {
                CommonsMultipartFile pic = pics[i];
                //文件名
                String picName = pic.getOriginalFilename();
                //图片扩展名
                String ext = picName.substring(picName.lastIndexOf(".") + 1, picName.length());
                if (fileTypes.contains(ext)) {
                    String filePath = fileDir + "/" + pic.getOriginalFilename();
                    FileUtilsUp.saveFile(pic, filePath);
                }
            }
        } else {
            return "请先选择需要上传的图片";
        }
        long endTime = System.currentTimeMillis();
        System.out.println("方法二的运行时间：" + String.valueOf(endTime - startTime) + "ms");
        String[] fileNames = fdir.list();
        List<String> picsNameList = new ArrayList();
        Map<String, String> picsNameMap = new HashMap();
        for (int i = 0; i < fileNames.length; i++) {
            picsNameList.add(fileNames[i]);
            picsNameMap.put(fileNames[i], fileNames[i]);
        }
        model.addAttribute("picsPath", fdir.getPath() + "\\");
        model.addAttribute("picsNameList", picsNameList);
        model.addAttribute("fileNames", fileNames);
        model.addAttribute("picsNameMap", picsNameMap);
        return "final";
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

    @RequestMapping("/downFile.do1")
    public void downFile(HttpServletRequest request,
                         HttpServletResponse response) {
        // 得到要下载的文件名
        String picsPathName = request.getParameter("picsPathName");
        try {
//            picsPathName = new String(picsPathName.getBytes("iso8859-1"), "UTF-8");
            // 获取上传文件的目录
            ServletContext sc = request.getSession().getServletContext();
            // 上传位置
            String fileSaveRootPath = sc.getRealPath("/pisc");
            // 得到要下载的文件
            File file = new File(picsPathName);
            // 如果文件不存在
            if (!file.exists()) {
                request.setAttribute("message", "您要下载的资源已被删除！！");
                System.out.println("您要下载的资源已被删除！！");
                return;
            }
            // 处理文件名
            String realname = picsPathName.substring(picsPathName.lastIndexOf("\\") + 1);
            // 设置响应头，文件下载名，控制浏览器下载该文件
            response.setHeader("content-disposition", "attachment;filename="
                    + URLEncoder.encode(realname, "UTF-8"));
            // 读取要下载的文件，保存到文件输入流
            FileInputStream in = new FileInputStream(picsPathName);
            // 创建输出流
            OutputStream out = response.getOutputStream();
            // 创建缓冲区
            byte buffer[] = new byte[1024];
            int len = 0;
            // 循环将输入流中的内容读取到缓冲区当中
            while ((len = in.read(buffer)) > 0) {
                // 输出缓冲区的内容到浏览器，实现文件下载
                out.write(buffer, 0, len);
            }
            // 关闭文件输入流
            in.close();
            // 关闭输出流
            out.close();
        } catch (Exception e) {

        }
    }

}
