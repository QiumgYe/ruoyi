<!--<template>-->
<!--  <div class="app-container">-->
<!--    &lt;!&ndash;    <h1>插件管理</h1>&ndash;&gt;-->

<!--    &lt;!&ndash;    <el-button&ndash;&gt;-->
<!--    &lt;!&ndash;      @click="remotePlugin"&ndash;&gt;-->
<!--    &lt;!&ndash;    >测试</el-button>&ndash;&gt;-->

<!--    &lt;!&ndash;    <el-button&ndash;&gt;-->
<!--    &lt;!&ndash;      type="primary"&ndash;&gt;-->
<!--    &lt;!&ndash;      @click="remotePlugin"&ndash;&gt;-->
<!--    &lt;!&ndash;      v-loading.fullscreen.lock="fullscreenLoading">&ndash;&gt;-->
<!--    &lt;!&ndash;      测试&ndash;&gt;-->
<!--    &lt;!&ndash;    </el-button>&ndash;&gt;-->

<!--    <el-row :gutter="10" class="mb8">-->
<!--      <span>插件分类：</span>-->
<!--      <el-select size="medium" v-model="fenlei.name" placeholder="请选择" @change="fenleichange">-->
<!--        <el-option-->
<!--          v-for="item in fenleilist"-->
<!--          :key="item.id"-->
<!--          :label="item.groupName"-->
<!--          :value="item">-->
<!--        </el-option>-->
<!--      </el-select>-->




<!--      <el-col :span="1.5">-->
<!--        <el-button-->
<!--          type="primary"-->
<!--          icon="el-icon-plus"-->
<!--          size="mini"-->
<!--          @click="handleAdd"-->
<!--          v-hasPermi="['system:plugin:add']"-->
<!--        >新增插件</el-button>-->
<!--      </el-col>-->

<!--      <el-col :span="1.5">-->
<!--        <el-button-->
<!--          type="danger"-->
<!--          icon="el-icon-delete"-->
<!--          size="mini"-->
<!--          :disabled="multiple"-->
<!--          @click="handleDelete"-->
<!--          v-hasPermi="['system:plugin:remove']"-->
<!--        >删除插件</el-button>-->
<!--      </el-col>-->


<!--      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>-->
<!--    </el-row>-->

<!--    <el-table v-loading="loading" :data="pluginList" @selection-change="handleSelectionChange">-->
<!--      <el-table-column type="selection" width="55" align="center" />-->

<!--      <el-table-column label="插件id" align="center" prop="pluginId" />-->
<!--      <el-table-column label="插件类" align="center" prop="pluginClass" />-->
<!--      <el-table-column label="插件名字" align="center" prop="pluginName" />-->
<!--      <el-table-column label="插件版本" align="center" prop="pluginVersion" />-->
<!--      <el-table-column label="插件作者" align="center" prop="pluginProvider" />-->
<!--      <el-table-column label="插件描述" align="center" prop="pluginDescription" />-->

<!--      <el-table-column label="载入状态" header-align="center" prop="pluginLoad" align="center"-->
<!--                       :show-overflow-tooltip="true">-->
<!--        <template slot-scope="scope">-->
<!--          <i v-if="scope.row.pluginLoad==0"><i class="el-icon-error"></i></i>-->
<!--          <i v-if="scope.row.pluginLoad==1"><i class="el-icon-loading"></i></i>-->
<!--        </template>-->
<!--      </el-table-column>-->

<!--      <el-table-column label="上传日期" align="center" prop="uploadDate" width="180">-->
<!--        <template slot-scope="scope">-->
<!--          <span>{{ parseTime(scope.row.uploadDate, '{y}-{m}-{d}') }}</span>-->
<!--        </template>-->
<!--      </el-table-column>-->

<!--      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">-->



<!--        <template slot-scope="scope">-->


