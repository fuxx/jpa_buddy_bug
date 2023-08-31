package com.example.abstractbug.model

import com.fasterxml.jackson.databind.node.ObjectNode
import io.hypersistence.utils.hibernate.type.json.JsonBinaryType
import jakarta.persistence.*
import jakarta.persistence.GenerationType.AUTO
import org.hibernate.annotations.Type
import java.util.*

@MappedSuperclass
open class AbstractRequest(

        // Primary UUID - Public ID, used for REST API
    @GeneratedValue(strategy = AUTO)
        @Column(name = "public_id", columnDefinition = "UUID default gen_random_uuid()")
        open val publicId: UUID? = null,

        // The operation meant to perform
    @Column(nullable = false, updatable = false)
        open val operation: String? = null,

        // Current status of the Request
    @Enumerated(EnumType.STRING)
        @Column(nullable = false)
        open val status: Status = Status.QUEUED,

        // Request JSON, which contains original JSON request
    @Type(value = JsonBinaryType::class)
        @Column(nullable = true)
        open val request: ObjectNode? = null,

        // The source of the request
    @Enumerated(EnumType.STRING)
        @Column(nullable = false)
        open val source: Source? = null,

        // The destination of the request
    @Enumerated(EnumType.STRING)
        @Column(nullable = false)
        open val destination: Destination? = null,

        // Requester of the requested operation
    @Column(nullable = false, updatable = false)
        open val requestedBy: String? = null,

        // Resulting object, stored as JSONB for schemaless persistence
    @Type(value = JsonBinaryType::class)
        @Column(nullable = true)
        open val result: ObjectNode? = null,

    ) : BaseEntity() {

    enum class Status {
        QUEUED,
        SKIPPED,
        PENDING,
        RUNNING,
        CANCELED,
        FAILED,
        SUCCESS
    }

    enum class Source {
        ABC
    }

    enum class Destination {
        EFG
    }
}



