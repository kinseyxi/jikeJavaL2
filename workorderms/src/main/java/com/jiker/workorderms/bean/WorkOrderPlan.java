package com.jiker.workorderms.bean;


import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class WorkOrderPlan {
    private Integer id;
    private String number;
    private String name;
    private String content;
    private String cycle;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date plan_start_time;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date plan_end_time;
    private String role;
    private String executor;
    private String status;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getCycle() {
        return cycle;
    }

    public void setCycle(String cycle) {
        this.cycle = cycle;
    }

    public Date getPlan_start_time() {
        return plan_start_time;
    }

    public void setPlan_start_time(Date plan_start_time) {
        this.plan_start_time = plan_start_time;
    }

    public Date getPlan_end_time() {
        return plan_end_time;
    }

    public void setPlan_end_time(Date plan_end_time) {
        this.plan_end_time = plan_end_time;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getExecutor() {
        return executor;
    }

    public void setExecutor(String executor) {
        this.executor = executor;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "WorkOrderPlan{" +
                "number='" + number + '\'' +
                ", name='" + name + '\'' +
                ", content='" + content + '\'' +
                ", cycle='" + cycle + '\'' +
                ", plan_start_time=" + plan_start_time +
                ", plan_end_time=" + plan_end_time +
                ", role='" + role + '\'' +
                ", executor='" + executor + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
