package com.rocketseat.service_tasks;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "tasks")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TasksEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String title;
  private String email;
  private LocalDateTime dueDate;
  private boolean notified;

  public TasksEntity(TaskRequest taskRequest) {
    this.title = taskRequest.title();
    this.email = taskRequest.email();
    this.dueDate = taskRequest.dueDate();
    this.notified = taskRequest.notified() != null ? taskRequest.notified() : false;
  }

}
