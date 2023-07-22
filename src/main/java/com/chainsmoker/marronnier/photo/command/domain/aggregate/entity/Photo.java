package com.chainsmoker.marronnier.photo.command.domain.aggregate.entity;

import com.chainsmoker.marronnier.photo.command.domain.aggregate.entity.EnumType.PhotoCategory;
import lombok.Getter;

import javax.persistence.*;

@Entity
@Table(name = "PHOTO_TB")
@Getter
public class Photo {
//    @Id
//    @Column(name = "PHOTO_ID")
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private long photoId;               //사진 ID

    @EmbeddedId
    private PhotoCompositeKey photoInfo;

    @Column(name = "PHOTO_NAME", nullable = false)
    private String photoName;          //오리지널 이름
    @Column(name = "PHOTO_RENAME", nullable = false)
    private String photoRename;        //변경 후 이름
    @Column(name = "PHOTO_ROOT", nullable = false)
    private String photoRoot;            // 사진 위치

    protected Photo() {}
    public Photo(PhotoCompositeKey photoInfo, String photoName, String photoRename, String photoRoot) {
        this.photoInfo = photoInfo;
        this.photoName = photoName;
        this.photoRename = photoRename;
        this.photoRoot = photoRoot;
    }
}
