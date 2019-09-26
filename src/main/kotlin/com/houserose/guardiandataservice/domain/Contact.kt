package com.houserose.guardiandataservice.domain

import org.neo4j.ogm.annotation.GeneratedValue
import org.neo4j.ogm.annotation.Id
import org.neo4j.ogm.annotation.NodeEntity
import org.neo4j.ogm.annotation.Property
import org.neo4j.ogm.annotation.Relationship
import org.neo4j.ogm.id.UuidStrategy
import java.time.Instant
import java.util.UUID

@NodeEntity
data class Contact(
        @Id @GeneratedValue(strategy = UuidStrategy::class)
        var uuid: String = UUID.randomUUID().toString(),
        @Property(name = "label") var label: String,
        @Property(name = "type") var type: String,
        @Property(name = "value") var value: String,
        @Property(name = "created") var created: Instant = Instant.now(),
        @Property(name = "expired") var expired: Instant? = null,

        @Relationship(type = "CONNECT", direction = Relationship.OUTGOING)
        var connectList: ArrayList<Connect>

) {

    fun addConnect(connect: Connect) {
        this.connectList.add(connect)
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is Contact) return false

        if (uuid != other.uuid) return false

        return true
    }

    override fun hashCode(): Int {
        return uuid.hashCode()
    }


}