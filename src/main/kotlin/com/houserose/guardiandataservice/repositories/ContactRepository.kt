package com.houserose.guardiandataservice.repositories

import com.houserose.guardiandataservice.domain.Contact
import org.springframework.data.neo4j.repository.Neo4jRepository
import org.springframework.data.rest.core.annotation.RepositoryRestResource

@RepositoryRestResource(collectionResourceRel = "contacts", path = "contacts")
interface ContactRepository : Neo4jRepository<Contact, String>