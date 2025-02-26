package com.zhonghui.procurement.domain.vo;

import com.zhonghui.procurement.domain.ProcurementMark;
import com.zhonghui.procurement.domain.ProcurementSnapshotInformation;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * 采购—我的投标表
 *
 * @TableName procurement_have_bid
 */
public class ProcurementHaveBidVo implements Serializable {

    /**
     * id
     */
    @ApiModelProperty("id")
    private Integer id;
    /**
     * 标id
     */
    @ApiModelProperty("标id")
    private Integer bidId;
    /**
     * 企业资料提交id
     */
    @ApiModelProperty("企业资料提交id")
    private int snapshotInformation;
    /**
     * 用户id
     */
    @ApiModelProperty("用户id")
    private Integer userId;
    /**
     * 提交资料
     */
    @ApiModelProperty("提交资料")
    private String information;
    /**
     * 标数据
     */
    @ApiModelProperty("标数据")
    private ProcurementMark procurementMark;
    @ApiModelProperty("企业资料")
    private ProcurementSnapshotInformation procurementSnapshotInformation;

    public ProcurementSnapshotInformation getProcurementSnapshotInformation() {
        return procurementSnapshotInformation;
    }

    public void setProcurementSnapshotInformation(ProcurementSnapshotInformation procurementSnapshotInformation) {
        this.procurementSnapshotInformation = procurementSnapshotInformation;
    }

    public String getInformation() {
        return information;
    }

    public void setInformation(String information) {
        this.information = information;
    }

    public ProcurementMark getProcurementMark() {
        return procurementMark;
    }

    public void setProcurementMark(ProcurementMark procurementMark) {
        this.procurementMark = procurementMark;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getBidId() {
        return bidId;
    }

    public void setBidId(Integer bidId) {
        this.bidId = bidId;
    }

    public int getSnapshotInformation() {
        return snapshotInformation;
    }

    public void setSnapshotInformation(int snapshotInformation) {
        this.snapshotInformation = snapshotInformation;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "ProcurementHaveBidVo{" +
                "id=" + id +
                ", bidId=" + bidId +
                ", snapshotInformation=" + snapshotInformation +
                ", userId=" + userId +
                ", information='" + information + '\'' +
                ", procurementMark=" + procurementMark +
                '}';
    }
}
