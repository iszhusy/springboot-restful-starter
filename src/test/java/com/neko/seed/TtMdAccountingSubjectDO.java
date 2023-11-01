package com.neko.seed;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Data
public class TtMdAccountingSubjectDO implements Serializable {
    @Id
    private Long id;
    private String mdmCode;
    private Integer status;
    private Integer level;
    private String language;
    private String sourceCode;
    private String name;
    private String code;
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
    private LocalDateTime startTime;
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
    private LocalDateTime endTime;
    private String remark;
    private Integer accountingSubjectLevel;
    private String accountType;
    private Integer isCashOrEquivalent;
    private String cashBorrowField;
    private String cashLoanField;
    private String accountCashType;
    private String parentCode;
    private Integer isRelateUniqCashField;
    private String assetsDebtField;
    private String assetsDebtComputeRule;
    private String profitField;
    private String profitComputeRule;
    private String childRange;
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
    private LocalDateTime effectiveTime;
    private String budgetSubjectMdmCode;
    private String usingModules;
    private String cashBorrowFieldCode;
    private String cashLoanFieldCode;
    private String prcReportField;
    private String ifrsReportField;
    private String prcReportFieldCode;
    private String ifrsReportFieldCode;
    private static final long serialVersionUID = 4640993965369456368L;
    private String createBy;
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createTime;
    private String updateBy;
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
    private LocalDateTime updateTime;
    private String updateReason;
    @Transient
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
    private LocalDateTime updateTimeStartDate;
    @Transient
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
    private LocalDateTime updateTimeEndDate;
    @Transient
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createTimeStartDate;
    @Transient
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createTimeEndDate;
}