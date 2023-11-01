package com.neko.seed.user.controller;

import com.bytedance.ea.mussel.EnvEnum;
import com.bytedance.ea.mussel.MusselConfig;
import com.bytedance.ea.mussel.MusselProperties;
import com.bytedance.ea.mussel.model.PreviewTypeEnum;
import com.bytedance.ea.mussel.model.request.FileTempAuthPreviewRequest;
import com.bytedance.ea.mussel.model.request.FileTempPreviewRequest;
import com.bytedance.ea.mussel.model.response.FileMetaInfo;
import com.bytedance.ea.mussel.model.response.FileTempPreviewResponse;
import com.bytedance.ea.mussel.template.IMusselClient;
import com.bytedance.ea.mussel.template.impl.MusselDefaultClient;
import com.google.type.DateTime;
import com.neko.seed.base.entity.Result;
import com.neko.seed.user.data.SignInData;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Collections;

/**
 * @Author: zhusiyuan.nn@bytedance.com
 * @Date: 2023/7/20 19:15
 * @Version: v1.0.0
 * @Description: TODO
 **/
@RestController
@Slf4j
@RequestMapping("/test")
public class TestController {
    public Result test() {
        // 定义打印格式
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        // 格式化时间并打印
        String formattedDateTime = LocalDateTime.now().format(formatter);
        log.info(formattedDateTime);
        String channelID = "tos_7257724733393862956";
        MusselProperties properties = new MusselProperties();
        properties.setAppId("6982a64d-3be9-4603-913f-00b7da59f530");
        properties.setSecret("189712a438bd98e22e1");
        properties.setTosChannelId(Collections.singletonList("tos_7257724733393862956"));
        properties.setEnabled(true);
        properties.setEnv(EnvEnum.BOE);
        MusselConfig config = new MusselConfig(properties);
        IMusselClient client = new MusselDefaultClient(config);
//        FileMetaInfo info = client.createFileMetaInfo("AEP7259282916721574188.pdf", "boe/import/20230724/AEP7259185733922472236", channelID);
//        info.getFileId()
        FileTempAuthPreviewRequest req = FileTempAuthPreviewRequest.builder()
//                .fileId(info.getFileId())
                .fileName("AEP7259185733922472236.xlsx")
                .filePath("boe/import/20230724/AEP7259185733922472236")
                .channelId(channelID)
                .tenantId(1L)
                .previewType(PreviewTypeEnum.WPS)
                .build();
        FileTempPreviewResponse res = client.generateFileTempPreview(req);

        formattedDateTime = LocalDateTime.now().format(formatter);
        log.info(formattedDateTime);
        log.info(res.getData().getPreviewUrl());
        return null;
    }
}
