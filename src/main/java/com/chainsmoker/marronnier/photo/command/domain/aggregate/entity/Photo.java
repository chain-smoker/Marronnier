package com.chainsmoker.marronnier.photo.command.domain.aggregate.entity;

import com.chainsmoker.marronnier.photo.command.domain.aggregate.entity.EnumType.PhotoCategory;
import com.chainsmoker.marronnier.photo.command.domain.aggregate.vo.OriginVO;
import lombok.Getter;

import javax.persistence.*;

@Entity
@Table(name = "PHOTO_TB")
@Getter
public class Photo {
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;                    //사진 ID

    @Column(name = "ORIGIN_ID", nullable = false)
    private Long originId;          // (조주법, 재료, 피드) ID

    @Column(name = "PHOTO_CATEGORY", nullable = false)
    @Enumerated(EnumType.STRING)
    private PhotoCategory photoCategory; //사진 구분(조주법, 재료, 피드)

    @Column(name = "PHOTO_NAME", nullable = false)
    private String photoName;          //오리지널 이름
    @Column(name = "PHOTO_RENAME", nullable = false)
    private String photoRename;        //변경 후 이름
    @Column(name = "PHOTO_ROOT", nullable = false)
    private String photoRoot;            // 사진 위치

    protected Photo() {}

    public Photo(Long originId, PhotoCategory photoCategory, String photoName, String photoRename, String photoRoot) {
        this.originId = originId;
        this.photoCategory = photoCategory;
        this.photoName = photoName;
        this.photoRename = photoRename;
        this.photoRoot = photoRoot;
    }
}
