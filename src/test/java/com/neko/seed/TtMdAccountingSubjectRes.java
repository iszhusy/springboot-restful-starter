package com.neko.seed;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.List;

/**
 * @Author: zhusiyuan.nn@bytedance.com
 * @Date: 2023/10/19 20:26
 * @Version: v1.0.0
 * @Description: TODO
 **/

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class TtMdAccountingSubjectRes {
    private List<TtMdAccountingSubjectDO> data;
}
