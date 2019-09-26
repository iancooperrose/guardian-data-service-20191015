package com.houserose.guardiandataservice.repositories

import com.houserose.guardiandataservice.domain.Person
import org.springframework.data.neo4j.repository.Neo4jRepository
import org.springframework.data.rest.core.annotation.RepositoryRestResource

@RepositoryRestResource(collectionResourceRel = "persons", path = "persons")
interface PersonRepository : Neo4jRepository<Person, String>