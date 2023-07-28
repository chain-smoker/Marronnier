package com.chainsmoker.marronnier.report.command.domain.aggregate.entity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Table(name = "REPORT_TB")
public class Report {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;                // 피드 신고번호

    @Column(name = "report_reason", columnDefinition = "TEXT")
    private String reportReason;    // 신고 사유

    @Column(name = "report_content", columnDefinition = "TEXT")
    private String reportContent;   // 신고 추가 사유

    @Column(name = "is_approval")
    private boolean isApproval;     // 승인 여부

    @Column(name = "reporter_id", nullable = false)
    private long reporterId;        // 신고자 번호

    @Column(name = "origin_id", nullable = false)
    private long originId;           // 피드 번호

    public Report(String reportReason, String reportContent, boolean isApproval, long reporterId, long originId) {
        this.reportReason = reportReason;
        this.reportContent = reportContent;
        this.isApproval = isApproval;
        this.reporterId = reporterId;
        this.originId = originId;
    }
}
