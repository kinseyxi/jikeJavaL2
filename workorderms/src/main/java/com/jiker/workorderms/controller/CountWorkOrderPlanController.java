package com.jiker.workorderms.controller;

import com.jiker.workorderms.bean.WorkOrderPlan;
import com.jiker.workorderms.service.CountWorkOrderPlanService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class CountWorkOrderPlanController {
    CountWorkOrderPlanService countWorkOrderPlanService=null;

    /**
     * 统计某个时间段内的工单计划数
     * @param workOrderPlan
     * @return
     */
    @RequestMapping("/queryWorkOrderPlanForTimeRegin")
    public List<WorkOrderPlan> queryWorkOrderPlanForTimeRegin(@RequestBody WorkOrderPlan workOrderPlan){
        countWorkOrderPlanService=new CountWorkOrderPlanService();
        List<WorkOrderPlan> workOrderPlanList=new ArrayList<WorkOrderPlan>();
        //1 校验时间参数是否为空，且开始时间不能大于结束时间
        if((workOrderPlan.getPlan_start_time()==null)&&(workOrderPlan.getPlan_end_time()==null)&&(workOrderPlan.getPlan_start_time().getTime()>workOrderPlan.getPlan_end_time().getTime())){
            return null;
        }else {
            //2 调用业务逻辑层queryWorkOrderPlanForTimeRegin方法查询数据
            workOrderPlanList=countWorkOrderPlanService.queryWorkOrderPlanForTimeRegin(workOrderPlan);
        }
        return workOrderPlanList;
    }
    /**
     * 统计已生成工单的工单计划数
     * @return
     */
    @RequestMapping("/queryWorkOrderPlanComplete")
    public List<WorkOrderPlan> queryWorkOrderPlanComplete(){
        countWorkOrderPlanService=new CountWorkOrderPlanService();
        List<WorkOrderPlan> workOrderPlanList=new ArrayList<WorkOrderPlan>();
        workOrderPlanList=countWorkOrderPlanService.queryWorkOrderPlanComplete();
        return workOrderPlanList;
    }
    /**
     * 统计未生成工单的工单计划数
     * @return
     */
    @RequestMapping("/queryWorkOrderPlanNotComplete")
    public List<WorkOrderPlan> queryWorkOrderPlanNotComplete(){
        countWorkOrderPlanService=new CountWorkOrderPlanService();
        List<WorkOrderPlan> workOrderPlanList=new ArrayList<WorkOrderPlan>();
        workOrderPlanList=countWorkOrderPlanService.queryWorkOrderPlanNotComplete();
        return workOrderPlanList;
    }
    /**
     * 统计提交的工单计划数
     * @return
     */
    @RequestMapping("/queryWorkOrderPlanAll")
    public List<WorkOrderPlan> queryWorkOrderPlanAll(){
        countWorkOrderPlanService=new CountWorkOrderPlanService();
        List<WorkOrderPlan> workOrderPlanList=new ArrayList<WorkOrderPlan>();
        workOrderPlanList=countWorkOrderPlanService.queryWorkOrderPlanAll();
        return workOrderPlanList;
    }

}
