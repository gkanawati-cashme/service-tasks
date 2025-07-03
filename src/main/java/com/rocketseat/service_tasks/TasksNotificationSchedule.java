package com.rocketseat.service_tasks;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class TasksNotificationSchedule {

  private final TasksService tasksService;

  private TasksNotificationSchedule(TasksService tasksService) {
    this.tasksService = tasksService;
  }

  @Scheduled(fixedRate = 1000 * 60 * 60 * 24) // = 86400000ms (24 hours)
  public void checkAndNotifyTasks() {
    this.tasksService.sendNotificationForDueTasks();
  }

}
