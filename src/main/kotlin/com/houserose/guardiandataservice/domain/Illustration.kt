package com.houserose.guardiandataservice.domain

import org.neo4j.ogm.annotation.EndNode
import org.neo4j.ogm.annotation.GeneratedValue
import org.neo4j.ogm.annotation.Id
import org.neo4j.ogm.annotation.Property
import org.neo4j.ogm.annotation.RelationshipEntity
import org.neo4j.ogm.annotation.StartNode
import org.neo4j.ogm.id.UuidStrategy
import java.util.UUID

@RelationshipEntity(type = "ILLUSTRATION")
data class Illustration(
        @Id @GeneratedValue(strategy = UuidStrategy::class)
        @Property(name = "uuid") var uuid: String = UUID.randomUUID().toString(),

        @StartNode
        @Property(name = "image") var image: Image,

        @EndNode
        @Property(name = "person") var person: Person,

        var label: String?,
        var isDefault: Boolean?)