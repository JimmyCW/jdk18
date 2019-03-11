package com.wx.jddk.classloader;

/**
 * @author weixing
 * @date 2019/3/10
 **/
public class Test1 {


    private static String LOAN_DTL = "UPDATE `jinfu_loan_pro`.`fp_loan_dtl` SET `APPL_ID` = %s, `PRODUCT_ID` = %s, `LOAN_NAME` = %s, `ACCT_NO` = %s, `USER_ID` = %s, `BANK_CARD_ID` = %d, `LOAN_DT` = %s, `LOAN_AMT` = %.2f, `RSRV_AMT` = %.2f, `TRX_MEMO` = %s, `REPAYED_AMT` = %.2f, `DUE_DT` = %s, `BALANCE` = %.2f, `TRANSFER_TS` = %s, `SETTLE_DATE` = %s, `TRANSFER_STAT` = %s, `TERM_LEN` = %d, `TERM_TYPE` = %s, `REPAY_MODE` = %s, `REPAY_MODE_NAME` = %s, `LOAN_RT` = %.2f, `LOAN_RT_TYPE` = %s, `SERVICE_FEE_RT` = %.2f, `SERVICE_FEE_MONTH_RT` = %.2f, `LOAN_STAT` = %s, `FUND_CODE` = %s, `FINANCE_SOURCE_ID` = %d, `IS_DEPOSITORY` = %d, `IS_WITHDRAW` = %d, `WITHDRAW_DATE` = %s, `TEST_SOURCE` = %s, `VIOLATE_RT` = %.2f, `CREATE_OPID` = %s, `CREATE_TS` = %s, `LAST_MNT_OPID` = %s, `LAST_MNT_TS` = %s, `VERSION_CT` = %d, `import_tag` = %d WHERE `LOAN_ID` = %s;";
    private static String REAY_DTL = "INSERT INTO `jinfu_loan_pro`.`fp_repay_dtl` (" +
            "`REPAY_ID`," +
            "`LOAN_ID`," +
            "`ACCT_NO`," +
            "`REPAY_DT`," +
            "`REPAY_PRIN_AMT`," +
            "`REPAY_TOTAL`," +
            "`REPAY_FEE`," +
            "`REPAY_INTR`," +
            "`REPAY_FINE`," +
            "`REPAY_PENA`," +
            "`REMIT_INTR`," +
            "`REMIT_FEE`," +
            "`REMIT_FINE`," +
            "`REMIT_PENA`," +
            "`DEBT_FEE`," +
            "`RETURN_AMT`," +
            "`BALANCE_TOTAL`," +
            "`BALANCE_USED`," +
            "`BALANCE`," +
            "`SURPLUS_CAPTIAL`," +
            "`TRANS_MODE`," +
            "`REMARK`," +
            "`REPAY_DATE`," +
            "`CREATE_OPID`," +
            "`CREATE_TS`," +
            "`LAST_MNT_OPID`," +
            "`LAST_MNT_TS`," +
            "`VERSION_CT`," +
            "`STATUS`," +
            "`REPAY_TYPE`," +
            "`import_tag` " +
            ")" +
            "VALUES" +
            "(" +
            "%s," +
            "%s," +
            "%s," +
            "%s," +
            "%.2f," +
            "%.2f," +
            "%.2f," +
            "%.2f," +
            "%.2f," +
            "%.2f," +
            "%.2f," +
            "%.2f," +
            "%.2f," +
            "%.2f," +
            "%.2f," +
            "%.2f," +
            "%.2f," +
            "%.2f," +
            "%.2f," +
            "%.2f," +
            "%s," +
            "%s," +
            "%s," +
            "%s," +
            "%s," +
            "%s," +
            "%s," +
            "%d," +
            "%s," +
            "%s," +
            "%d " +
            ") " +
            "ON DUPLICATE KEY UPDATE `LOAN_ID` = %s," +
            "`ACCT_NO` = %s," +
            "`REPAY_DT` = %s," +
            "`REPAY_PRIN_AMT` = %.2f," +
            "`REPAY_TOTAL` = %.2f," +
            "`REPAY_FEE` = %.2f," +
            "`REPAY_INTR` = %.2f," +
            "`REPAY_FINE` = %.2f," +
            "`REPAY_PENA` = %.2f," +
            "`REMIT_INTR` = %.2f," +
            "`REMIT_FEE` = %.2f," +
            "`REMIT_FINE` = %.2f," +
            "`REMIT_PENA` = %.2f," +
            "`DEBT_FEE` = %.2f," +
            "`RETURN_AMT` = %.2f," +
            "`BALANCE_TOTAL` = %.2f," +
            "`BALANCE_USED` = %.2f," +
            "`BALANCE` = %.2f," +
            "`SURPLUS_CAPTIAL` = %.2f," +
            "`TRANS_MODE` = %s," +
            "`REMARK` = %s," +
            "`REPAY_DATE` = %s," +
            "`CREATE_OPID` = %s," +
            "`CREATE_TS` = %s," +
            "`LAST_MNT_OPID` = %s," +
            "`LAST_MNT_TS` = %s," +
            "`VERSION_CT` = %d," +
            "`STATUS` = %s," +
            "`REPAY_TYPE` = %s," +
            "`import_tag` = %d;";

