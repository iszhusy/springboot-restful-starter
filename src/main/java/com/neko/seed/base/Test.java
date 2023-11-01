package com.neko.seed.base;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.security.SecureRandom;

/**
 * @Author: zhusiyuan.nn@bytedance.com
 * @Date: 2023/9/7 17:51
 * @Version: v1.0.0
 * @Description: TODO
 **/
public class Test {
        private static final String CHARACTERS = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";

        public static void main(String[] args) {
            output();
        }

        public static String generateKey(int length) {
            StringBuilder sb = new StringBuilder(length);

            SecureRandom random = new SecureRandom();
            for (int i = 0; i < length; i++) {
                int randomIndex = random.nextInt(CHARACTERS.length());
                char randomChar = CHARACTERS.charAt(randomIndex);
                sb.append(randomChar);
            }

            return sb.toString();
        }

        public static int getLen() {
            String s = "ADJ233-Global-Non-China tax provision-current and deferred - quarterly estimate";
            return s.length();
        }

        public static void output() {
            String excelFilePath = "input2.xlsx";
            String sqlFilePath = "output.sql";

            try {
                System.out.println(System.getProperty("user.dir"));
                FileInputStream excelFile = new FileInputStream(new File(excelFilePath));
                Workbook workbook = new XSSFWorkbook(excelFile);
                Sheet sheet = workbook.getSheetAt(0);

                FileWriter sqlFileWriter = new FileWriter(sqlFilePath);
                BufferedWriter bufferedWriter = new BufferedWriter(sqlFileWriter);
                DataFormatter dataFormatter = new DataFormatter();
                // 遍历Excel行
                int count = 0;
                for (Row row : sheet) {
                    count++;
                    Cell cell1 = row.getCell(1);
                    Cell cell2 = row.getCell(2);

                    // 假设第一列是名称，第二列是值
                    String voucherUniqNo = dataFormatter.formatCellValue(cell1);
                    String shardingKey = dataFormatter.formatCellValue(cell2);

                    // 生成SQL语句
                    String sqlStatement = String.format("UPDATE fin_voucher set voucher_status = 'NONEED_SEND' " +
                            "where voucher_uniq_no = \"%s\" and voucher_sharding_key = %s;", voucherUniqNo, shardingKey);

                    // 写入SQL文件
                    bufferedWriter.write(sqlStatement);
                    bufferedWriter.newLine();
                }

                bufferedWriter.close();
                sqlFileWriter.close();
                workbook.close();

                System.out.printf("SQL文件生成成功！count:%s", count);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
}
