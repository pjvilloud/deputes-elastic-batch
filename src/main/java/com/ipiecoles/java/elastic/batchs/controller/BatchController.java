package com.ipiecoles.java.elastic.batchs.controller;

import com.ipiecoles.java.elastic.batchs.BatchImportConfig;
import com.ipiecoles.java.elastic.batchs.model.DeputeData;
import com.ipiecoles.java.elastic.batchs.repository.DeputeDataRepository;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
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

    @Autowired
    private DeputeDataRepository deputeDataRepository;

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

    @GetMapping("/deputes")
    public Page<DeputeData> findAll(
            @RequestParam(value = "page", defaultValue = "0") Integer page,
            @RequestParam(value = "size", defaultValue = "15") Integer size,
            @RequestParam(value = "direction", defaultValue = "ASC") Sort.Direction direction,
            @RequestParam(value = "sort", defaultValue = "groupe_sigle") String sort
            ){
        return deputeDataRepository.findAll(PageRequest.of(page, size, direction, sort));
    }

    @GetMapping("/up")
    public Boolean up(){
        return true;
    }
}
