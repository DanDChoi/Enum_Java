package com.example.demo.after;

import javax.persistence.*;

@Entity
public class EnumContract {
    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String company;

    @Column(nullable = false)
    private double commission; //수수료

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private CommissionType commissionType; //수수료 타입 (ex: 퍼센테이지, 금액)

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private CommissionCutting commissionCutting; //수수료 절삭 (ex: 반올림, 올림, 버림)

    public enum CommissionType {
        PERCENT("percent"),
        MONEY("money");

        private String value;

        CommissionType(String value){
            this.value = value;
        }

        public String getKey(){
            return name();
        }

        public String getValue(){
            return value;
        }
    }

    public enum CommissionCutting{
        ROUND("round"),
        CEIL("ceil"),
        FLOOR("floor");

        private String value;

        CommissionCutting(String value){
            this.value = value;
        }

        public String getKey(){
            return name();
        }

        public String getValue(){
            return value;
        }
    }

    public EnumContract() {}

    public EnumContract(String company, double commission, CommissionType commissionType, CommissionCutting commissionCutting){
        this.company = company;
        this.commission = commission;
        this.commissionType = commissionType;
        this.commissionCutting = commissionCutting;
    }

    public Long getId(){
        return id;
    }

    public String getCompany(){
        return company;
    }

    public double getCommission(){
        return commission;
    }

    public CommissionType getCommissionType(){
        return commissionType;
    }

    public CommissionCutting getCommissionCutting(){
        return commissionCutting;
    }


}
