package com.ipiecoles.java.elastic.batchs.controller;

import com.ipiecoles.java.elastic.batchs.BatchImportConfig;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class BatchController {
    @Autowired
    private JobLauncher jobLauncher;

    @Resource(name = "importJSONDeputesActiviteFile")
    private Job jobActivite;

    @Resource(name = "importJSONDeputesFile")
    private Job jobGeneral;

    @RequestMapping("/general")
    public void handleGeneral(@RequestParam("filename")String filename) throws Exception{
        JobParameters params = new JobParametersBuilder().addString(BatchImportConfig.FILENAME, filename).toJobParameters();
        jobLauncher.run(jobGeneral, params);
    }

    @RequestMapping("/activite")
    public void handleActivite(@RequestParam("filename")String filename) throws Exception{
        JobParameters params = new JobParametersBuilder().addString(BatchImportConfig.FILENAME, filename).toJobParameters();
        jobLauncher.run(jobActivite, params);
    }
}
