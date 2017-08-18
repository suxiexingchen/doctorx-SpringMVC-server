package com.dkt.common.uploadPicture;

import com.dkt.common.SysException;
import org.apache.commons.io.FilenameUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author 馒头花卷儿
 * @Description:图片上传
 * @create 2017-08-17
 */
@RestController
@Scope("session")
public class UploadPicture {
    private static final Logger log = LoggerFactory.getLogger(UploadPicture.class);

    @RequestMapping("/external/uploadImage")
    public String springUpload(@RequestParam MultipartFile pic, HttpServletRequest request)throws SysException {

        DateFormat df = new SimpleDateFormat("yyyyMMddHHmmssSSS");
        String name = df.format(new Date());
        //获取扩展名
        String ext = FilenameUtils.getExtension(pic.getOriginalFilename());

        //相对路径
        String path = "/images/uploadimage/" + name + "." + ext;

        //上传路径
        String url = request.getSession().getServletContext().getRealPath("") + path;
        try {
            pic.transferTo(new File(url));
        } catch (IOException e) {
            e.printStackTrace();
            log.debug("上传图片异常");
        }

        return null;
    }


}
