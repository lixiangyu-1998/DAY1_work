<template>
	
	<div id="main" style="width: 600px;height: 500px;"></div>
</template>

<script>
	import * as echarts from 'echarts';
	export default{
		data() {
		    return {
				tempdata:	[54, 28, 44, 10, 10, 20],
				tempdata2:  ['仙侠','言情','言情2','言情3','言情4']
		    };
		  },
		methods: {
				myECharts(){
					// 基于准备好的dom，初始化echarts实例
					var myChart = echarts.init(document.getElementById('main'));
					
					var option ={
					    title: {
					        text: 'ECharts 入门示例'
					    },
					    tooltip: {},
					    xAxis: {
					        data: this.tempdata2
					    },
					    yAxis: {},
					    series: [{
					        name: '销量',
					        type: 'bar',
					        data: this.tempdata
					    }]
					}
					// 绘制图表
					myChart.setOption(option);
				}
		  },
		  mounted(){
               this.myECharts()
		  }
	}
	
	
</script>

<style>
</style>
