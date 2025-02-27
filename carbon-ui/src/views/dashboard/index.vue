<template>
  <div class="dashboard-container">
    <el-row :gutter="20">
      <el-col :span="12">
        <bar-chart :class-name="'chart'" />
      </el-col>
      <el-col :span="12">
        <line-chart :class-name="'chart'" :chart-data="lineChartData" />
      </el-col>
      <el-col :span="12">
        <pie-chart :class-name="'chart'" />
      </el-col>
      <el-col :span="12">
        <raddar-chart :class-name="'chart'" />
      </el-col>
    </el-row>
    <el-row :gutter="20">
      <el-col :span="12">
        <panel-group />
      </el-col>
    </el-row>
  </div>
</template>

<script>
import BarChart from './BarChart.vue';
import LineChart from './LineChart.vue';
import PieChart from './PieChart.vue';
import RaddarChart from './RaddarChart.vue';
import PanelGroup from './PanelGroup.vue';

export default {
  components: {
    BarChart,
    LineChart,
    PieChart,
    RaddarChart,
    PanelGroup
  },
  data() {
    return {
      lineChartData: {
        expectedData: [120, 132, 101, 134, 90, 230, 210],
        actualData: [220, 182, 191, 234, 290, 330, 310]
      }
    };
  }
};
</script>

<style scoped>
.dashboard-container {
  padding: 20px;
}
</style> 