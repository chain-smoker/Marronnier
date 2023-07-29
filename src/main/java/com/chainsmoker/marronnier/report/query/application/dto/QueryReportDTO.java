package com.chainsmoker.marronnier.report.query.application.dto;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class QueryReportDTO {
    private long id;                // 피드 신고번호
    private String reportReason;    // 신고 사유
    private String reportContent;   // 신고 추가 사유
    private boolean isApproval;     // 승인 여부
    private long reporterId;        // 신고자 번호
    private long originId;           // 피드 번호

    public QueryReportDTO() {
    }

    public QueryReportDTO(long id, String reportReason, String reportContent, boolean isApproval, long reporterId, long originId) {
        this.id = id;
        this.reportReason = reportReason;
        this.reportContent = reportContent;
        this.isApproval = isApproval;
        this.reporterId = reporterId;
        this.originId = originId;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getReportReason() {
        return reportReason;
    }

    public void setReportReason(String reportReason) {
        this.reportReason = reportReason;
    }

    public String getReportContent() {
        return reportContent;
    }

    public void setReportContent(String reportContent) {
        this.reportContent = reportContent;
    }

    public boolean isApproval() {
        return isApproval;
    }

    public void setApproval(boolean approval) {
        isApproval = approval;
    }

    public long getReporterId() {
        return reporterId;
    }

    public void setReporterId(long reporterId) {
        this.reporterId = reporterId;
    }

    public long getOriginId() {
        return originId;
    }

    public void setOriginId(long originId) {
        this.originId = originId;
    }

    @Override
    public String toString() {
        return "QueryReportDTO{" +
                "id=" + id +
                ", reportReason='" + reportReason + '\'' +
                ", reportContent='" + reportContent + '\'' +
                ", isApproval=" + isApproval +
                ", reporterId=" + reporterId +
                ", originId=" + originId +
                '}';
    }
}
