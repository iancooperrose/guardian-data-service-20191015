package com.houserose.guardiandataservice.domain

import org.neo4j.ogm.annotation.GeneratedValue
import org.neo4j.ogm.annotation.Id
import org.neo4j.ogm.annotation.NodeEntity
import org.neo4j.ogm.annotation.Property
import org.neo4j.ogm.annotation.Relationship
import org.neo4j.ogm.id.UuidStrategy
import java.time.Instant
import java.util.*
import kotlin.collections.ArrayList

@NodeEntity
data class Image(
        @Id @GeneratedValue(strategy = UuidStrategy::class)
        @Property(name = "uuid") var uuid: String = UUID.randomUUID().toString(),
        @Property(name = "name") var name: String,
        @Property(name = "location") var location: String?,
        @Property(name = "mediaType") var mediaType: String,
        @Property(name = "height") var height: Long,
        @Property(name = "width") var width: Long,
        @Property(name = "created") var created: Instant = Instant.now(),
        @Property(name = "expired") var expired: Instant? = null,

        @Relationship(type = "ILLUSTRATION", direction = Relationship.OUTGOING)
        var illustrationList: ArrayList<Illustration>
) {

    fun addIllustration(illustration: Illustration) {
        this.illustrationList.add(illustration)
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is Image) return false

        if (uuid != other.uuid) return false

        return true
    }

    override fun hashCode(): Int {
        return uuid.hashCode()
    }


}