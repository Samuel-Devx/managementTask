package com.ToList.management.DTO;


import com.ToList.management.Enum.TaskStatus;
import lombok.Data;

@Data
public class TaskUpdateDTO {

    private String title;
    private String description;
    private TaskStatus status;

}
