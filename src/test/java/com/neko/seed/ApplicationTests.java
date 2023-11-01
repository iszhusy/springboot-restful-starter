package com.neko.seed;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.google.common.collect.MapDifference;
import com.google.common.collect.Maps;
import com.neko.seed.user.controller.TestController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationTests {
    @Test
    public void contextLoads() {
        ObjectMapper objectMapper = new ObjectMapper();
        File jsonFile = new File("会计科目_prd.json");
        File jsonFileEn = new File("会计科目_prd_en.json");

        try {
            // 从JSON文件中读取数据并转换为TtMdAccountingSubjectDO对象
            objectMapper.registerModule(new JavaTimeModule());
            Map<String, String> mem = new HashMap<>();
            TtMdAccountingSubjectRes res = objectMapper.readValue(jsonFile, TtMdAccountingSubjectRes.class);
            System.out.println(res.getData().size());
            for (TtMdAccountingSubjectDO ttMdAccountingSubjectDO : res.getData()) {
                if (ttMdAccountingSubjectDO.getIsCashOrEquivalent() != null
                        && ttMdAccountingSubjectDO.getIsCashOrEquivalent() == 0
                        && ttMdAccountingSubjectDO.getIsRelateUniqCashField() != null
                        && ttMdAccountingSubjectDO.getIsRelateUniqCashField() == 1) {
                    mem.put(ttMdAccountingSubjectDO.getCashLoanFieldCode(), ttMdAccountingSubjectDO.getCashLoanField());
                    mem.put(ttMdAccountingSubjectDO.getCashBorrowFieldCode(), ttMdAccountingSubjectDO.getCashBorrowField());
                }
            }

            // 从JSON文件中读取数据并转换为TtMdAccountingSubjectDO对象
            objectMapper.registerModule(new JavaTimeModule());
            Map<String, String> mem2 = new HashMap<>();
            TtMdAccountingSubjectRes res2 = objectMapper.readValue(jsonFileEn, TtMdAccountingSubjectRes.class);
            System.out.println(res2.getData().size());
            for (TtMdAccountingSubjectDO ttMdAccountingSubjectDO : res2.getData()) {
                if (ttMdAccountingSubjectDO.getIsCashOrEquivalent() != null
                        && ttMdAccountingSubjectDO.getIsCashOrEquivalent() == 0
                        && ttMdAccountingSubjectDO.getIsRelateUniqCashField() != null
                        && ttMdAccountingSubjectDO.getIsRelateUniqCashField() == 1) {
                    mem2.put(ttMdAccountingSubjectDO.getCashLoanFieldCode(), ttMdAccountingSubjectDO.getCashLoanField());
                    mem2.put(ttMdAccountingSubjectDO.getCashBorrowFieldCode(), ttMdAccountingSubjectDO.getCashBorrowField());
                }
            }

            MapDifference<String, String> difference = Maps.difference(mem, mem2);
            System.out.println(difference.entriesOnlyOnLeft());
            System.out.println(difference.entriesOnlyOnRight());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
