package com.odin.officeworker.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name="history")
public class HistoryEntity {
    @Id
    private String id;
    @Column
    private Timestamp date;
    @Column
    private String nick;
    @Column
    private String boss;
    @Column
    private int score;
}