<!--          <el-button-->
<!--            size="mini"-->
<!--            type="text"-->
<!--            icon="el-icon-setting"-->
<!--            @click="handleGo(scope.row)"-->
<!--            v-hasPermi="['system:plugin:edit']"-->
<!--          >状态更改</el-button>-->


<!--          <el-button-->
<!--            size="mini"-->
<!--            type="text"-->
<!--            icon="el-icon-edit"-->
<!--            @click="handleUpdate(scope.row)"-->
<!--            v-hasPermi="['system:plugin:edit']"-->
<!--          >修改信息</el-button>-->

<!--          <el-button-->
<!--            size="mini"-->
<!--            type="text"-->
<!--            icon="el-icon-delete"-->
<!--            @click="unloadPlugin(scope.row)"-->
<!--            v-hasPermi="['system:plugin:edit']"-->
<!--          >卸载插件</el-button>-->

<!--        </template>-->
<!--      </el-table-column>-->
<!--    </el-table>-->

<!--    <pagination-->
<!--      v-show="total>0"-->
<!--      :total="total"-->
<!--      :page.sync="queryParams.pageNum"-->
<!--      :limit.sync="queryParams.pageSize"-->
<!--      @pagination="getList"-->
<!--    />-->
<!--    &lt;!&ndash; 启动对话框 &ndash;&gt;-->

<!--    <el-dialog :title="title" :visible.sync="openqidong" width="500px" append-to-body>-->
<!--      <el-form ref="form" :model="form" :rules="rules" label-width="80px">-->
<!--        <el-form-item prop="pluginLoad" label="载入状态">-->
<!--          <el-radio-group v-model="form.pluginLoad">-->
<!--            <el-radio  label="1" >启动</el-radio>-->
<!--            <el-radio  label="0">禁止</el-radio>-->
<!--          </el-radio-group>-->


<!--        </el-form-item>-->
<!--      </el-form>-->

<!--      <div slot="footer" class="dialog-footer">-->
<!--        <el-button type="primary" @click="startOrEnd">确 定</el-button>-->
<!--        <el-button @click="cancel">取 消</el-button>-->
<!--      </div>-->
<!--    </el-dialog>-->

<!--    &lt;!&ndash; 修改对话框 &ndash;&gt;-->
<!--    <el-dialog :title="title" :visible.sync="openxiugai" width="500px" append-to-body>-->
<!--      <el-form ref="form" :model="form" :rules="rules" label-width="80px">-->


<!--        <el-form-item label="插件id" prop="pluginId">-->
<!--          <el-input v-model="form.pluginId" type="textarea" placeholder="请输入内容" />-->
<!--        </el-form-item>-->
<!--        <el-form-item label="插件类" prop="pluginClass">-->
<!--          <el-input v-model="form.pluginClass" type="textarea" placeholder="请输入内容" />-->
<!--        </el-form-item>-->
<!--        <el-form-item label="插件名字" prop="pluginName">-->
<!--          <el-input v-model="form.pluginName" type="textarea" placeholder="请输入内容" />-->
<!--        </el-form-item>-->
<!--        <el-form-item label="插件版本" prop="pluginVersion">-->
<!--          <el-input v-model="form.pluginVersion" placeholder="请输入插件版本" />-->
<!--        </el-form-item>-->
<!--        <el-form-item label="插件作者" prop="pluginProvider">-->
<!--          <el-input v-model="form.pluginProvider" placeholder="请输入插件作者" />-->
<!--        </el-form-item>-->
<!--        <el-form-item label="插件描述" prop="pluginDescription">-->
<!--          <el-input v-model="form.pluginDescription" type="textarea" placeholder="请输入内容" />-->
<!--        </el-form-item>-->

<!--      </el-form>-->
<!--      <div slot="footer" class="dialog-footer">-->
<!--        <el-button type="primary" @click="submitForm">确 定</el-button>-->
<!--        <el-button @click="cancel">取 消</el-button>-->
<!--      </div>-->
<!--    </el-dialog>-->

