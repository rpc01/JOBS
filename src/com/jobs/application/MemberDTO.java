package com.jobs.application;

import com.jobs.domain.AbsStaffMember;

public class MemberDTO {

    private String name;
    private String address;
    private String phone;
    private double totalPaid;

    public MemberDTO(AbsStaffMember m) throws Exception{
        if (m == null) throw new Exception();
        this.name = m.getName();
        this.address = m.getAddress();
        this.phone = m.getPhone();
        this.totalPaid = m.getTotalPaid();
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getPhone() {
        return phone;
    }

    public double getTotalPaid() {
        return totalPaid;
    }
}
