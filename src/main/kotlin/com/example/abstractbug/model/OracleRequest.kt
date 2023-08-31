package com.example.abstractbug.model

import jakarta.persistence.Entity
import jakarta.persistence.Table

@Entity
@Table(name = "oracle_request")
open class OracleRequest() : AbstractRequest() {}