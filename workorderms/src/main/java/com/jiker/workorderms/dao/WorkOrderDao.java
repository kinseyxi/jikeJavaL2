package com.jiker.workorderms.dao;
import com.jiker.workorderms.bean.WorkOrder;
import com.jiker.workorderms.bean.WorkOrderPlan;
import com.jiker.workorderms.util.UtilJDBC;
import com.jiker.workorderms.util.Utils;

import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

/**
 * 封装工单表相关的非共有数据库操作
 */
public class WorkOrderDao {
    Utils utils = new Utils();

    /**
     * 根据SQL查询workOrderPlan，返回结果封装在List中
     *
     * @param sql
     * @return workOrdersPlanList
     */
    public List<WorkOrderPlan> queryWorkOrder(String sql) {
        List<WorkOrderPlan> workOrdersPlanList = new ArrayList<>();
        //连接数据库处理....
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            conn = UtilJDBC.getConnection();
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                WorkOrderPlan workOrderPlan = new WorkOrderPlan();
                workOrderPlan.setNumber(rs.getString(2));
                workOrderPlan.setName(rs.getString(3));
                workOrderPlan.setContent(rs.getString(4));
                workOrderPlan.setCycle(rs.getString(5));
                workOrderPlan.setPlan_start_time(rs.getDate(6));
                workOrderPlan.setPlan_end_time(rs.getDate(7));
                workOrderPlan.setRole(rs.getString(8));
                workOrderPlan.setExecutor(rs.getString(9));
                workOrderPlan.setStatus(rs.getString(10));
                workOrdersPlanList.add(workOrderPlan);
            }

            //rs.getMetaData();
        } catch (SQLException e) {//执行与数据库建立连接需要抛出SQL异常
            e.printStackTrace();
        } finally {
            UtilJDBC.close(rs, stmt, null, conn);
        }
        return workOrdersPlanList;
    }

    /**
     * 向数据库批量提交工单数据
     *
     * @param workOrderList
     * @return result
     */
    public boolean insertWorkOrder(List<WorkOrder> workOrderList) {
        Connection conn = null;
        PreparedStatement psmt = null;
        String sql = "insert into workorderms.workorder(number,name,content,start_time,end_time,role,executor) values(?,?,?,?,?,?,?)";
        boolean result = false;
        try {
            conn = UtilJDBC.getConnection();
            psmt = conn.prepareStatement(sql);
            for (int i = 0; i < workOrderList.size(); i++) {
                psmt.setString(1, workOrderList.get(i).getNumber());
                psmt.setString(2, workOrderList.get(i).getName());
                psmt.setString(3, workOrderList.get(i).getContent());
                psmt.setTimestamp(4, utils.to_sqldate(workOrderList.get(i).getStart_time()));
                psmt.setTimestamp(5, utils.to_sqldate(workOrderList.get(i).getEnd_time()));
//                psmt.setTimestamp(4, new Timestamp(workOrderList.get(i).getStart_time().getTime()));
//                psmt.setTimestamp(5, new Timestamp(workOrderList.get(i).getEnd_time().getTime()));
                psmt.setString(6, workOrderList.get(i).getRole());
                psmt.setString(7, workOrderList.get(i).getExecutor());
                //连接数据库处理....
                psmt.addBatch();
            }
            //1 提交SQL命令
            psmt.executeBatch();

            result = true;
        } catch (SQLException e) {//2 执行与数据库建立连接需要抛出SQL异常
            e.printStackTrace();
        } finally {//3 释放资源
            UtilJDBC.close(null, null, psmt, conn);
        }
        return result;
    }
}
