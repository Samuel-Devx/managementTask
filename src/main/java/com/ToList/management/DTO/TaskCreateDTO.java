package com.ToList.management.DTO;

import jakarta.persistence.Entity;
import lombok.Data;

@Data
public class TaskCreateDTO {
    private String title;
    private String description;

}
