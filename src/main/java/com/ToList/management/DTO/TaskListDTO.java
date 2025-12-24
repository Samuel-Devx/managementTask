package com.ToList.management.DTO;

import com.ToList.management.Enum.TaskStatus;
import lombok.Data;

@Data
public class TaskListDTO {
    private Long id;
    private String title;
    private TaskStatus status;
}
