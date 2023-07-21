package com.chainsmoker.marronnier.photo.command.domain.aggregate.entity;

import javax.persistence.*;

@Entity
@Table(name = "photo_tb")
public class Photo {
    @Id
    @Column(name = "PHOTO_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long photoId;               //사진 ID
    @Column(name = "PHOTO_NAME", nullable = false)
    private String photoName;          //오리지널 이름
    @Column(name = "PHOTO_RENAME", nullable = false)
    private String photoRename;        //변경 후 이름
    @Column(name = "PHOTO_CATEGORY", nullable = false)
    @Enumerated(EnumType.STRING)
    private PhotoCategory photoCategory; //사진 구분(조주법, 재료, 피드)
    @Column(name = "PHOTO_ROOT", nullable = false)
    private String photoRoot;            // 사진 위치

    protected Photo() {}
    public Photo(String photoName, String photoRename, PhotoCategory photoCategory, String photoRoot) {
        this.photoName = photoName;
        this.photoRename = photoRename;
        this.photoCategory = photoCategory;
        this.photoRoot = photoRoot;
    }
}
