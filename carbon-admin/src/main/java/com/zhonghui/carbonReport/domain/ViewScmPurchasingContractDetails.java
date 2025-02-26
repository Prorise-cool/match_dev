package com.zhonghui.carbonReport.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.zhonghui.common.annotation.Excel;
import com.zhonghui.common.core.domain.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 采购合同明细报表对象 view_scm_purchasing_contract_details
 * 
 * @author zhonghui
 * @date 2022-05-28
 */
@ApiModel("采购退货统计对象")
public class ViewScmPurchasingContractDetails extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 合同Id */
    @Excel(name = "合同Id")
    @ApiModelProperty("合同Id")
    private Long purchasingContractId;

    /** 物料id */
    @Excel(name = "物料id")
    @ApiModelProperty("物料id")
    private Long materialId;

    /** 采购数量 */
    @Excel(name = "采购数量")
    @ApiModelProperty("采购数量")
    private Long purchaseQuantity;

    /** 金额 */
    @Excel(name = "金额")
    @ApiModelProperty("金额")
    private BigDecimal amount;

    /** 物料编码 */
    @Excel(name = "物料编码")
    @ApiModelProperty("物料编码")
    private String materialCode;

    /** 物料名称 */
    @Excel(name = "物料名称")
    @ApiModelProperty("物料名称")
    private String materialName;

    /** 型号 */
    @Excel(name = "型号")
    @ApiModelProperty("型号")
    private String materialModel;

    /** 规格 */
    @Excel(name = "规格")
    @ApiModelProperty("规格")
    private String materialSpecifications;

    /** 单位 */
    @Excel(name = "单位")
    @ApiModelProperty("单位")
    private String materialUnit;

    /** 单价 */
    @Excel(name = "单价")
    @ApiModelProperty("单价")
    private BigDecimal materialPrice;

    /** 合同编号 */
    @Excel(name = "合同编号")
    @ApiModelProperty("合同编号")
    private String contractNo;

    /** 供应商id */
    @Excel(name = "供应商id")
    @ApiModelProperty("供应商id")
    private Long saleSupplierId;

    /** 签约日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @ApiModelProperty("签约日期")
    @Excel(name = "签约日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date signingDate;

    /** 供应商名称 */
    @Excel(name = "供应商名称")
    @ApiModelProperty("供应商名称")
    private String supplierName;

    public void setPurchasingContractId(Long purchasingContractId) 
    {
        this.purchasingContractId = purchasingContractId;
    }

    public Long getPurchasingContractId() 
    {
        return purchasingContractId;
    }
    public void setMaterialId(Long materialId) 
    {
        this.materialId = materialId;
    }

    public Long getMaterialId() 
    {
        return materialId;
    }
    public void setPurchaseQuantity(Long purchaseQuantity) 
    {
        this.purchaseQuantity = purchaseQuantity;
    }

    public Long getPurchaseQuantity() 
    {
        return purchaseQuantity;
    }
    public void setAmount(BigDecimal amount) 
    {
        this.amount = amount;
    }

    public BigDecimal getAmount() 
    {
        return amount;
    }
    public void setMaterialCode(String materialCode) 
    {
        this.materialCode = materialCode;
    }

    public String getMaterialCode() 
    {
        return materialCode;
    }
    public void setMaterialName(String materialName) 
    {
        this.materialName = materialName;
    }

    public String getMaterialName() 
    {
        return materialName;
    }
    public void setMaterialModel(String materialModel) 
    {
        this.materialModel = materialModel;
    }

    public String getMaterialModel() 
    {
        return materialModel;
    }
    public void setMaterialSpecifications(String materialSpecifications) 
    {
        this.materialSpecifications = materialSpecifications;
    }

    public String getMaterialSpecifications() 
    {
        return materialSpecifications;
    }
    public void setMaterialUnit(String materialUnit) 
    {
        this.materialUnit = materialUnit;
    }

    public String getMaterialUnit() 
    {
        return materialUnit;
    }
    public void setMaterialPrice(BigDecimal materialPrice) 
    {
        this.materialPrice = materialPrice;
    }

    public BigDecimal getMaterialPrice() 
    {
        return materialPrice;
    }
    public void setContractNo(String contractNo) 
    {
        this.contractNo = contractNo;
    }

    public String getContractNo() 
    {
        return contractNo;
    }
    public void setSaleSupplierId(Long saleSupplierId) 
    {
        this.saleSupplierId = saleSupplierId;
    }

    public Long getSaleSupplierId() 
    {
        return saleSupplierId;
    }
    public void setSigningDate(Date signingDate) 
    {
        this.signingDate = signingDate;
    }

    public Date getSigningDate() 
    {
        return signingDate;
    }
    public void setSupplierName(String supplierName) 
    {
        this.supplierName = supplierName;
    }

    public String getSupplierName() 
    {
        return supplierName;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
            .append("purchasingContractId", getPurchasingContractId())
            .append("materialId", getMaterialId())
            .append("purchaseQuantity", getPurchaseQuantity())
            .append("amount", getAmount())
            .append("materialCode", getMaterialCode())
            .append("materialName", getMaterialName())
            .append("materialModel", getMaterialModel())
            .append("materialSpecifications", getMaterialSpecifications())
            .append("materialUnit", getMaterialUnit())
            .append("materialPrice", getMaterialPrice())
            .append("contractNo", getContractNo())
            .append("saleSupplierId", getSaleSupplierId())
            .append("signingDate", getSigningDate())
            .append("supplierName", getSupplierName())
            .toString();
    }
}
