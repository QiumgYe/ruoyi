<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="" prop="houseBlock">
        <el-input
          v-model="queryParams.houseBlock"
          placeholder="请输入栋数"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="" prop="houseFloor">
        <el-input
          v-model="queryParams.houseFloor"
          placeholder="请输入层数"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="" prop="houseNumber">
        <el-input
          v-model="queryParams.houseNumber"
          placeholder="请输入号数"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="" prop="houseSize">
        <el-input
          v-model="queryParams.houseSize"
          placeholder="请输入平方数"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="" prop="houseMoney">
        <el-input
          v-model="queryParams.houseMoney"
          placeholder="请输入租金"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
<!--      <el-form-item label="城市id" prop="cityId">-->
<!--        <el-input-->
<!--          v-model="queryParams.cityId"-->
<!--          placeholder="请输入城市id"-->
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


      <el-select size="medium" v-model="city.name" placeholder="请选择区域" @change="cityChange">
        <el-option
          v-for="item in cityList"
          :key="item.id"
          :label="item.cityDescription"
          :value="item">
        </el-option>
      </el-select>



      <el-col :span="1.5">
        <el-button
          type="primary"
          icon="el-icon-plus"
          size="mini"
          @click="handleAdd"
          v-hasPermi="['zk:house:add']"
        >新增</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="success"
          icon="el-icon-edit"
          size="mini"
          :disabled="single"
          @click="handleUpdate"
          v-hasPermi="['zk:house:edit']"
        >修改</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="danger"
          icon="el-icon-delete"
          size="mini"
          :disabled="multiple"
          @click="handleDelete"
          v-hasPermi="['zk:house:remove']"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['zk:house:export']"
        >导出</el-button>
      </el-col>
	  <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="houseList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
<!--      <el-table-column label="房产id" align="center" prop="id" />-->
      <el-table-column label="具体位置" align="center" prop="houseName" />

      <el-table-column label="平方数" align="center" prop="houseSize" />
      <el-table-column label="租金" align="center" prop="houseMoney" />
      <el-table-column label="房产描述" align="center" prop="houseDescription" />
<!--      <el-table-column label="城市id" align="center" prop="cityId" />-->
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['zk:house:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['zk:house:remove']"
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

    <!-- 添加或修改house对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">

        <el-form-item prop="classId" label="区域" >
          <span>{{this.city.name}}</span>
        </el-form-item>

        <el-form-item label="名字" prop="houseBlock">
          <el-input v-model="form.houseName" placeholder="请输入名字" />
        </el-form-item>


        <el-form-item label="平方数" prop="houseSize">
          <el-input v-model="form.houseSize" placeholder="请输入平方数" />
        </el-form-item>
        <el-form-item label="租金" prop="houseMoney">
          <el-input v-model="form.houseMoney" placeholder="请输入租金" />
        </el-form-item>
        <el-form-item label="房产描述" prop="houseDescription">
          <el-input v-model="form.houseDescription" type="textarea" placeholder="请输入内容" />
        </el-form-item>
<!--        <el-form-item label="城市id" prop="cityId">-->
<!--          <el-input v-model="form.cityId" placeholder="请输入城市id" />-->
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
import { listHouse, getHouse, delHouse, addHouse, updateHouse, exportHouse, listHouseByCityId } from "@/api/zk/house";
import { listCity, getCity, delCity, addCity, updateCity, exportCity } from "@/api/zk/city";

export default {
  name: "House",
  data() {
    return {

      //城市列表
      cityList:[],

      //城市信息
      city:[],

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
      // house表格数据
      houseList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,

        houseSize: null,
        houseMoney: null,
        houseDescription: null,
        cityId: null,
        houseName: null
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
    this.cslist();
  },
  methods: {
    /** 查询house列表 */
    getList() {
      this.loading = true;
      listHouse(this.queryParams).then(response => {
        this.houseList = response.rows;
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

        houseSize: null,
        houseMoney: null,
        houseDescription: null,
        cityId: null,
        houseName: null
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

      if (this.city.name == null ||this.city.name == "" ) {
        this.$message({
          message: "请在右侧选定一个区域",
          type: 'error'
        });
        return false;
      }

      this.reset();
      this.open = true;
      this.title = "添加house";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const id = row.id || this.ids

      getHouse(id).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改house";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.id != null) {
            updateHouse(this.form).then(response => {
              this.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            this.form.cityId=this.city.id;
            addHouse(this.form).then(response => {
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
      this.$confirm('是否确认删除house编号为"' + ids + '"的数据项?', "警告", {
          confirmButtonText: "确定",
          cancelButtonText: "取消",
          type: "warning"
        }).then(function() {
          return delHouse(ids);
        }).then(() => {
          this.getList();
          this.msgSuccess("删除成功");
        })
    },
    /** 导出按钮操作 */
    handleExport() {
      const queryParams = this.queryParams;
      this.$confirm('是否确认导出所有house数据项?', "警告", {
          confirmButtonText: "确定",
          cancelButtonText: "取消",
          type: "warning"
        }).then(function() {
          return exportHouse(queryParams);
        }).then(response => {
          this.download(response.msg);
        })
    },

    /*城市列表*/
    cslist(){
      listCity().then(response => {
        this.cityList = response.rows;
      });
    },

    cityChange(item){
     this.city.name=item.cityDescription;
     this.city.id=item.id;

      listHouseByCityId(this.city.id).then(response => {
        this.houseList = response.rows;
        this.total = response.total;
        this.loading = false;
      });
    },
  }
};
</script>
