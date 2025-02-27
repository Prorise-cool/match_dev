<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="合同编号" prop="contractNumber">
        <el-input
          v-model="queryParams.contractNumber"
          placeholder="请输入合同编号"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="申请编号" prop="applyCode">
        <el-input
          v-model="queryParams.applyCode"
          placeholder="请输入申请编号"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="客户" prop="customId">
       <el-select v-model="queryParams.customId" placeholder="请选择客户" clearable>
        <el-option v-for="item in procurementContractList" :key="item.customerId" :label="item.customName" :value="item.customerId"></el-option>
       </el-select>
      </el-form-item>
      <el-form-item label="供应商" prop="supplierId">
        <el-select v-model="queryParams.supplierId" placeholder="请选择供应商" clearable>
          <el-option v-for="item in procurementContractList" :key="item.supplierId" :label="item.supplierName" :value="item.supplierId"></el-option>
        </el-select>
      </el-form-item>
      <el-form-item label="联系人" prop="linkman">
        <el-input
          v-model="queryParams.linkman"
          placeholder="请输入联系人"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="金额" prop="money">
        <el-input
          v-model="queryParams.money"
          placeholder="请输入金额"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="送货方式" prop="shipMethod">
        <el-input
          v-model="queryParams.shipMethod"
          placeholder="请输入送货方式"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="签订日期">
        <el-date-picker
          v-model="daterangeSigningDate"
          style="width: 240px"
          value-format="yyyy-MM-dd"
          type="daterange"
          range-separator="-"
          start-placeholder="开始日期"
          end-placeholder="结束日期"
        ></el-date-picker>
      </el-form-item>
      <el-form-item label="申请人Id" prop="applyId">
        <el-select v-model="queryParams.applyId" placeholder="请选择申请人" clearable>
        <el-option v-for="item in procurementContractList" :key="item.applyId" :label="item.applicantName" :value="item.applyId"></el-option>
       </el-select>
      </el-form-item>
      <el-form-item label="申请时间">
        <el-date-picker
          v-model="daterangeApplyTime"
          style="width: 240px"
          value-format="yyyy-MM-dd"
          type="daterange"
          range-separator="-"
          start-placeholder="开始日期"
          end-placeholder="结束日期"
        ></el-date-picker>
      </el-form-item>
      <el-form-item label="申请状态" prop="applyStatus">
        <el-select v-model="queryParams.applyStatus" placeholder="请选择申请状态" clearable>
          <el-option
            v-for="dict in dict.type.apply_status"
            :key="dict.value"
            :label="dict.label"
            :value="dict.value"
          />
        </el-select>
      </el-form-item>
      <el-form-item label="审核人id" prop="auditId">
        <el-select v-model="queryParams.auditId" placeholder="请选择审核人" clearable>
          <el-option v-for="item in procurementContractList" :key="item.auditId" :label="item.auditName" :value="item.auditId"></el-option>
        </el-select>
        />
      </el-form-item>
      <el-form-item label="审核时间">
        <el-date-picker
          v-model="daterangeAuditTime"
          style="width: 240px"
          value-format="yyyy-MM-dd"
          type="daterange"
          range-separator="-"
          start-placeholder="开始日期"
          end-placeholder="结束日期"
        ></el-date-picker>
      </el-form-item>
      <el-form-item label="审核状态" prop="auditStatus">
        <el-select v-model="queryParams.auditStatus" placeholder="请选择审核状态" clearable>
          <el-option
            v-for="dict in dict.type.audit_status"
            :key="dict.value"
            :label="dict.label"
            :value="dict.value"
          />
        </el-select>
      </el-form-item>
      <el-form-item>
        <el-button type="primary" icon="el-icon-search" size="mini" @click="handleQuery">搜索</el-button>
        <el-button icon="el-icon-refresh" size="mini" @click="resetQuery">重置</el-button>
      </el-form-item>
    </el-form>

    <el-row :gutter="10" class="mb8">
      <el-col :span="1.5">
        <el-button
          type="primary"
          plain
          icon="el-icon-plus"
          size="mini"
          @click="handleAdd"
          v-hasPermi="['procurementContract:procurementContract:add']"
        >新增</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="success"
          plain
          icon="el-icon-edit"
          size="mini"
          :disabled="single"
          @click="handleUpdate"
          v-hasPermi="['procurementContract:procurementContract:edit']"
        >修改</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="danger"
          plain
          icon="el-icon-delete"
          size="mini"
          :disabled="multiple"
          @click="handleDelete"
          v-hasPermi="['procurementContract:procurementContract:remove']"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['procurementContract:procurementContract:export']"
        >导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="procurementContractList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="编号" align="center" prop="id" />
      <el-table-column label="合同编号" align="center" prop="contractNumber" />
      <el-table-column label="申请编号" align="center" prop="applyCode" />
      <el-table-column label="客户id" align="center" prop="customId" />
      <el-table-column label="供应商id" align="center" prop="supplierId" />
      <el-table-column label="联系人" align="center" prop="linkman" />
      <el-table-column label="金额" align="center" prop="money" />
      <el-table-column label="送货方式" align="center" prop="shipMethod" />
      <el-table-column label="签订日期" align="center" prop="signingDate" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.signingDate, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="申请人Id" align="center" prop="applyId" />
      <el-table-column label="申请时间" align="center" prop="applyTime" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.applyTime, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="申请状态" align="center" prop="applyStatus">
        <template slot-scope="scope">
          <dict-tag :options="dict.type.apply_status" :value="scope.row.applyStatus"/>
        </template>
      </el-table-column>
      <el-table-column label="审核人id" align="center" prop="auditId" />
      <el-table-column label="审核时间" align="center" prop="auditTime" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.auditTime, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="审核状态" align="center" prop="auditStatus">
        <template slot-scope="scope">
          <dict-tag :options="dict.type.audit_status" :value="scope.row.auditStatus"/>
        </template>
      </el-table-column>
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['procurementContract:procurementContract:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['procurementContract:procurementContract:remove']"
          >删除</el-button>
        </template>
      </el-table-column>
    </el-table>
    
    <pagination
      v-show="total>0"
      :total="total"
      :page.sync="queryParams.pageNum"
      :limit.sync="queryParams.pageSize"
      @pagination="getList"
    />

    <!-- 添加或修改供应链SCM-销售管理-采购合同审核对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="合同编号" prop="contractNumber">
          <el-input v-model="form.contractNumber" placeholder="请输入合同编号" />
        </el-form-item>
        <el-form-item label="申请编号" prop="applyCode">
          <el-input v-model="form.applyCode" placeholder="请输入申请编号" />
        </el-form-item>
        <el-form-item label="客户id" prop="customId">
          <el-input v-model="form.customId" placeholder="请输入客户id" />
        </el-form-item>
        <el-form-item label="供应商id" prop="supplierId">
          <el-input v-model="form.supplierId" placeholder="请输入供应商id" />
        </el-form-item>
        <el-form-item label="联系人" prop="linkman">
          <el-input v-model="form.linkman" placeholder="请输入联系人" />
        </el-form-item>
        <el-form-item label="金额" prop="money">
          <el-input v-model="form.money" placeholder="请输入金额" />
        </el-form-item>
        <el-form-item label="送货方式" prop="shipMethod">
          <el-input v-model="form.shipMethod" placeholder="请输入送货方式" />
        </el-form-item>
        <el-form-item label="签订日期" prop="signingDate">
          <el-date-picker clearable
            v-model="form.signingDate"
            type="date"
            value-format="yyyy-MM-dd"
            placeholder="请选择签订日期">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="申请人Id" prop="applyId">
          <el-input v-model="form.applyId" placeholder="请输入申请人Id" />
        </el-form-item>
        <el-form-item label="申请时间" prop="applyTime">
          <el-date-picker clearable
            v-model="form.applyTime"
            type="date"
            value-format="yyyy-MM-dd"
            placeholder="请选择申请时间">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="申请状态" prop="applyStatus">
          <el-select v-model="form.applyStatus" placeholder="请选择申请状态">
            <el-option
              v-for="dict in dict.type.apply_status"
              :key="dict.value"
              :label="dict.label"
              :value="dict.value"
            ></el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="审核人id" prop="auditId">
          <el-input v-model="form.auditId" placeholder="请输入审核人id" />
        </el-form-item>
        <el-form-item label="审核时间" prop="auditTime">
          <el-date-picker clearable
            v-model="form.auditTime"
            type="date"
            value-format="yyyy-MM-dd"
            placeholder="请选择审核时间">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="审核状态" prop="auditStatus">
          <el-select v-model="form.auditStatus" placeholder="请选择审核状态">
            <el-option
              v-for="dict in dict.type.audit_status"
              :key="dict.value"
              :label="dict.label"
              :value="dict.value"
            ></el-option>
          </el-select>
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button type="primary" @click="submitForm">确 定</el-button>
        <el-button @click="cancel">取 消</el-button>
      </div>
    </el-dialog>
  </div>
</template>

<script>
import { listProcurementContract, getProcurementContract, delProcurementContract, addProcurementContract, updateProcurementContract } from "@/api/procurementContract/procurementContract";

export default {
  name: "ProcurementContract",
  dicts: ['apply_status', 'audit_status'],
  data() {
    return {
      // 遮罩层
      loading: true,
      // 选中数组
      ids: [],
      // 非单个禁用
      single: true,
      // 非多个禁用
      multiple: true,
      // 显示搜索条件
      showSearch: true,
      // 总条数
      total: 0,
      // 供应链SCM-销售管理-采购合同审核表格数据
      procurementContractList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 审核状态时间范围
      daterangeSigningDate: [],
      // 审核状态时间范围
      daterangeApplyTime: [],
      // 审核状态时间范围
      daterangeAuditTime: [],
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        contractNumber: null,
        applyCode: null,
        customId: null,
        supplierId: null,
        linkman: null,
        money: null,
        shipMethod: null,
        signingDate: null,
        applyId: null,
        applyTime: null,
        applyStatus: null,
        auditId: null,
        auditTime: null,
        auditStatus: null
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
      }
    };
  },
  created() {
    this.getList();
  },
  methods: {
    /** 查询供应链SCM-销售管理-采购合同审核列表 */
    getList() {
      this.loading = true;
      this.queryParams.params = {};
      if (null != this.daterangeSigningDate && '' != this.daterangeSigningDate) {
        this.queryParams.params["beginSigningDate"] = this.daterangeSigningDate[0];
        this.queryParams.params["endSigningDate"] = this.daterangeSigningDate[1];
      }
      if (null != this.daterangeApplyTime && '' != this.daterangeApplyTime) {
        this.queryParams.params["beginApplyTime"] = this.daterangeApplyTime[0];
        this.queryParams.params["endApplyTime"] = this.daterangeApplyTime[1];
      }
      if (null != this.daterangeAuditTime && '' != this.daterangeAuditTime) {
        this.queryParams.params["beginAuditTime"] = this.daterangeAuditTime[0];
        this.queryParams.params["endAuditTime"] = this.daterangeAuditTime[1];
      }
      listProcurementContract(this.queryParams).then(response => {
        this.procurementContractList = response.rows;
        console.log(this.procurementContractList);
        this.total = response.total;
        this.loading = false;
      });
    },
    // 取消按钮
    cancel() {
      this.open = false;
      this.reset();
    },
    // 表单重置
    reset() {
      this.form = {
        id: null,
        contractNumber: null,
        applyCode: null,
        customId: null,
        supplierId: null,
        linkman: null,
        money: null,
        shipMethod: null,
        signingDate: null,
        applyId: null,
        applyTime: null,
        applyStatus: null,
        auditId: null,
        auditTime: null,
        auditStatus: null
      };
      this.resetForm("form");
    },
    /** 搜索按钮操作 */
    handleQuery() {
      this.queryParams.pageNum = 1;
      this.getList();
    },
    /** 重置按钮操作 */
    resetQuery() {
      this.daterangeSigningDate = [];
      this.daterangeApplyTime = [];
      this.daterangeAuditTime = [];
      this.resetForm("queryForm");
      this.handleQuery();
    },
    // 多选框选中数据
    handleSelectionChange(selection) {
      this.ids = selection.map(item => item.id)
      this.single = selection.length!==1
      this.multiple = !selection.length
    },
    /** 新增按钮操作 */
    handleAdd() {
      this.reset();
      this.open = true;
      this.title = "添加供应链SCM-销售管理-采购合同审核";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const id = row.id || this.ids
      getProcurementContract(id).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改供应链SCM-销售管理-采购合同审核";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.id != null) {
            updateProcurementContract(this.form).then(response => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addProcurementContract(this.form).then(response => {
              this.$modal.msgSuccess("新增成功");
              this.open = false;
              this.getList();
            });
          }
        }
      });
    },
    /** 删除按钮操作 */
    handleDelete(row) {
      const ids = row.id || this.ids;
      this.$modal.confirm('是否确认删除供应链SCM-销售管理-采购合同审核编号为"' + ids + '"的数据项？').then(function() {
        return delProcurementContract(ids);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("删除成功");
      }).catch(() => {});
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('procurementContract/procurementContract/export', {
        ...this.queryParams
      }, `procurementContract_${new Date().getTime()}.xlsx`)
    }
  }
};
</script>
