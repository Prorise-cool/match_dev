<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="单据号" prop="documentNo">
        <el-input
          v-model="queryParams.documentNo"
          placeholder="请输入单据号"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="关联单据号id" prop="documentNoId">
        <el-input
          v-model="queryParams.documentNoId"
          placeholder="请输入关联单据号id"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="业务类型:" prop="businessType">
        <el-select v-model="queryParams.businessType" placeholder="请选择业务类型:" clearable>
          <el-option
            v-for="dict in dict.type.business_type"
            :key="dict.value"
            :label="dict.label"
            :value="dict.value"
          />
        </el-select>
      </el-form-item>
      <el-form-item label="客户" prop="customerId">
        <el-select v-model="queryParams.customerId" placeholder="请选择客户" clearable>
          <el-option v-for="item in mytaskList" :key="item.id" :label="item.linkman" :value="item.id">
          </el-option>
        </el-select>
      </el-form-item>
      <el-form-item label="合同类型:" prop="contractType">
        <el-select v-model="queryParams.contractType" placeholder="请选择合同类型:" clearable>
          <el-option
            v-for="dict in dict.type.contract_type"
            :key="dict.value"
            :label="dict.label"
            :value="dict.value"
          />
        </el-select>
      </el-form-item>
      <el-form-item label="申请类型:" prop="applicationType">
        <el-select v-model="queryParams.applicationType" placeholder="请选择申请类型:" clearable>
          <el-option
            v-for="dict in dict.type.application_type"
            :key="dict.value"
            :label="dict.label"
            :value="dict.value"
          />
        </el-select>
      </el-form-item>
      <el-form-item label="申请人" prop="applicant">
        <el-select v-model="queryParams.applicant" placeholder="请选择申请人" clearable>
          <el-option v-for="item in mytaskList" :key="item.applicant" :label="item.applicantName" :value="item.applicant">
          </el-option>
        </el-select>
        />
      </el-form-item>
      <el-form-item label="申请日期" prop="applicationDate">
        <el-date-picker clearable
          v-model="queryParams.applicationDate"
          type="date"
          value-format="yyyy-MM-dd"
          placeholder="请选择申请日期">
        </el-date-picker>
      </el-form-item>
      <el-form-item label="申请状态" prop="applicationStatus">
        <el-select v-model="queryParams.applicationStatus" placeholder="请选择申请状态" clearable>
          <el-option
            v-for="dict in dict.type.application_status"
            :key="dict.value"
            :label="dict.label"
            :value="dict.value"
          />
        </el-select>
      </el-form-item>
      <el-form-item label="审核人" prop="approved">
        <el-select v-model="queryParams.approved" placeholder="请选择审核人" clearable>
          <el-option v-for="item in mytaskList" :key="item.applicant" :label="item.applicantName" :value="item.applicant">
          </el-option>
        </el-select>
        />
      </el-form-item>
      <el-form-item label="审核日期" prop="approvedDate">
        <el-date-picker clearable
          v-model="queryParams.approvedDate"
          type="date"
          value-format="yyyy-MM-dd"
          placeholder="请选择审核日期">
        </el-date-picker>
      </el-form-item>
      <el-form-item label="审核状态" prop="approvedStatus">
        <el-select v-model="queryParams.approvedStatus" placeholder="请选择审核状态" clearable>
          <el-option
            v-for="dict in dict.type.approved_status"
            :key="dict.value"
            :label="dict.label"
            :value="dict.value"
          />
        </el-select>
      </el-form-item>
      <el-form-item label="审核意见" prop="approvedComments">
        <el-input
          v-model="queryParams.approvedComments"
          placeholder="请输入审核意见"
          clearable
          @keyup.enter.native="handleQuery"
        />
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
          v-hasPermi="['mytask:mytask:add']"
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
          v-hasPermi="['mytask:mytask:edit']"
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
          v-hasPermi="['mytask:mytask:remove']"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['mytask:mytask:export']"
        >导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="mytaskList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="编号" align="center" prop="id" />
      <el-table-column label="单据号" align="center" prop="documentNo" />
      <el-table-column label="关联单据号id" align="center" prop="documentNoId" />
      <el-table-column label="业务类型:" align="center" prop="businessType">
        <template slot-scope="scope">
          <dict-tag :options="dict.type.business_type" :value="scope.row.businessType"/>
        </template>
      </el-table-column>
      <el-table-column label="合同类型:" align="center" prop="contractType">
        <template slot-scope="scope">
          <dict-tag :options="dict.type.contract_type" :value="scope.row.contractType"/>
        </template>
      </el-table-column>
      <el-table-column label="申请类型:" align="center" prop="applicationType">
        <template slot-scope="scope">
          <dict-tag :options="dict.type.application_type" :value="scope.row.applicationType"/>
        </template>
      </el-table-column>
      <el-table-column label="申请人" align="center" prop="applicant" />
      <el-table-column label="申请日期" align="center" prop="applicationDate" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.applicationDate, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="申请状态" align="center" prop="applicationStatus">
        <template slot-scope="scope">
          <dict-tag :options="dict.type.application_status" :value="scope.row.applicationStatus"/>
        </template>
      </el-table-column>
      <el-table-column label="审核人" align="center" prop="approved" />
      <el-table-column label="审核日期" align="center" prop="approvedDate" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.approvedDate, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="审核状态" align="center" prop="approvedStatus">
        <template slot-scope="scope">
          <dict-tag :options="dict.type.approved_status" :value="scope.row.approvedStatus"/>
        </template>
      </el-table-column>
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleDetail(scope.row)"
            v-hasPermi="['mytask:mytask:query']"
          >详情</el-button>

          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['mytask:mytask:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['mytask:mytask:remove']"
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

    <!-- 添加或修改智能仓储WMS-出库申请对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="单据号" prop="documentNo">
          <el-input v-model="form.documentNo" placeholder="请输入单据号" />
        </el-form-item>
        <el-form-item label="关联单据号id" prop="documentNoId">
          <el-input v-model="form.documentNoId" placeholder="请输入关联单据号id" />
        </el-form-item>
        <el-form-item label="业务类型:" prop="businessType">
          <el-select v-model="form.businessType" placeholder="请选择业务类型:">
            <el-option
              v-for="dict in dict.type.business_type"
              :key="dict.value"
              :label="dict.label"
              :value="parseInt(dict.value)"
            ></el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="客户编号" prop="customerId">
          <el-input v-model="form.customerId" placeholder="请输入客户编号" />
        </el-form-item>
        <el-form-item label="合同类型:" prop="contractType">
          <el-select v-model="form.contractType" placeholder="请选择合同类型:">
            <el-option
              v-for="dict in dict.type.contract_type"
              :key="dict.value"
              :label="dict.label"
              :value="parseInt(dict.value)"
            ></el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="申请类型:" prop="applicationType">
          <el-select v-model="form.applicationType" placeholder="请选择申请类型:">
            <el-option
              v-for="dict in dict.type.application_type"
              :key="dict.value"
              :label="dict.label"
              :value="parseInt(dict.value)"
            ></el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="申请人" prop="applicant">
          <el-input v-model="form.applicant" placeholder="请输入申请人" />
        </el-form-item>
        <el-form-item label="申请日期" prop="applicationDate">
          <el-date-picker clearable
            v-model="form.applicationDate"
            type="date"
            value-format="yyyy-MM-dd"
            placeholder="请选择申请日期">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="申请状态" prop="applicationStatus">
          <el-select v-model="form.applicationStatus" placeholder="请选择申请状态">
            <el-option
              v-for="dict in dict.type.application_status"
              :key="dict.value"
              :label="dict.label"
              :value="parseInt(dict.value)"
            ></el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="审核人" prop="approved">
          <el-input v-model="form.approved" placeholder="请输入审核人" />
        </el-form-item>
        <el-form-item label="审核日期" prop="approvedDate">
          <el-date-picker clearable
            v-model="form.approvedDate"
            type="date"
            value-format="yyyy-MM-dd"
            placeholder="请选择审核日期">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="审核状态" prop="approvedStatus">
          <el-select v-model="form.approvedStatus" placeholder="请选择审核状态">
            <el-option
              v-for="dict in dict.type.approved_status"
              :key="dict.value"
              :label="dict.label"
              :value="parseInt(dict.value)"
            ></el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="审核意见" prop="approvedComments">
          <el-input v-model="form.approvedComments" placeholder="请输入审核意见" />
        </el-form-item>
        <el-form-item label="备注" prop="remark">
          <el-input v-model="form.remark" type="textarea" placeholder="请输入内容" />
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button type="primary" @click="submitForm">确 定</el-button>
        <el-button @click="cancel">取 消</el-button>
      </div>
    </el-dialog>


     <!-- 添加或修改智能仓储WMS-出库申请对话框 -->
     <el-dialog :title="title" :visible.sync="openDetail" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="审核意见" prop="approvedComments">
          <el-input v-model="form.approvedComments" placeholder="请输入审核意见" />
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button type="primary" @click="handleReject">驳回</el-button>
        <el-button @click="cancel">通过</el-button>
      </div>
    </el-dialog>


  </div>
</template>

<script>
import { listMytask, getMytask, delMytask, addMytask, updateMytask } from "@/api/mytask/mytask";

export default {
  name: "Mytask",
  dicts: ['approved_status', 'application_type', 'application_status', 'contract_type', 'business_type'],
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
      // 智能仓储WMS-出库申请表格数据
      mytaskList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      openDetail: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        documentNo: null,
        documentNoId: null,
        businessType: null,
        customerId: null,
        documentStatus: null,
        contractType: null,
        applicationType: null,
        applicant: null,
        applicationDate: null,
        applicationStatus: null,
        approved: null,
        approvedDate: null,
        approvedStatus: null,
        approvedComments: null,
        remark: null
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
    /** 查询智能仓储WMS-出库申请列表 */
    getList() {
      this.loading = true;
      listMytask(this.queryParams).then(response => {
        this.mytaskList = response.rows;
        this.total = response.total;
        this.loading = false;
        console.log(this.mytaskList);
      });
    },
    // 取消按钮
    cancel() {
      this.open = false;
      this.openDetail = false;
      this.reset();
    },
    // 表单重置
    reset() {
      this.form = {
        id: null,
        documentNo: null,
        documentNoId: null,
        businessType: null,
        customerId: null,
        documentStatus: null,
        contractType: null,
        applicationType: null,
        applicant: null,
        applicationDate: null,
        applicationStatus: null,
        approved: null,
        approvedDate: null,
        approvedStatus: null,
        approvedComments: null,
        remark: null
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
      this.title = "添加智能仓储WMS-出库申请";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const id = row.id || this.ids
      getMytask(id).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改智能仓储WMS-出库申请";
      });
    },
    handleDetail(row) {
      this.openDetail = true;
      this.title = "查看出库申请";

    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.id != null) {
            updateMytask(this.form).then(response => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addMytask(this.form).then(response => {
              this.$modal.msgSuccess("新增成功");
              this.open = false;
              this.getList();
            });
          }
        }
      });
    },

    // 驳回按钮操作
    handleReject() {
      this.openDetail = false;
      this.getList();
    },
    /** 删除按钮操作 */
    handleDelete(row) {
      const ids = row.id || this.ids;
      this.$modal.confirm('是否确认删除智能仓储WMS-出库申请编号为"' + ids + '"的数据项？').then(function() {
        return delMytask(ids);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("删除成功");
      }).catch(() => {});
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('mytask/mytask/export', {
        ...this.queryParams
      }, `mytask_${new Date().getTime()}.xlsx`)
    }
  }
};
</script>
