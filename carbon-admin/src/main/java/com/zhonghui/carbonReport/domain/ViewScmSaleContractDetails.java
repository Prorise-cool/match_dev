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
 * 销售合同明细报表对象 view_scm_sale_contract_details
 * 
 * @author zhonghui
 * @date 2022-05-28
 */
@ApiModel("销售合同明细")
public class ViewScmSaleContractDetails extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 物料名称 */
    @ApiModelProperty("物料名称")
    @Excel(name = "物料名称")
    private String materialName;

    /** 型号 */
    @ApiModelProperty("型号")
    @Excel(name = "型号")
    private String materialModel;

    /** 规格 */
    @ApiModelProperty("规格")
    @Excel(name = "规格")
    private String materialSpecifications;

    /** 单位 */
    @ApiModelProperty("单位")
    @Excel(name = "单位")
    private String materialUnit;

    /** 单价 */
    @ApiModelProperty("单价")
    @Excel(name = "单价")
    private BigDecimal materialPrice;

    /** 销售合同id */
    @ApiModelProperty("销售合同id")
    @Excel(name = "销售合同id")
    private Long contractId;

    /** 物料id */
    @ApiModelProperty("物料id")
    @Excel(name = "物料id")
    private Long materialId;

    /** 金额 */
    @ApiModelProperty("金额")
    @Excel(name = "金额")
    private BigDecimal amount;

    /** 订货数量 */
    @ApiModelProperty("订货数量")
    @Excel(name = "订货数量")
    private BigDecimal orderQuantity;

    /** 客户名称 */
    @ApiModelProperty("客户名称")
    @Excel(name = "客户名称")
    private String customName;

    /** 合同编号 */
    @ApiModelProperty("合同编号")
    @Excel(name = "合同编号")
    private String contractNumber;

    /** 客户id */
    @ApiModelProperty("客户id")
    @Excel(name = "客户id")
    private Long customId;

    /** 销售订单id */
    @ApiModelProperty("销售订单id")
    @Excel(name = "销售订单id")
    private Long orderId;

    /** 订单编号 */
    @ApiModelProperty("订单编号")
    @Excel(name = "订单编号")
    private String orderNo;

    /** 签订日期 */
    @ApiModelProperty("签订日期")
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "签订日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date signingDate;

    /** 金额合计 */
    @ApiModelProperty("金额合计")
    @Excel(name = "金额合计")
    private BigDecimal totalAmount;

    /** 退款金额 */
    @ApiModelProperty("退款金额")
    private BigDecimal returnTotal = new BigDecimal("0");

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
    public void setContractId(Long contractId) 
    {
        this.contractId = contractId;
    }

    public Long getContractId() 
    {
        return contractId;
    }
    public void setMaterialId(Long materialId) 
    {
        this.materialId = materialId;
    }

    public Long getMaterialId() 
    {
        return materialId;
    }
    public void setAmount(BigDecimal amount) 
    {
        this.amount = amount;
    }

    public BigDecimal getAmount() 
    {
        return amount;
    }
    public void setOrderQuantity(BigDecimal orderQuantity) 
    {
        this.orderQuantity = orderQuantity;
    }

    public BigDecimal getOrderQuantity() 
    {
        return orderQuantity;
    }
    public void setCustomName(String customName) 
    {
        this.customName = customName;
    }

    public String getCustomName() 
    {
        return customName;
    }
    public void setContractNumber(String contractNumber) 
    {
        this.contractNumber = contractNumber;
    }

    public String getContractNumber() 
    {
        return contractNumber;
    }
    public void setCustomId(Long customId) 
    {
        this.customId = customId;
    }

    public Long getCustomId() 
    {
        return customId;
    }
    public void setOrderId(Long orderId) 
    {
        this.orderId = orderId;
    }

    public Long getOrderId() 
    {
        return orderId;
    }
    public void setOrderNo(String orderNo) 
    {
        this.orderNo = orderNo;
    }

    public String getOrderNo() 
    {
        return orderNo;
    }
    public void setSigningDate(Date signingDate) 
    {
        this.signingDate = signingDate;
    }

    public Date getSigningDate() 
    {
        return signingDate;
    }
    public void setTotalAmount(BigDecimal totalAmount) 
    {
        this.totalAmount = totalAmount;
    }

    public BigDecimal getTotalAmount() 
    {
        return totalAmount;
    }
    public BigDecimal getReturnTotal() {
        return returnTotal;
    }

    public void setReturnTotal(BigDecimal returnTotal) {
        this.returnTotal = returnTotal;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
            .append("materialName", getMaterialName())
            .append("materialModel", getMaterialModel())
            .append("materialSpecifications", getMaterialSpecifications())
            .append("materialUnit", getMaterialUnit())
            .append("materialPrice", getMaterialPrice())
            .append("contractId", getContractId())
            .append("materialId", getMaterialId())
            .append("amount", getAmount())
            .append("orderQuantity", getOrderQuantity())
            .append("customName", getCustomName())
            .append("contractNumber", getContractNumber())
            .append("customId", getCustomId())
            .append("orderId", getOrderId())
            .append("orderNo", getOrderNo())
            .append("signingDate", getSigningDate())
            .append("totalAmount", getTotalAmount())
            .toString();
    }
}
