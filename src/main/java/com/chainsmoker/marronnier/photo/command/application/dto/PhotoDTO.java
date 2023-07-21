package com.chainsmoker.marronnier.photo.command.application.dto;

import com.chainsmoker.marronnier.photo.command.domain.aggregate.entity.PhotoCategory;

public class PhotoDTO {
    private String photoName;       //오리지널 이름
    private String photoRename;     //변경 후 이름
    private PhotoCategory photoCategory;   //사진 구분(조주법, 재료, 피드)
    private String photoRoot;       //사진 위치

    public PhotoDTO() {
    }

    public PhotoDTO(String photoName, String photoRename, PhotoCategory photoCategory, String photoRoot) {
        this.photoName = photoName;
        this.photoRename = photoRename;
        this.photoCategory = photoCategory;
        this.photoRoot = photoRoot;
    }

    public String getPhotoName() {
        return photoName;
    }

    public void setPhotoName(String photoName) {
        this.photoName = photoName;
    }

    public String getPhotoRename() {
        return photoRename;
    }

    public void setPhotoRename(String photoRename) {
        this.photoRename = photoRename;
    }

    public PhotoCategory getPhotoCategory() {
        return photoCategory;
    }

    public void setPhotoCategory(PhotoCategory photoCategory) {
        this.photoCategory = photoCategory;
    }

    public String getPhotoRoot() {
        return photoRoot;
    }

    public void setPhotoRoot(String photoRoot) {
        this.photoRoot = photoRoot;
    }

    @Override
    public String toString() {
        return "PhotoDTO{" +
                "photoName='" + photoName + '\'' +
                ", photoRename='" + photoRename + '\'' +
                ", photoCategory=" + photoCategory +
                ", photoRoot='" + photoRoot + '\'' +
                '}';
    }
}
