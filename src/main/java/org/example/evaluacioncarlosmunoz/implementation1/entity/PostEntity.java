package org.example.evaluacioncarlosmunoz.implementation1.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "posts")
public class PostEntity {
    @Id
    private Long id;
    private Long userId;
    private String title;
    @Column(length = 1000)
    private String body;
}
