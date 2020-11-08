<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="" prop="renterName">
        <el-input
          v-model="queryParams.renterName"
          placeholder="名字"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
<!--      <el-form-item label="租客年龄" prop="renterAge">-->
<!--        <el-input-->
<!--          v-model="queryParams.renterAge"-->
<!--          placeholder="请输入租客年龄"-->
<!--          clearable-->
<!--          size="small"-->
<!--          @keyup.enter.native="handleQuery"-->
<!--        />-->
<!--      </el-form-item>-->
<!--      <el-form-item label="租客性别" prop="renterSex">-->
<!--        <el-select v-model="queryParams.renterSex" placeholder="请选择租客性别" clearable size="small">-->
<!--          <el-option label="请选择字典生成" value="" />-->
<!--        </el-select>-->
<!--      </el-form-item>-->
<!--      <el-form-item label="租客电话" prop="renterPhone">-->
<!--        <el-input-->
<!--          v-model="queryParams.renterPhone"-->
<!--          placeholder="请输入租客电话"-->
<!--          clearable-->
<!--          size="small"-->
<!--          @keyup.enter.native="handleQuery"-->
<!--        />-->
<!--      </el-form-item>-->
<!--      <el-form-item label="租客户口地址" prop="renterAddress">-->
<!--        <el-input-->
<!--          v-model="queryParams.renterAddress"-->
<!--          placeholder="请输入租客户口地址"-->
<!--          clearable-->
<!--          size="small"-->
<!--          @keyup.enter.native="handleQuery"-->
<!--        />-->
<!--      </el-form-item>-->
<!--      <el-form-item label="租客身份证id" prop="renterIdCard">-->
<!--        <el-input-->
<!--          v-model="queryParams.renterIdCard"-->
<!--          placeholder="请输入租客身份证id"-->
<!--          clearable-->
<!--          size="small"-->
<!--          @keyup.enter.native="handleQuery"-->
<!--        />-->
<!--      </el-form-item>-->
<!--      <el-form-item label="房子id号" prop="houseId">-->
<!--        <el-input-->
<!--          v-model="queryParams.houseId"-->
<!--          placeholder="请输入房子id号"-->
<!--          clearable-->
<!--          size="small"-->
<!--          @keyup.enter.native="handleQuery"-->
<!--        />-->
<!--      </el-form-item>-->
      <el-form-item>
        <el-button type="cyan" icon="el-icon-search" size="mini" @click="handleQuery">搜索</el-button>
        <el-button icon="el-icon-refresh" size="mini" @click="resetQuery">重置</el-button>
      </el-form-item>
    </el-form>

    <el-row :gutter="10" class="mb8">

      <el-select size="medium" v-model="house.name" placeholder="请选择具体地址" @change="houseChange">
        <el-option
          v-for="item in houseList"
          :key="item.id"
          :label="item.houseName"
          :value="item">
        </el-option>
      </el-select>


      <el-col :span="1.5">
        <el-button
          type="primary"
          icon="el-icon-plus"
          size="mini"
          @click="handleAdd"
          v-hasPermi="['zk:renter:add']"
        >新增</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="success"
          icon="el-icon-edit"
          size="mini"
          :disabled="single"
          @click="handleUpdate"
          v-hasPermi="['zk:renter:edit']"
        >修改</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="danger"
          icon="el-icon-delete"
          size="mini"
          :disabled="multiple"
          @click="handleDelete"
          v-hasPermi="['zk:renter:remove']"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['zk:renter:export']"
        >导出</el-button>
      </el-col>
	  <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="renterList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
<!--      <el-table-column label="租客id" align="center" prop="id" />-->
      <el-table-column label="名字" align="center" prop="renterName" />
      <el-table-column label="年龄" align="center" prop="renterAge" />
      <el-table-column label="性别" align="center" prop="renterSex" />
      <el-table-column label="电话" align="center" prop="renterPhone" />
      <el-table-column label="户口地址" align="center" prop="renterAddress" />
      <el-table-column label="身份证" align="center" prop="renterIdCard" />
