package com.ToList.management.model;

import com.ToList.management.Enum.TaskStatus;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity(name = "tb_tarefa")
@Data
@NoArgsConstructor
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String descrition;
    @Enumerated(EnumType.STRING)
    private TaskStatus status;

    private LocalDateTime createAt;
    private LocalDateTime completeAt;

}
