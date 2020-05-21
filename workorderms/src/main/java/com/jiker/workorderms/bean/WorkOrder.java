package com.jiker.workorderms.bean;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;
import java.util.Objects;

public class WorkOrder {
    private Integer id;
    private String number;
    private String name;
    private String content;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date start_time;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date end_time;
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

    public Date getStart_time() {
        return start_time;
    }

    public void setStart_time(Date start_time) {
        this.start_time = start_time;
    }

    public Date getEnd_time() {
        return end_time;
    }

    public void setEnd_time(Date end_time) {
        this.end_time = end_time;
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WorkOrder workOrder = (WorkOrder) o;
        return Objects.equals(number, workOrder.number) &&
                Objects.equals(name, workOrder.name) &&
                Objects.equals(content, workOrder.content) &&
                Objects.equals(start_time, workOrder.start_time) &&
                Objects.equals(end_time, workOrder.end_time) &&
                Objects.equals(role, workOrder.role) &&
                Objects.equals(executor, workOrder.executor) &&
                Objects.equals(status, workOrder.status);
    }

    @Override
    public int hashCode() {
        return Objects.hash(number, name, content, start_time, end_time, role, executor, status);
    }

    @Override
    public String toString() {
        return "WorkOrder{" +
                "number='" + number + '\'' +
                ", name='" + name + '\'' +
                ", content='" + content + '\'' +
                ", start_time=" + start_time +
                ", end_time=" + end_time +
                ", role='" + role + '\'' +
                ", executor='" + executor + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
