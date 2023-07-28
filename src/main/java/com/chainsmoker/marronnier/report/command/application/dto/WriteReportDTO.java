package com.chainsmoker.marronnier.report.command.application.dto;

public class WriteReportDTO {

    private long id;                // 피드 신고번호
    private String reportReason;    // 신고 사유
    private String reportContent;   // 신고 추가 사유
    private boolean isApproval;     // 승인 여부
    private long reporterId;        // 신고자 번호
    private long originId;          // 피드 번호

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
        return "WriteReportDTO{" +
                "id=" + id +
                ", reportReason='" + reportReason + '\'' +
                ", reportContent='" + reportContent + '\'' +
                ", isApproval=" + isApproval +
                ", reporterId=" + reporterId +
                ", originId=" + originId +
                '}';
    }
}
