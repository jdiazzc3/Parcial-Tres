package com.co.diaz.usuario.entity.usuarios.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Table
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Alumno {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    private String nombre;
    private String apellido;
    private String email;

    @Column(name = "create_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createAt;

    @PrePersist
    private void prePersist() {
        this.createAt = new Date();
    }
}
