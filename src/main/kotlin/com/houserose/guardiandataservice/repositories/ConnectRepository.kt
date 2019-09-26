package com.houserose.guardiandataservice.repositories

import com.houserose.guardiandataservice.domain.Connect
import org.springframework.data.neo4j.repository.Neo4jRepository
import org.springframework.data.rest.core.annotation.RepositoryRestResource

@RepositoryRestResource(collectionResourceRel = "connects", path = "connects")
interface ConnectRepository : Neo4jRepository<Connect, String>