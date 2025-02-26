package com.zhonghui.carbonReport.domain;

import com.zhonghui.common.annotation.Excel;
import com.zhonghui.common.core.domain.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.math.BigDecimal;

/**
 * 采购合同报表对象 view_scm_purchasing_contract
 * 
 * @author zhonghui
 * @date 2022-05-28
 */
@ApiModel("采购合同报表对象")
public class ViewScmPurchasingContract extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 合同id */
    @Excel(name = "合同id")
    @ApiModelProperty("合同id")
    private Long contractId;

    /** 合同编号 */
    @Excel(name = "合同编号")
    @ApiModelProperty("合同编号")
    private String contractNo;

    /** 申请id */
    @Excel(name = "申请id")
    @ApiModelProperty("申请id")
    private Long applicationId;

    /** 供应商id */
    @Excel(name = "供应商id")
    @ApiModelProperty("供应商id")
    private Long saleSupplierId;

    /** 供应商名称 */
    @Excel(name = "供应商名称")
    @ApiModelProperty("供应商名称")
    private String supplierName;

    /** 申请单号 */
    @Excel(name = "申请单号")
    @ApiModelProperty("申请单号")
    private String applicationNo;

    /** 合同金额 */
    @Excel(name = "合同金额")
    @ApiModelProperty("合同金额")
    private BigDecimal contractAmount;

    /** 合同年份 */
    @Excel(name = "合同年份")
    @ApiModelProperty("合同年份")
    private String contractYear;

    /** 合同季度 */
    @Excel(name = "合同季度")
    @ApiModelProperty("合同季度")
    private String contractQuarter;

    /** 合同月份 */
    @Excel(name = "合同月份")
    @ApiModelProperty("合同月份")
    private String contractMonth;

    /** 合同年月 */
    @Excel(name = "合同年月")
    @ApiModelProperty("合同年月")
    private String contractYearMonth;

    /** 合同日期 */
    @Excel(name = "合同日期")
    @ApiModelProperty("合同日期")
    private String contractDate;

    public void setContractId(Long contractId) 
    {
        this.contractId = contractId;
    }

    public Long getContractId() 
    {
        return contractId;
    }
    public void setContractNo(String contractNo) 
    {
        this.contractNo = contractNo;
    }

    public String getContractNo() 
    {
        return contractNo;
    }
    public void setApplicationId(Long applicationId) 
    {
        this.applicationId = applicationId;
    }

    public Long getApplicationId() 
    {
        return applicationId;
    }
    public void setSaleSupplierId(Long saleSupplierId) 
    {
        this.saleSupplierId = saleSupplierId;
    }

    public Long getSaleSupplierId() 
    {
        return saleSupplierId;
    }
    public void setSupplierName(String supplierName) 
    {
        this.supplierName = supplierName;
    }

    public String getSupplierName() 
    {
        return supplierName;
    }
    public void setApplicationNo(String applicationNo) 
    {
        this.applicationNo = applicationNo;
    }

    public String getApplicationNo() 
    {
        return applicationNo;
    }
    public void setContractAmount(BigDecimal contractAmount) 
    {
        this.contractAmount = contractAmount;
    }

    public BigDecimal getContractAmount() 
    {
        return contractAmount;
    }
    public void setContractYear(String contractYear) 
    {
        this.contractYear = contractYear;
    }

    public String getContractYear() 
    {
        return contractYear;
    }
    public void setContractQuarter(String contractQuarter)
    {
        this.contractQuarter = contractQuarter;
    }

    public String getContractQuarter()
    {
        return contractQuarter;
    }
    public void setContractMonth(String contractMonth)
    {
        this.contractMonth = contractMonth;
    }

    public String getContractMonth()
    {
        return contractMonth;
    }
    public void setContractYearMonth(String contractYearMonth) 
    {
        this.contractYearMonth = contractYearMonth;
    }

    public String getContractYearMonth() 
    {
        return contractYearMonth;
    }
    public void setContractDate(String contractDate) 
    {
        this.contractDate = contractDate;
    }

    public String getContractDate() 
    {
        return contractDate;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
            .append("contractId", getContractId())
            .append("contractNo", getContractNo())
            .append("applicationId", getApplicationId())
            .append("saleSupplierId", getSaleSupplierId())
            .append("supplierName", getSupplierName())
            .append("applicationNo", getApplicationNo())
            .append("contractAmount", getContractAmount())
            .append("contractYear", getContractYear())
            .append("contractQuarter", getContractQuarter())
            .append("contractMonth", getContractMonth())
            .append("contractYearMonth", getContractYearMonth())
            .append("contractDate", getContractDate())
            .toString();
    }
}
