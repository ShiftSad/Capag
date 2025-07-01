package dev.shiftsad.capag.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.UuidGenerator;

import java.util.UUID;

@Entity
@Table(name = "values_data")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Values {
    @Id
    @GeneratedValue(generator = "UUID")
    @UuidGenerator
    @Column(name = "id", updatable = false, nullable = false)
    private UUID id;

    @Column(name = "is_table", nullable = false)
    private Boolean isTable;

    @Column(name = "filename", nullable = false)
    private String filename;

    @Column(name = "image_url", nullable = false)
    private String imageUrl;
}