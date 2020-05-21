package com.jiker.workorderms.dao;

import com.jiker.workorderms.bean.WorkOrderPlan;
import com.jiker.workorderms.util.UtilJDBC;
import com.jiker.workorderms.util.Utils;

import java.sql.*;
import java.util.List;

/**
 * 封装工单计划表相关的非共有数据库操作
 */
public class WorkOrderPlanDao {
    Utils utils = new Utils();
    /**
     * 向工单计划表中插入数据
     * @param workOrderPlan
     * @return
     */
    public Integer insert(WorkOrderPlan workOrderPlan){
        Integer result=0;
        //根据数据库表, 连接数据库执行插入操作
        Connection conn=null;
        PreparedStatement ps=null;
        ResultSet rs =null;

        try {
            conn = UtilJDBC.getConnection();
            String sql = "INSERT INTO workorderms.workorder_plan (number,name,content,cycle,plan_start_time,plan_end_time,role,executor) VALUES(?,?,?,?,?,?,?,?)";
            ps = conn.prepareStatement(sql);
            ps.setString(1, workOrderPlan.getNumber());
            ps.setString(2, workOrderPlan.getName());
            ps.setString(3, workOrderPlan.getContent());
            ps.setString(4, workOrderPlan.getCycle());
            ps.setTimestamp(5, utils.to_sqldate(workOrderPlan.getPlan_start_time()));
            ps.setTimestamp(6, utils.to_sqldate(workOrderPlan.getPlan_end_time()));
            ps.setString(7, workOrderPlan.getRole());
            ps.setString(8, workOrderPlan.getExecutor());

            result=ps.executeUpdate();			//执行sql语句
            System.out.println("插入成功(*￣︶￣)");

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            UtilJDBC.close(rs,ps,null,conn);
        }
        return result;
    }

    /**
     * 根据SQL查询一个字段值
     * @param sql
     * @return
     */
    public String queryField(String sql,String field){
        Connection conn=null;
        Statement stmt=null;
        ResultSet rs =null;
        String result="";
        try {
            conn = UtilJDBC.getConnection();
            stmt=conn.createStatement();
            rs=stmt.executeQuery(sql);
            while(rs.next()){
                if(rs.getString(field)!=null){
                    result = rs.getString(field);
                }
            }
        }  catch (SQLException e) {//执行与数据库建立连接需要抛出SQL异常
            e.printStackTrace();
        }   finally {
            UtilJDBC.close(rs,stmt,null,conn);
        }
        return result;
    }

    public Boolean updateStatus(List<WorkOrderPlan> workOrderPlanList) {
        Boolean result=false;
        //根据数据库表, 连接数据库执行插入操作
        Connection conn=null;
        PreparedStatement ps=null;
        try {
            conn = UtilJDBC.getConnection();
            for(WorkOrderPlan workOrderPlan:workOrderPlanList){
                String sql="UPDATE workorderms.workorder_plan set status=? WHERE number=?";
                ps = conn.prepareStatement(sql);
                ps.setString(1, workOrderPlan.getStatus());
                ps.setString(2, workOrderPlan.getNumber());
                ps.executeUpdate();
            }
            result=true;
            System.out.println("工单计划表更新status更新成功");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            UtilJDBC.close(null,null,ps,conn);
        }
      return result;
    }

    public Integer update(WorkOrderPlan workOrderPlan) {
        Integer result=0;
        //根据数据库表, 连接数据库执行插入操作
        Connection conn=null;
        PreparedStatement ps=null;
        try {
            conn = UtilJDBC.getConnection();
                String sql="UPDATE workorderms.workorder_plan set content=?,plan_start_time=?,plan_end_time=?,executor=? WHERE number=?";
                ps = conn.prepareStatement(sql);
                ps.setString(1, workOrderPlan.getContent());
                ps.setTimestamp(2, new Timestamp(workOrderPlan.getPlan_start_time().getTime()));
                ps.setTimestamp(3, new Timestamp(workOrderPlan.getPlan_end_time().getTime()));
                ps.setString(4, workOrderPlan.getExecutor());
                ps.setString(5, workOrderPlan.getNumber());
                result = ps.executeUpdate();
            System.out.println("工单计划表更新成功");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            UtilJDBC.close(null,null,ps,conn);
        }
        return result;
    }

    public Integer deletebyNumber(String number) {
        Integer result=0;
        //根据数据库表, 连接数据库执行插入操作
        Connection conn=null;
        PreparedStatement ps=null;
        try {
            conn = UtilJDBC.getConnection();
            String sql="delete from workorderms.workorder_plan  WHERE number=?";
            ps = conn.prepareStatement(sql);
            ps.setString(1,number);
            result = ps.executeUpdate();
            System.out.println("工单计划表删除成功");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            UtilJDBC.close(null,null,ps,conn);
        }
        return result;
    }
}
