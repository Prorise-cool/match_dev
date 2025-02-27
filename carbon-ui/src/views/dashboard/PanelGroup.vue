<template>
  <div class="panel-group">
    <div ref="electricityChart" class="gauge-chart" />
    <div ref="waterChart" class="gauge-chart" />
    <div ref="carbonChart" class="gauge-chart" />
  </div>
</template>

<script>
import * as echarts from 'echarts';
import resize from './mixins/resize';

export default {
  mixins: [resize],
  data() {
    return {
      electricityChart: null,
      waterChart: null,
      carbonChart: null,
      energyConsumption: {
        electricity: '', // 初始耗电量
        water: '',       // 初始耗水量
        carbon: ''       // 初始碳排放量
      }
    };
  },
  mounted() {
    this.initCharts();
    this.updateCharts();
    setInterval(this.updateCharts, 2000);
  },
  beforeDestroy() {
    if (this.electricityChart) {
      this.electricityChart.dispose();
    }
    if (this.waterChart) {
      this.waterChart.dispose();
    }
    if (this.carbonChart) {
      this.carbonChart.dispose();
    }
  },
  methods: {
    initCharts() {
      this.electricityChart = echarts.init(this.$refs.electricityChart);
      this.waterChart = echarts.init(this.$refs.waterChart);
      this.carbonChart = echarts.init(this.$refs.carbonChart);
      this.electricityChart.setOption(this.getChartOptions('电', this.energyConsumption.electricity, '#67e0e3'));
      this.waterChart.setOption(this.getChartOptions('水', this.energyConsumption.water, '#37a2da'));
      this.carbonChart.setOption(this.getChartOptions('碳', this.energyConsumption.carbon, '#fd666d'));
    },
    getChartOptions(type, value, color) {
      return {
        series: [
          {
            type: 'gauge',
            axisLine: {
              lineStyle: {
                width: 30,
                color: [[1, color]] // 只显示一个颜色
              }
            },
            pointer: {
              itemStyle: {
                color: 'auto'
              }
            },
            axisTick: {
              distance: -30,
              length: 8,
              lineStyle: {
                color: '#fff',
                width: 2
              }
            },
            splitLine: {
              distance: -30,
              length: 30,
              lineStyle: {
                color: '#fff',
                width: 4
              }
            },
            axisLabel: {
              color: 'inherit',
              distance: 40,
              fontSize: 20
            },
            detail: {
              valueAnimation: true,
              formatter: () => {
                return `${type}: ${value}`;
              },
              color: 'inherit'
            },
            data: [
              {
                value: value
              }
            ]
          }
        ]
      };
    },
    updateCharts() {
      // 随机生成数据以模拟变化
      this.energyConsumption.electricity = +(Math.random() * 100).toFixed(2);
      this.energyConsumption.water = +(Math.random() * 100).toFixed(2);
      this.energyConsumption.carbon = +(Math.random() * 100).toFixed(2);

      this.electricityChart.setOption({
        series: [
          {
            data: [
              {
                value: this.energyConsumption.electricity
              }
            ]
          }
        ]
      });

      this.waterChart.setOption({
        series: [
          {
            data: [
              {
                value: this.energyConsumption.water
              }
            ]
          }
        ]
      });

      this.carbonChart.setOption({
        series: [
          {
            data: [
              {
                value: this.energyConsumption.carbon
              }
            ]
          }
        ]
      });
    }
  }
};
</script>

<style scoped>
.gauge-chart {
  width: 100%;
  height: 300px; /* Adjust height as needed */
  margin-bottom: 20px; /* Add some space between charts */
}
</style>
