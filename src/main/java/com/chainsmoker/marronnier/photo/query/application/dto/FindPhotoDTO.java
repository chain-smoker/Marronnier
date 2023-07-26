package com.chainsmoker.marronnier.photo.query.application.dto;

public class FindPhotoDTO {

    private long id;            // 사진 아이디
    private String photoName;   // 오리지널 이름
    private String photoRoot;   // 저장 된 경로

    public FindPhotoDTO() {
    }
    public FindPhotoDTO(long id, String photoName, String photoRoot) {
        this.id = id;
        this.photoName = photoName;
        this.photoRoot = photoRoot;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getPhotoName() {
        return photoName;
    }

    public void setPhotoName(String photoName) {
        this.photoName = photoName;
    }

    public String getPhotoRoot() {
        return photoRoot;
    }

    public void setPhotoRoot(String photoRoot) {
        this.photoRoot = photoRoot;
    }

    @Override
    public String toString() {
        return "FindPhotoDTO{" +
                "id=" + id +
                ", photoName='" + photoName + '\'' +
                ", photoRoot='" + photoRoot + '\'' +
                '}';
    }
}
