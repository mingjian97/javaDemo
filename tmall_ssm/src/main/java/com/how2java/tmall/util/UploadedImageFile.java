package com.how2java.tmall.util;

import org.springframework.web.multipart.MultipartFile;

/**
 * @author: mingjian
 * @create: 2020-03-12 14:00
 */
public class UploadedImageFile {
    MultipartFile image;

    public MultipartFile getImage() {
        return image;
    }

    public void setImage(MultipartFile image) {
        this.image = image;
    }
}
