package org.example.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name = "planet")
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Planet {
    @Id
    private String id;
    @Column(name = "name")
    private String name;
}
