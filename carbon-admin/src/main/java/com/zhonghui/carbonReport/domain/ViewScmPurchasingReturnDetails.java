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
 * 采购退货统计对象 view_scm_purchasing_return_details
 * 
 * @author zhonghui
 * @date 2022-05-28
 */
@ApiModel("采购退货统计对象")
public class ViewScmPurchasingReturnDetails extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 物料id */
    @Excel(name = "物料id")
    @ApiModelProperty("物料id")
    private Long materialId;

    /** 退货单号 */
    @Excel(name = "退货单号")
    @ApiModelProperty("退货单号")
    private String returnNo;

    /** 生产批号 */
    @Excel(name = "生产批号")
    @ApiModelProperty("生产批号")
    private String batchNumber;

    /** 需求数量 */
    @Excel(name = "需求数量")
    @ApiModelProperty("需求数量")
    private Long demandedQuantity;

    /** 到货数量 */
    @Excel(name = "到货数量")
    @ApiModelProperty("到货数量")
    private Long arrivalQuantity;

    /** 退货数量 */
    @Excel(name = "退货数量")
    @ApiModelProperty("退货数量")
    private Long returnQuantity;

    /** 退货日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "退货日期", width = 30, dateFormat = "yyyy-MM-dd")
    @ApiModelProperty("退货日期")
    private Date returnDate;

    /** 供应商名称 */
    @Excel(name = "供应商名称")
    @ApiModelProperty("供应商名称")
    private String supplierName;

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

    /** 供应商id */
    @Excel(name = "供应商id")
    @ApiModelProperty("供应商id")
    private Long saleSupplierId;

    public void setMaterialId(Long materialId) 
    {
        this.materialId = materialId;
    }

    public Long getMaterialId() 
    {
        return materialId;
    }
    public void setReturnNo(String returnNo) 
    {
        this.returnNo = returnNo;
    }

    public String getReturnNo() 
    {
        return returnNo;
    }
    public void setBatchNumber(String batchNumber) 
    {
        this.batchNumber = batchNumber;
    }

    public String getBatchNumber() 
    {
        return batchNumber;
    }
    public void setDemandedQuantity(Long demandedQuantity) 
    {
        this.demandedQuantity = demandedQuantity;
    }

    public Long getDemandedQuantity() 
    {
        return demandedQuantity;
    }
    public void setArrivalQuantity(Long arrivalQuantity) 
    {
        this.arrivalQuantity = arrivalQuantity;
    }

    public Long getArrivalQuantity() 
    {
        return arrivalQuantity;
    }
    public void setReturnQuantity(Long returnQuantity) 
    {
        this.returnQuantity = returnQuantity;
    }

    public Long getReturnQuantity() 
    {
        return returnQuantity;
    }
    public void setReturnDate(Date returnDate) 
    {
        this.returnDate = returnDate;
    }

    public Date getReturnDate() 
    {
        return returnDate;
    }
    public void setSupplierName(String supplierName) 
    {
        this.supplierName = supplierName;
    }

    public String getSupplierName() 
    {
        return supplierName;
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
    public void setSaleSupplierId(Long saleSupplierId) 
    {
        this.saleSupplierId = saleSupplierId;
    }

    public Long getSaleSupplierId() 
    {
        return saleSupplierId;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
            .append("materialId", getMaterialId())
            .append("returnNo", getReturnNo())
            .append("batchNumber", getBatchNumber())
            .append("demandedQuantity", getDemandedQuantity())
            .append("arrivalQuantity", getArrivalQuantity())
            .append("returnQuantity", getReturnQuantity())
            .append("returnDate", getReturnDate())
            .append("supplierName", getSupplierName())
            .append("materialCode", getMaterialCode())
            .append("materialName", getMaterialName())
            .append("materialModel", getMaterialModel())
            .append("materialSpecifications", getMaterialSpecifications())
            .append("materialUnit", getMaterialUnit())
            .append("materialPrice", getMaterialPrice())
            .append("saleSupplierId", getSaleSupplierId())
            .toString();
    }
}