<!--      <el-table-column label="房子id号" align="center" prop="houseId" />-->
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['zk:renter:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['zk:renter:remove']"
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

    <!-- 添加或修改renter对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">

        <el-form-item prop="classId" label="具体地址" >
          <span>{{this.house.name}}</span>
        </el-form-item>

        <el-form-item label="名字" prop="renterName">
          <el-input v-model="form.renterName" placeholder="请输入租客名字" />
        </el-form-item>
        <el-form-item label="年龄" prop="renterAge">
          <el-input v-model="form.renterAge" placeholder="请输入租客年龄" />
        </el-form-item>
        <el-form-item label="性别" prop="renterSex">

<!--          <el-select v-model="form.renterSex" placeholder="请选择租客性别">-->
<!--            <el-radio  label="男">男</el-radio>-->
<!--            <el-radio  label="女">女</el-radio>-->
<!--          </el-select>-->
          <el-radio-group v-model="form.renterSex">
            <el-radio  label="男">男</el-radio>
            <el-radio  label="女">女</el-radio>
          </el-radio-group>

        </el-form-item>
        <el-form-item label="电话" prop="renterPhone">
          <el-input v-model="form.renterPhone" placeholder="请输入租客电话" />
        </el-form-item>
        <el-form-item label="户口地址" prop="renterAddress">
          <el-input v-model="form.renterAddress" placeholder="请输入租客户口地址" />
        </el-form-item>
        <el-form-item label="身份证" prop="renterIdCard">
          <el-input v-model="form.renterIdCard" placeholder="请输入租客身份证id" />
        </el-form-item>
<!--        <el-form-item label="房子id号" prop="houseId">-->
<!--          <el-input v-model="form.houseId" placeholder="请输入房子id号" />-->
<!--        </el-form-item>-->
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button type="primary" @click="submitForm">确 定</el-button>
        <el-button @click="cancel">取 消</el-button>
      </div>
    </el-dialog>
  </div>
</template>

<script>
import { listRenter, getRenter, delRenter, addRenter, updateRenter, exportRenter,listRenterByHouseId } from "@/api/zk/renter";
import {listHouse} from "../../api/zk/house";

export default {
  name: "Renter",
  data() {
    return {
      //房子列表 中转
      house:[],

      //房子列表
      houseList:[],


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
      // renter表格数据
      renterList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        renterName: null,
        renterAge: null,
        renterSex: null,
        renterPhone: null,
        renterAddress: null,
        renterIdCard: null,
        houseId: null
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
    this.fzlist();
  },
  methods: {
    /** 查询renter列表 */
    getList() {
      this.loading = true;
      listRenter(this.queryParams).then(response => {
        this.renterList = response.rows;
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
        renterName: null,
        renterAge: null,
        renterSex: null,
        renterPhone: null,
        renterAddress: null,
        renterIdCard: null,
        createTime: null,
        updateTime: null,
        houseId: null
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

      if (this.house.name == null ||this.house.name == "" ) {
        this.$message({
          message: "请在右侧选定一个具体地址",
          type: 'error'
        });
        return false;
      }

      this.reset();
      this.open = true;
      this.title = "添加renter";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const id = row.id || this.ids
      getRenter(id).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改renter";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.id != null) {
            updateRenter(this.form).then(response => {
              this.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            this.form.houseId=this.house.id;

            addRenter(this.form).then(response => {
              this.msgSuccess("新增成功");
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
      this.$confirm('是否确认删除renter编号为"' + ids + '"的数据项?', "警告", {
          confirmButtonText: "确定",
          cancelButtonText: "取消",
          type: "warning"
        }).then(function() {
          return delRenter(ids);
        }).then(() => {
          this.getList();
          this.msgSuccess("删除成功");
        })
    },
    /** 导出按钮操作 */
    handleExport() {
      const queryParams = this.queryParams;
      this.$confirm('是否确认导出所有renter数据项?', "警告", {
          confirmButtonText: "确定",
          cancelButtonText: "取消",
          type: "warning"
        }).then(function() {
          return exportRenter(queryParams);
        }).then(response => {
          this.download(response.msg);
        })
    },


    /*房子列表*/
    fzlist(){
      listHouse().then(response => {
        this.houseList = response.rows;
      });
    },


    houseChange(item){
      this.house.name=item.houseName;
      this.house.id=item.id;

      listRenterByHouseId(this.house.id).then(response => {

        this.renterList = response.rows;
        this.total = response.total;
        this.loading = false;
      });
    },
  }
};
</script>