<!--    &lt;!&ndash; 添加对话框 &ndash;&gt;-->
<!--    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>-->
<!--      <el-form ref="form" :model="form" :rules="rules" label-width="80px">-->

<!--        <el-form-item prop="classId" label="插件分类" >-->
<!--          <span>{{this.fenlei.name}}</span>-->
<!--        </el-form-item>-->
<!--        <el-form-item label="插件id" prop="pluginId">-->
<!--          <el-input v-model="form.pluginId" type="textarea" placeholder="请输入内容" />-->
<!--        </el-form-item>-->
<!--        <el-form-item label="插件类" prop="pluginClass">-->
<!--          <el-input v-model="form.pluginClass" type="textarea" placeholder="请输入内容" />-->
<!--        </el-form-item>-->
<!--        <el-form-item label="插件名字" prop="pluginName">-->
<!--          <el-input v-model="form.pluginName" type="textarea" placeholder="不用输入后缀名.jar" />-->
<!--        </el-form-item>-->
<!--        <el-form-item label="插件版本" prop="pluginVersion">-->
<!--          <el-input v-model="form.pluginVersion" placeholder="请输入插件版本" />-->
<!--        </el-form-item>-->
<!--        <el-form-item label="插件作者" prop="pluginProvider">-->
<!--          <el-input v-model="form.pluginProvider" placeholder="请输入插件作者" />-->
<!--        </el-form-item>-->
<!--        <el-form-item label="插件描述" prop="pluginDescription">-->
<!--          <el-input v-model="form.pluginDescription" type="textarea" placeholder="请输入内容" />-->
<!--        </el-form-item>-->
<!--        <el-form-item label="上传jar包" prop="uploadCatalog">-->
<!--          &lt;!&ndash;              <el-input v-model="form.wechatQrcode" placeholder="请输入微信二维码" />&ndash;&gt;-->
<!--          <div class="hello">-->

<!--            <el-tag type="info">选择jar包点击上传</el-tag>-->
<!--            <form>-->
<!--              <input type="file" @change="getFile($event)">-->
<!--              <el-button type="primary"  @click="WBsubmit($event)">上传<i class="el-icon-upload el-icon&#45;&#45;right"></i></el-button>-->
<!--            </form>-->
<!--          </div>-->
<!--        </el-form-item>-->


<!--        <el-form-item prop="pluginLoad" label="载入状态">-->
<!--          <el-tag type="success">首次启动</el-tag>-->
<!--        </el-form-item>-->

<!--        <el-form-item  label="警告">-->
<!--          <el-tag type="danger">点击确认后大约需要10s等待时间</el-tag>-->
<!--        </el-form-item>-->


<!--      </el-form>-->
<!--      <div slot="footer" class="dialog-footer">-->
<!--        <el-button type="primary" @click="submitForm"  v-loading.fullscreen.lock="fullscreenLoading">确 定</el-button>-->
<!--        <el-button @click="cancel">取 消</el-button>-->
<!--      </div>-->
<!--    </el-dialog>-->
<!--  </div>-->
<!--</template>-->

<!--<script>-->
<!--  import {-->
<!--    listPlugin,-->
<!--    getPlugin,-->
<!--    delPlugin,-->
<!--    addPlugin,-->
<!--    updatePlugin,-->
<!--    listLinkByGroupId,-->
<!--    jarUpload,-->
<!--    remotePlugin, startPlugin, banPlugin,unloadPlugin-->
<!--  } from "@/api/cj/plugin";-->
<!--  import { listGroup, getGroup, delGroup, addGroup, updateGroup  } from "@/api/cj/group";-->



