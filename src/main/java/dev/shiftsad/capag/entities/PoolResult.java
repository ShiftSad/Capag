package dev.shiftsad.capag.entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Entity
@Table(name = "pool_results")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PoolResult {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "values_id", nullable = false)
    private Values values;

    @Enumerated(EnumType.STRING)
    @Column(name = "result_value", nullable = false)
    private PoolResultValue resultValue;

    @Column(name = "date", nullable = false)
    private Instant date;

    enum PoolResultValue {
        REF, TABLE, NONE
    }
}