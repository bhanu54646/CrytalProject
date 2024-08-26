package org.example.service;

import net.javacrumbs.shedlock.spring.annotation.SchedulerLock;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;


@Service
public class FirstCron {
   // @Scheduled(cron = "0 * * * * *")
    @SchedulerLock(name = "FIRST-CRON-SCHEDULING", lockAtLeastFor = "2m",lockAtMostFor = "3m")
    public void ScheduleTask() {
        System.out.println("hiii my first cron for checking");

    }


}
