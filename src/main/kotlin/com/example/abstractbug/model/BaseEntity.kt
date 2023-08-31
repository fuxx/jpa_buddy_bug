package com.example.abstractbug.model

import jakarta.persistence.*
import java.sql.Timestamp
import java.time.Instant

@MappedSuperclass
open class BaseEntity(

        // Primary ID - Internal ID
        @Id
        @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ORACLE_REQUESTS_SEQ")
        @SequenceGenerator(name = "ORACLE_REQUESTS_SEQ", sequenceName = "ORACLE_REQUESTS_SEQ")
        @Column(nullable = false)
        open val id: Long? = null,

        // Creation date
        @Column(updatable = false)
        open val createdAt: Timestamp = Timestamp.from(Instant.now()),

        // Modify date
        open val updatedAt: Timestamp? = null

) {
}



