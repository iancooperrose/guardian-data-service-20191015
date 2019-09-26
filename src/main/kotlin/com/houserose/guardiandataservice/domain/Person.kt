package com.houserose.guardiandataservice.domain

import org.neo4j.ogm.annotation.GeneratedValue
import org.neo4j.ogm.annotation.Id
import org.neo4j.ogm.annotation.NodeEntity
import org.neo4j.ogm.annotation.Property
import org.neo4j.ogm.annotation.Relationship
import org.neo4j.ogm.id.UuidStrategy
import java.time.Instant
import java.util.*

@NodeEntity
data class Person(
        @Id @GeneratedValue(strategy = UuidStrategy::class)
        @Property(name = "uuid") var uuid: String? = UUID.randomUUID().toString(),
        @Property(name = "name") var name: String,
        @Property(name = "firstName") var firstName: String,
        @Property(name = "middleName") var middleName: String? = null,
        @Property(name = "lastName") var lastName: String,
        @Property(name = "nameTitle") var nameTitle: String? = null,
        @Property(name = "nameSuffix") var nameSuffix: String? = null,
        @Property(name = "dateOfBirth") var dateOfBirth: Instant,
        @Property(name = "created") val created: Instant = Instant.now(),
        @Property(name = "expired") var expired: Instant? = null,

//        @Relationship(type = "ASSOCIATE", direction = Relationship.OUTGOING)
//        var organizationList: ArrayList<Organization> = ArrayList(),

//        @Relationship(type = "ENROLL", direction = Relationship.INCOMING)
//        var enrollmentList: ArrayList<Enroll> = ArrayList(),

//        @Relationship(type = "STAFF", direction = Relationship.OUTGOING)
//        var unitList: ArrayList<Staff> = ArrayList(),

//        @Relationship(type = "FACILITATE", direction = Relationship.OUTGOING)
//        var facilitatorList: ArrayList<Facilitate> = ArrayList(),

//        @Relationship(type = "REGISTER", direction = Relationship.OUTGOING)
//        var termList: ArrayList<Term> = ArrayList(),
//
//        @Relationship(type = "JOIN", direction = Relationship.OUTGOING)
//        var circleList: ArrayList<Circle> = ArrayList(),

        @Relationship(type = "ILLUSTRATION", direction = Relationship.INCOMING)
        var illustrationList: ArrayList<Illustration>,

        @Relationship(type = "CONNECT", direction = Relationship.INCOMING)
        var connectList: ArrayList<Connect>

//        @Relationship(type = "ATTEND", direction = Relationship.INCOMING)
//        var sessionList: ArrayList<Attend> = ArrayList()
) {

//    fun addOrganization(organization: Organization) {
//        this.organizationList.add(organization)
//    }

//    fun addStaff(staff: Staff) {
//        this.unitList.add(staff)
//    }
//
//    fun addTerm(term: Term) {
//        this.termList.add(term)
//    }
//
//    fun addCircle(circle: Circle) {
//        this.circleList.add(circle)
//    }

    fun addIllustration(illustration: Illustration) {
        this.illustrationList.add(illustration)
    }

    fun addConnect(connect: Connect) {
        this.connectList.add(connect)
    }

//    fun addSession(attend: Attend) {
//        this.sessionList.add(attend)
//    }

//    fun addEnrollment(enroll: Enroll) {
//        this.enrollmentList.add(enroll)
//    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is Person) return false

        if (uuid != other.uuid) return false

        return true
    }

    override fun hashCode(): Int {
        return uuid.hashCode()
    }


}