package com.example.enterprise_application.model;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class JobHistoryID implements Serializable {
    @Column(name = "jobId")
    private Integer jobId;

    @Column(name = "employeeId")
    private Integer employeeId;
}
