/*
 * @Author: jackning 270580156@qq.com
 * @Date: 2024-05-14 09:40:11
 * @LastEditors: jackning 270580156@qq.com
 * @LastEditTime: 2025-03-03 23:17:45
 * @Description: bytedesk.com https://github.com/Bytedesk/bytedesk
 *   Please be aware of the BSL license restrictions before installing Bytedesk IM – 
 *  selling, reselling, or hosting Bytedesk IM as a service is a breach of the terms and automatically terminates your rights under the license.
 *  Business Source License 1.1: https://github.com/Bytedesk/bytedesk/blob/main/LICENSE 
 *  contact: 270580156@qq.com 
 *  联系：270580156@qq.com
 * Copyright (c) 2024 by bytedesk.com, All Rights Reserved. 
 */
package com.bytedesk.core.quartz;

import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bytedesk.core.base.BaseRestController;
import com.bytedesk.core.utils.JsonResult;

import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;

/**
 * 
 */
@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/quartz")
public class QuartzRestController extends BaseRestController<QuartzRequest> {

    private QuartzService quartzService;

    @Override
    public ResponseEntity<?> queryByOrg(QuartzRequest request) {

        Page<QuartzResponse> pageResult = quartzService.queryByOrg(request);

        return ResponseEntity.ok(JsonResult.success(pageResult));
    }


    @Override
    public ResponseEntity<?> queryByUser(QuartzRequest request) {

        Page<QuartzResponse> pageResult = quartzService.queryByUser(request);

        return ResponseEntity.ok(JsonResult.success(pageResult));
    }

    @Override
    public ResponseEntity<?> create(@RequestBody QuartzRequest request) {

        QuartzResponse response = quartzService.create(request);
        if (response == null) {
            return ResponseEntity.badRequest().body(JsonResult.error("jobName already exists"));
        }

        return ResponseEntity.ok(JsonResult.success(response));
    }

    @Override
    public ResponseEntity<?> update(@RequestBody QuartzRequest request) {

        QuartzResponse response = quartzService.update(request);
        if (response == null) {
            return ResponseEntity.badRequest().body(JsonResult.error("uid not exists"));
        }

        return ResponseEntity.ok(JsonResult.success(response));
    }

    @Override
    public ResponseEntity<?> delete(@RequestBody QuartzRequest request) {

        quartzService.delete(request);

        return ResponseEntity.ok(JsonResult.success());
    }

    //
    @PostMapping("/startJob")
    public ResponseEntity<?> startJob(@RequestBody QuartzRequest request) {
        quartzService.startJob(request);
        return ResponseEntity.ok(JsonResult.success(request));
    }

    @PostMapping("/pauseJob")
    public ResponseEntity<?> pauseJob(@RequestBody QuartzRequest request) {
        quartzService.pauseJob(request);
        return ResponseEntity.ok(JsonResult.success(request));
    }

    @PostMapping("/resumeJob")
    public ResponseEntity<?> resumeJob(@RequestBody QuartzRequest request) {
        quartzService.resumeJob(request);
        return ResponseEntity.ok(JsonResult.success(request));
    }

    @PostMapping("/deleteJob")
    public ResponseEntity<?> deleteJob(@RequestBody QuartzRequest request) {
        quartzService.deleteJob(request);
        return ResponseEntity.ok(JsonResult.success(request));
    }

    @Override
    public Object export(QuartzRequest request, HttpServletResponse response) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'export'");
    }

}
