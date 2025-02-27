package com.zhonghui.wms.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.zhonghui.common.annotation.Excel;
import com.zhonghui.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 智能仓储WMS-出库申请对象 wms_outbound_application
 * 
 * @author zhonghui
 * @date 2025-02-26
 */
public class WmsOutboundApplication extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 编号 */
    @Excel(name = "编号")
    private Long id;

    /** 单据号 */
    @Excel(name = "单据号")
    private String documentNo;

    /** 关联单据号id */
    @Excel(name = "关联单据号id")
    private Long documentNoId;

    /** 业务类型: */
    @Excel(name = "业务类型:")
    private Integer businessType;

    /** 客户编号 */
    private Long customerId;

    /** 单据状态：0未分拣1已分拣2已盘点3已发货 */
    private Integer documentStatus;

    /** 合同类型: */
    @Excel(name = "合同类型:")
    private Integer contractType;

    /** 申请类型: */
    @Excel(name = "申请类型:")
    private Integer applicationType;

    /** 申请人 */
    @Excel(name = "申请人")
    private Long applicant;

    /** 申请日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "申请日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date applicationDate;

    /** 申请状态 */
    @Excel(name = "申请状态")
    private Integer applicationStatus;

    /** 审核人 */
    @Excel(name = "审核人")
    private Long approved;

    /** 审核日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "审核日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date approvedDate;

    /** 审核状态 */
    @Excel(name = "审核状态")
    private Integer approvedStatus;


    /** 客户 */
    @Excel(name = "客户")
    private String linkman;

    /** 客户名称 */
    @Excel(name = "客户")
    private String applicantName;




    /** 审核意见 */
    private String approvedComments;

    public String getApplicantName() {
        return applicantName;
    }

    public void setApplicantName(String applicantName) {
        this.applicantName = applicantName;
    }

    public String getLinkman() {
        return linkman;
    }

    public void setLinkman(String linkman) {
        this.linkman = linkman;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setDocumentNo(String documentNo) 
    {
        this.documentNo = documentNo;
    }

    public String getDocumentNo() 
    {
        return documentNo;
    }
    public void setDocumentNoId(Long documentNoId) 
    {
        this.documentNoId = documentNoId;
    }

    public Long getDocumentNoId() 
    {
        return documentNoId;
    }
    public void setBusinessType(Integer businessType) 
    {
        this.businessType = businessType;
    }

    public Integer getBusinessType() 
    {
        return businessType;
    }
    public void setCustomerId(Long customerId) 
    {
        this.customerId = customerId;
    }

    public Long getCustomerId() 
    {
        return customerId;
    }
    public void setDocumentStatus(Integer documentStatus) 
    {
        this.documentStatus = documentStatus;
    }

    public Integer getDocumentStatus() 
    {
        return documentStatus;
    }
    public void setContractType(Integer contractType) 
    {
        this.contractType = contractType;
    }

    public Integer getContractType() 
    {
        return contractType;
    }
    public void setApplicationType(Integer applicationType) 
    {
        this.applicationType = applicationType;
    }

    public Integer getApplicationType() 
    {
        return applicationType;
    }
    public void setApplicant(Long applicant) 
    {
        this.applicant = applicant;
    }

    public Long getApplicant() 
    {
        return applicant;
    }
    public void setApplicationDate(Date applicationDate) 
    {
        this.applicationDate = applicationDate;
    }

    public Date getApplicationDate() 
    {
        return applicationDate;
    }
    public void setApplicationStatus(Integer applicationStatus) 
    {
        this.applicationStatus = applicationStatus;
    }

    public Integer getApplicationStatus() 
    {
        return applicationStatus;
    }
    public void setApproved(Long approved) 
    {
        this.approved = approved;
    }

    public Long getApproved() 
    {
        return approved;
    }
    public void setApprovedDate(Date approvedDate) 
    {
        this.approvedDate = approvedDate;
    }

    public Date getApprovedDate() 
    {
        return approvedDate;
    }
    public void setApprovedStatus(Integer approvedStatus) 
    {
        this.approvedStatus = approvedStatus;
    }

    public Integer getApprovedStatus() 
    {
        return approvedStatus;
    }
    public void setApprovedComments(String approvedComments) 
    {
        this.approvedComments = approvedComments;
    }

    public String getApprovedComments() 
    {
        return approvedComments;
    }

    @Override
    public String toString() {
        return "WmsOutboundApplication{" +
                "id=" + id +
                ", documentNo='" + documentNo + '\'' +
                ", documentNoId=" + documentNoId +
                ", businessType=" + businessType +
                ", customerId=" + customerId +
                ", documentStatus=" + documentStatus +
                ", contractType=" + contractType +
                ", applicationType=" + applicationType +
                ", applicant=" + applicant +
                ", applicationDate=" + applicationDate +
                ", applicationStatus=" + applicationStatus +
                ", approved=" + approved +
                ", approvedDate=" + approvedDate +
                ", approvedStatus=" + approvedStatus +
                ", linkman='" + linkman + '\'' +
                ", approvedComments='" + approvedComments + '\'' +
                '}';
    }
}
