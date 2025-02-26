package com.zhonghui.carbonReport.domain;

import com.zhonghui.common.annotation.Excel;
import com.zhonghui.common.core.domain.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 销售发货退货明细报表对象 view_scm_sale_delivery_details
 * 
 * @author zhonghui
 * @date 2022-05-25
 */
@ApiModel("销售发货退货明细报表对象")
public class ViewScmSaleDeliveryDetails extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 销售退货id */
    @Excel(name = "销售退货id")
    @ApiModelProperty("销售退货id")
    private Long deliveryId;

    /** 物料id */
    @Excel(name = "物料id")
    @ApiModelProperty("物料id")
    private Long materialId;

    /** 退货数量 */
    @Excel(name = "退货数量")
    @ApiModelProperty("退货数量")
    private Long returnNum;

    /** 发货数量 */
    @Excel(name = "发货数量")
    @ApiModelProperty("发货数量")
    private Long deliveryNum;

    /** 客户名称 */
    @Excel(name = "客户名称")
    @ApiModelProperty("客户名称")
    private String customName;

    /** 客户id */
    @Excel(name = "客户id")
    @ApiModelProperty("客户id")
    private Long customId;

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

    /** 合同编号 */
    @Excel(name = "合同编号")
    @ApiModelProperty("合同编号")
    private String contractNumber;

    public void setDeliveryId(Long deliveryId) 
    {
        this.deliveryId = deliveryId;
    }

    public Long getDeliveryId() 
    {
        return deliveryId;
    }
    public void setMaterialId(Long materialId) 
    {
        this.materialId = materialId;
    }

    public Long getMaterialId() 
    {
        return materialId;
    }
    public void setReturnNum(Long returnNum) 
    {
        this.returnNum = returnNum;
    }

    public Long getReturnNum() 
    {
        return returnNum;
    }
    public void setDeliveryNum(Long deliveryNum) 
    {
        this.deliveryNum = deliveryNum;
    }

    public Long getDeliveryNum() 
    {
        return deliveryNum;
    }
    public void setCustomName(String customName) 
    {
        this.customName = customName;
    }

    public String getCustomName() 
    {
        return customName;
    }
    public void setCustomId(Long customId) 
    {
        this.customId = customId;
    }

    public Long getCustomId() 
    {
        return customId;
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
    public void setContractNumber(String contractNumber) 
    {
        this.contractNumber = contractNumber;
    }

    public String getContractNumber() 
    {
        return contractNumber;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
            .append("deliveryId", getDeliveryId())
            .append("materialId", getMaterialId())
            .append("returnNum", getReturnNum())
            .append("deliveryNum", getDeliveryNum())
            .append("customName", getCustomName())
            .append("customId", getCustomId())
            .append("materialCode", getMaterialCode())
            .append("materialName", getMaterialName())
            .append("materialModel", getMaterialModel())
            .append("materialSpecifications", getMaterialSpecifications())
            .append("materialUnit", getMaterialUnit())
            .append("contractNumber", getContractNumber())
            .toString();
    }
}
