package com.chainsmoker.marronnier.photo.command.application.dto;

import com.chainsmoker.marronnier.photo.command.domain.aggregate.entity.EnumType.PhotoCategory;

public class PhotoDTO {

    private long id;                        //사진 아이디
    private long originId;                  //호출데이터 아이디
    private String photoName;               //오리지널 이름
    private String photoRename;             //변경 후 이름
    private PhotoCategory photoCategory;   //사진 구분(조주법, 재료, 피드)
    private String photoRoot;               //사진 위치

    public PhotoDTO() {
    }

    public PhotoDTO(long originId, String photoName, String photoRename, PhotoCategory photoCategory, String photoRoot) {
        this.originId = originId;
        this.photoName = photoName;
        this.photoRename = photoRename;
        this.photoCategory = photoCategory;
        this.photoRoot = photoRoot;
    }

    public PhotoDTO(long id , long originId, String photoName, String photoRename, PhotoCategory photoCategory, String photoRoot) {
        this.id = id;
        this.originId = originId;
        this.photoName = photoName;
        this.photoRename = photoRename;
        this.photoCategory = photoCategory;
        this.photoRoot = photoRoot;
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getOriginId() {
        return originId;
    }

    public void setOriginId(long originId) {
        this.originId = originId;
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

}
