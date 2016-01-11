package com.eitc.springbatchsample.jobRunners;

import com.eitc.springbatchsample.configs.ApplicationConfiguration;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class MainJobLauncher {

    @Autowired
    JobLauncher jobLauncher;

    @Autowired
    Job importUserJob;

    public static void main(String... args) throws JobParametersInvalidException, JobExecutionAlreadyRunningException, JobRestartException, JobInstanceAlreadyCompleteException {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfiguration.class);

        MainJobLauncher main = context.getBean(MainJobLauncher.class);

        JobExecution jobExecution = main.jobLauncher.run(main.importUserJob, new JobParameters());

        context.close();

    }

}
