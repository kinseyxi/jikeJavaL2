package com.jiker.workorderms.controller;

import com.jiker.workorderms.bean.WorkOrderPlan;
import com.jiker.workorderms.service.WorkOrderPlanService;
import com.sun.istack.internal.NotNull;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

@RestController
public class WorkOrderPlanController {

    @RequestMapping("/createWorkOrderPlan")
    public String CreateWorkOrderPlan(@RequestBody WorkOrderPlan workOrderPlan){
        WorkOrderPlanService workOrderPlanService = new WorkOrderPlanService();
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        String resDate=sdf.format(new Date());
        int result=0;   //用于接收SQL执行返回码

        //1、判断前端传过来的数据是否满足要求
        //需要处理字段Number、Name、Content、Cycle、Role、Executor
        if((workOrderPlan.getPlan_start_time()==null) || (workOrderPlan.getPlan_end_time()==null) || (workOrderPlan.getPlan_start_time().getTime()>=workOrderPlan.getPlan_end_time().getTime())){
            return "参数不能为空或开始时间大于等于结束时间";
        }
        if(workOrderPlan.getNumber()==null || workOrderPlan.getName()==null || workOrderPlan.getContent()==null || workOrderPlan.getCycle()==null ||
        workOrderPlan.getRole()==null || workOrderPlan.getExecutor()==null){
            return "参数Number、Name、Content、Cycle、Role、Executor  不能为空";
        }

        result=workOrderPlanService.CreateWorkOrderPlan(workOrderPlan);
        //根据返回结果值,完成工单计划成功或失败逻辑处理
        if(result==0){
            return resDate+":创建工单计划失败";
        }else {
            return resDate+":创建工单计划成功";
        }

    }

    /**
     * 根据工单号编辑工单计划功能
     * @param workOrderPlan
     * @return
     */

    @RequestMapping("/editWorkOrderPlan")
    public String EditWorkOrderPlan(@RequestBody WorkOrderPlan workOrderPlan){
        WorkOrderPlanService workOrderPlanService = new WorkOrderPlanService();
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        String resDate=sdf.format(new Date());
        int result=0;   //用于接收SQL执行返回码
        //1、判断前端传过来的数据是否满足要求
        if((workOrderPlan.getPlan_start_time()==null) || (workOrderPlan.getPlan_end_time()==null) || (workOrderPlan.getPlan_start_time().getTime()>=workOrderPlan.getPlan_end_time().getTime())){
            return "参数不能为空或开始时间大于等于结束时间";
        }
        //需要处理字段Content、Executor、工单号
        if(workOrderPlan.getNumber()==null ||workOrderPlan.getContent()==null ||workOrderPlan.getExecutor()==null){
            return "参数 number、Content、Executor不能为空";
        }
        result=workOrderPlanService.editWorkPlan(workOrderPlan);
        //根据返回结果值,完成工单计划成功或失败逻辑处理
        if(result==0){
            return resDate+":编辑工单计划失败";
        }else {
            return resDate+":编辑工单计划成功";
        }
    }

    @RequestMapping("/deleteWorkOrderPlan")
    public String deleteWorkOrderPlan(@RequestParam @Validated  @NotNull String number){
        WorkOrderPlanService workOrderPlanService = new WorkOrderPlanService();
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        String resDate=sdf.format(new Date());
        int result=0;   //用于接收SQL执行返回码
        //删除确认
        System.out.println("请确认是否删除Y/N");
        Scanner scanner=new Scanner(System.in);
        while (scanner.hasNext()){
            String str = scanner.next();
            if(!str.equalsIgnoreCase("Y") && !str.equalsIgnoreCase("N")){
                System.out.println("输入不合法请重新输入！");
                continue;
            }else if(str.equalsIgnoreCase("Y")){
                break;
            }else {
                return "确认不删除！";
            }

        }
        result=workOrderPlanService.deleteWorkPlanbyNumber(number);
        //根据返回结果值,完成工单计划成功或失败逻辑处理
        if(result==0){
            return resDate+":删除工单计划失败";
        }else {
            return resDate+":删除工单计划成功";
        }
    }
}