<!--  export default {-->
<!--    name: "Plugin",-->
<!--    data() {-->
<!--      return {-->


<!--        fullscreenLoading: false,-->

<!--        radio:'1',-->




<!--        file: '',-->

<!--        weiboqrcode: ' ',-->

<!--        fenleilist:[],-->

<!--        fenlei:[],-->
<!--        // 遮罩层-->
<!--        loading: true,-->
<!--        // 选中数组-->
<!--        ids: [],-->
<!--        // 非单个禁用-->
<!--        single: true,-->
<!--        // 非多个禁用-->
<!--        multiple: true,-->
<!--        // 显示搜索条件-->
<!--        showSearch: true,-->
<!--        // 总条数-->
<!--        total: 0,-->
<!--        // 【请填写功能名称】表格数据-->
<!--        pluginList: [],-->
<!--        // 弹出层标题-->
<!--        title: "",-->
<!--        // 是否显示弹出层-->
<!--        open: false,-->

<!--        openqidong: false ,-->
<!--        openxiugai:false,-->
<!--        // 查询参数-->
<!--        queryParams: {-->
<!--          pageNum: 1,-->
<!--          pageSize: 10,-->
<!--          pluginId: null,-->
<!--          pluginClass: null,-->
<!--          pluginName: null,-->
<!--          pluginVersion: null,-->
<!--          pluginProvider: null,-->
<!--          pluginDescription: null,-->
<!--          pluginGroupId: null,-->
<!--          pluginLoad: null,-->
<!--          uploadDate: null,-->
<!--          uploadCatalog: null-->
<!--        },-->
<!--        // 表单参数-->
<!--        form: {},-->
<!--        // 表单校验-->
<!--        rules: {-->
<!--        }-->
<!--      };-->
<!--    },-->
<!--    created() {-->
<!--      this.getList();-->
<!--      this.fllist();-->
<!--    },-->
<!--    methods: {-->
<!--      /** 查询【请填写功能名称】列表 */-->
<!--      getList() {-->
<!--        this.loading = true;-->
<!--        listPlugin(this.queryParams).then(response => {-->
<!--          this.pluginList = response.rows;-->
<!--          this.total = response.total;-->
<!--          this.loading = false;-->
<!--        });-->
<!--      },-->
<!--      // 取消按钮-->
<!--      cancel() {-->
<!--        this.open = false;-->
<!--        this.openxiugai = false;-->
<!--        this.openqidong=false;-->
<!--        this.reset();-->
<!--      },-->
<!--      // 表单重置-->
<!--      reset() {-->
<!--        this.form = {-->
<!--          id: null,-->
<!--          pluginId: null,-->
<!--          pluginClass: null,-->
<!--          pluginName: null,-->
<!--          pluginVersion: null,-->
<!--          pluginProvider: null,-->
<!--          pluginDescription: null,-->
<!--          pluginGroupId: null,-->
<!--          pluginLoad: null,-->
<!--          uploadDate: null,-->
<!--          uploadCatalog: null-->
<!--        };-->
<!--        this.resetForm("form");-->
<!--      },-->
<!--      /** 搜索按钮操作 */-->
<!--      handleQuery() {-->
<!--        this.queryParams.pageNum = 1;-->
<!--        this.getList();-->
<!--      },-->
<!--      /** 重置按钮操作 */-->
<!--      resetQuery() {-->
<!--        this.resetForm("queryForm");-->
<!--        this.handleQuery();-->
<!--      },-->
<!--      // 多选框选中数据-->
<!--      handleSelectionChange(selection) {-->
<!--        this.ids = selection.map(item => item.id)-->
<!--        this.single = selection.length!==1-->
<!--        this.multiple = !selection.length-->
<!--      },-->
<!--      /** 新增按钮操作 */-->
<!--      handleAdd() {-->


<!--        if (this.fenlei.name == null ||this.fenlei.name == "" ) {-->
<!--          this.$message({-->
<!--            message: "请在右侧选定一个链接分类",-->
<!--            type: 'error'-->
<!--          });-->
<!--          return false;-->
<!--        }-->
<!--        this.reset();-->
<!--        this.open = true;-->
<!--        this.title = "添加插件";-->
<!--      },-->
<!--      /** 修改按钮操作 */-->
<!--      handleUpdate(row) {-->
<!--        this.reset();-->
<!--        const id = row.id || this.ids-->
<!--        getPlugin(id).then(response => {-->
<!--          this.form = response.data;-->
<!--          this.openxiugai = true;-->
<!--          this.title = "修改插件";-->
<!--        });-->
<!--      },-->
<!--      /**启动按钮*/-->
<!--      handleGo(row) {-->
<!--        this.reset();-->
<!--        const id = row.id || this.ids-->
<!--        getPlugin(id).then(response => {-->
<!--          this.form = response.data;-->
<!--          this.openqidong = true;-->
<!--          this.title = "启动插件";-->
<!--        });-->
<!--      },-->
<!--      /** 提交按钮 */-->
<!--      submitForm() {-->
<!--        this.$refs["form"].validate(valid => {-->
<!--          if (valid) {-->
<!--            if (this.form.id != null) {-->
<!--              updatePlugin(this.form).then(response => {-->
<!--                if (response.code === 200) {-->
<!--                  this.msgSuccess("修改成功");-->
<!--                  this.open = false;-->
<!--                  this.openxiugai = false;-->
<!--                  this.openqidong = false;-->
<!--                  this.getList();-->
<!--                }-->
<!--              });-->
<!--            } else {-->

<!--              if(this.form.pluginId==null ||this.form.pluginClass==null || this.form.pluginName ==null || this.form.pluginVersion==null-->
<!--                ||this.form.pluginProvider==null|| this.form.pluginDescription==null){-->
<!--                this.$message({-->
<!--                  message: '请完善全部信息',-->
<!--                  type: 'warning'-->
<!--                });-->

<!--              }else{-->
<!--                if(this.file==null || this.file ==""){-->
<!--                  this.$message.error('请先上传jar包，在点击确认！');-->
<!--                }else{-->
<!--                  this.form.pluginGroupId=this.fenlei.id;-->
<!--                  this.form.uploadCatalog='/home/running/'+this.form.pluginName+".jar";-->
<!--                  this.form.uploadDate=Date.now();-->
<!--                  this.form.pluginLoad=1;-->
<!--                  addPlugin(this.form).then(response => {-->
<!--                    if (response.code === 200) {-->

<!--                      this.fullscreenLoading = true;-->
<!--                      setTimeout(() => {-->
<!--                        this.fullscreenLoading = false;-->
<!--                        this.msgSuccess("新增成功");-->
<!--                        this.open = false;-->
<!--                        this.getList();-->

<!--                      }, 10000);-->

<!--                    }-->
<!--                  });-->
<!--                }-->


<!--              }-->



<!--            }-->
<!--          }-->
<!--        });-->
<!--      },-->
<!--      /** 删除按钮操作 */-->
<!--      handleDelete(row) {-->
<!--        const ids = row.id || this.ids;-->

<!--        this.$confirm('是否确认删除该插件?', "警告", {-->
<!--          confirmButtonText: "确定",-->
<!--          cancelButtonText: "取消",-->
<!--          type: "warning"-->
<!--        }).then(function() {-->
<!--          return delPlugin(ids);-->
<!--        }).then(() => {-->
<!--          this.getList();-->
<!--          this.msgSuccess("删除成功");-->
<!--        }).catch(function() {});-->
<!--      },-->
<!--      /** 导出按钮操作 */-->
<!--      handleExport() {-->
<!--        this.download('system/plugin/export', {-->
<!--          ...this.queryParams-->
<!--        }, `system_plugin.xlsx`)-->
<!--      },-->
<!--      fllist(){-->
<!--        listGroup().then(response => {-->
<!--          this.fenleilist = response.rows;-->
<!--        });-->
<!--      },-->
<!--      fenleichange(item){-->
<!--        this.fenlei.name=item.groupName;-->
<!--        this.fenlei.id=item.id;-->
<!--        console.log(this.fenlei.id);-->
<!--        console.log(this.fenlei.name);-->
<!--        listLinkByGroupId(this.fenlei.id).then(response => {-->
<!--          this.pluginList = response.rows;-->
<!--          this.total = response.total;-->
<!--          this.loading = false;-->
<!--        });-->
<!--      },-->
<!--      getFile: function (event) {-->
<!--        this.file = event.target.files[0];-->
<!--        console.log(this.file);-->
<!--      },-->
<!--      WBsubmit: function (event) {-->
<!--        //阻止元素发生默认的行为-->
<!--        event.preventDefault();-->
<!--        let formData = new FormData();-->
<!--        formData.append("file", this.file);-->
<!--        jarUpload(formData).then(response => {-->
<!--          // this.weiboqrcode=response;-->
<!--          this.getList();-->



<!--          this.$message({-->
<!--            message: '上传成功',-->
<!--            type: 'success'-->
<!--          });-->
<!--        }).catch(response => {-->
<!--          // this.weiboqrcode=response;-->
<!--          this.$message.error('上传失败');-->
<!--        });-->
<!--      },-->
<!--      //测试专用-->
<!--      remotePlugin: function () {-->

<!--        remotePlugin().then(response => {-->

<!--          this.fullscreenLoading = true;-->
<!--          setTimeout(() => {-->
<!--            this.fullscreenLoading = false;-->
<!--          }, 15000);-->
<!--          if (response.code === 200) {-->
<!--            this.msgSuccess("启动成功");-->

<!--          }-->

<!--        }).catch(response => {-->

<!--          alert("失败");-->
<!--        });-->
<!--      },-->
<!--//启动与关闭的按钮-->
<!--      startOrEnd:function (){-->

<!--        this.$refs["form"].validate(valid => {-->
<!--          if (valid) {-->
<!--            if (this.form.id != null) {-->
<!--              updatePlugin(this.form).then(response => {-->
<!--                if (response.code === 200) {-->
<!--                  this.msgSuccess("修改成功");-->
<!--                  this.open = false;-->
<!--                  this.openxiugai = false;-->
<!--                  this.openqidong = false;-->
<!--                  this.getList();-->
<!--                }-->
<!--              });-->
<!--            }-->
<!--          }-->
<!--          if(this.form.pluginLoad==1){-->
<!--            console.log("启动");-->

<!--            startPlugin(this.form.id).then(response => {-->

<!--            });-->

<!--          }else{-->
<!--            console.log("禁止")-->
<!--            banPlugin(this.form.id).then(response => {-->

<!--            });-->
<!--          }-->


<!--        });-->


<!--      },-->

<!--//卸载插件-->
<!--      unloadPlugin(row) {-->
<!--        const ids = row.id || this.ids;-->

<!--        // this.$confirm('是否确认删除插件编号为"' + ids + '"的数据项?', "警告", {-->
<!--        //   confirmButtonText: "确定",-->
<!--        //   cancelButtonText: "取消",-->
<!--        //   type: "warning"-->
<!--        // }).then(function() {-->
<!--        //   return unloadPlugin(ids);-->
<!--        // }).then(() => {-->
<!--        //   this.getList();-->
<!--        //   this.msgSuccess("删除成功");-->
<!--        // }).catch(function() {});-->
<!--        this.$confirm('此操作将永久删除该文件, 是否继续?', '提示', {-->
<!--          confirmButtonText: '确定',-->
<!--          cancelButtonText: '取消',-->
<!--          type: 'warning'-->
<!--        }).then(() => {-->
<!--          unloadPlugin(ids).then(response => {-->
<!--            this.getList();-->
<!--          });-->
<!--          this.$message({-->
<!--            type: 'success',-->
<!--            message: '删除成功!'-->
<!--          });-->

<!--        }).catch(() => {-->
<!--          this.$message({-->
<!--            type: 'info',-->
<!--            message: '已取消删除'-->
<!--          });-->
<!--        });-->


<!--      },-->


<!--    }-->
<!--  };-->
<!--</script>-->
