package com.ToList.management.DTO;

import com.ToList.management.Enum.TaskStatus;
import lombok.Data;

@Data
public class TaskStatusUpdateDTO {

    private TaskStatus status;

}