    private static String REPAY_SCHD = "UPDATE `jinfu_loan_pro`.`fp_repay_schd` " +
            "SET `LOAN_ID` = %s," +
            "`ACCT_NO` = %s," +
            "`START_DT` = %s," +
            "`DUE_DT` = %s," +
            "`PAY_DT` = %s," +
            "`SEQ_NO` = %d," +
            "`PRIN_PY_AMT` = %.2f," +
            "`PRIN_PD_AMT` = %.2f," +
            "`INTR_PY_AMT` = %.2f," +
            "`INTR_PD_AMT` = %.2f," +
            "`PRIN_FINE_PY_AMT` = %.2f," +
            "`PRIN_FINE_PD_AMT` = %.2f," +
            "`INTR_FINE_PY_AMT` = %.2f," +
            "`INTR_FINE_PD_AMT` = %.2f," +
            "`FEE_PY_AMT` = %.2f," +
            "`FEE_PD_AMT` = %.2f," +
            "`PENA_PD_AMT` = %.2f," +
            "`REMIT_INTR` = %.2f," +
            "`REMIT_FEE` = %.2f," +
            "`REMIT_FINE` = %.2f," +
            "`REMIT_PENA` = %.2f," +
            "`STATUS` = %s," +
            "`IS_OVERDUE` = %d," +
            "`IS_DEBT` = %d," +
            "`DEBT_DATE` = %s," +
            "`CREATE_OPID` = %s," +
            "`CREATE_TS` = %s," +
            "`LAST_MNT_OPID` = %s," +
            "`LAST_MNT_TS` = %s," +
            "`VERSION_CT` = %d," +
            "`import_tag` = %d " +
            "WHERE" +
            "`SCHD_ID` = %s;";
    
    public static void main(String[] args) {
        String loanDtl = String.format(LOAN_DTL, "'302130649605021000'", "'L01006'", "'小烟贷'", "'17091200000062'"
                , "'UC0000055223'", 9057, "'2017-11-06'", 100000.00, 0.00, "NULL", 100000.00,
                "'2018-11-06'", 0.00, "'2017-11-06 17:55:48.000000'", "'2019-02-24 00:00:00.000000'",
                "'02'", 12, "'3'", "'08'", "'等本等息'", 0.01000000, "'MONTH'", 0.03000000, 0.00000000,
                "'04'", "'OWN'", 1, 0, 0, "NULL", "NULL", 0.00000000, "'system'", "'2017-11-06 17:55:08.000000'",
                "'UM0000000418'", "'2019-02-27 16:20:35.529000'",
                37, 0, "'L302130649605021000'");
        System.out.println(loanDtl);
        String repayDtl = String.format(REAY_DTL, "'1902270000285'",
                "'L303062429275910039'",
                "'0'",
                "'2019-02-26'",
                9164.08,
                117.88,
                0.00,
                953.80,
                0.00,
                0.00,
                0.00,
                0.00,
                71.54,
                0.00,
                0.00,
                0.00,
                0.00,
                -10000.00,
                10000.00,
                47690.18,
                "'4'",
                "'收付捷代扣'",
                "'2019-02-26 00:00:00.000000'",
                "'UM0000000418'",
                "'2019-02-27 14:28:59.531000'",
                "'UM0000000418'",
                "'2019-02-27 14:28:59.549000'",
                0,
                "'1'",
                "'05'",
                0, "'L303062429275910039'",
                "'0'",
                "'2019-02-26'",
                9164.08,
                117.88,
                0.00,
                953.80,
                0.00,
                0.00,
                0.00,
                0.00,
                71.54,
                0.00,
                0.00,
                0.00,
                0.00,
                -10000.00,
                10000.00,
                47690.18,
                "'4'",
                "'收付捷代扣'",
                "'2019-02-26 00:00:00.000000'",
                "'UM0000000418'",
                "'2019-02-27 14:28:59.531000'",
                "'UM0000000418'",
                "'2019-02-27 14:28:59.549000'",
                0,
                "'1'",
                "'05'",
                0);
        System.out.println(repayDtl);
        String repaySchd = String.format(REPAY_SCHD, "'L303062429275910039'",
                "'0'",
                "'2019-01-25'",
                "'2019-02-24'",
                "'2019-02-26'",
                8,
                9164.08,
                9164.08,
                953.80,
                953.80,
                0.00,
                0.00,
                0.00,
                0.00,
                0.00,
                0.00,
                0.00,
                0.00,
                0.00,
                71.54,
                0.00,
                "'22'",
                1,
                0,
                "NULL",
                "''",
                "'2018-06-24 16:35:36.496000'",
                "'UM0000000418'",
                "'2019-02-27 14:28:59.542000'",
                0,
                0,
                "'L303062429275910039_8'");
        System.out.println(repaySchd);
    }
}
