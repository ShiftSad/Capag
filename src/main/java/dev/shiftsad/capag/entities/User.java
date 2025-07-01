package dev.shiftsad.capag.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.UuidGenerator;

import java.time.Instant;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "users")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    @GeneratedValue(generator = "UUID")
    @UuidGenerator
    @Column(name = "user_id", updatable = false, nullable = false)
    private UUID userId;

    @Column(name = "password_hash", nullable = false)
    private String passwordHash;

    @Column(name = "join_date", nullable = false)
    private Instant joinDate;

    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Column(name = "profile_picture_url")
    private String profilePictureUrl;

    @Column(name = "credits", nullable = false)
    private Integer credits = 0;

    @Enumerated(EnumType.STRING)
    @Column(name = "pix_key_type")
    private PixKeyType pixKeyType;

    @Column(name = "pix_key")
    private String pixKey;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Image> images;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<PoolResult> poolResults;

    enum PixKeyType {
        CPF,
        PHONE_NUMBER,
        EMAIL,
        RANDOM_KEY
    }
}