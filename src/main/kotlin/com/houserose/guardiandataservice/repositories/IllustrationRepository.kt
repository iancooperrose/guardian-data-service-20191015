package com.houserose.guardiandataservice.repositories

import com.houserose.guardiandataservice.domain.Illustration
import org.springframework.data.neo4j.repository.Neo4jRepository
import org.springframework.data.rest.core.annotation.RepositoryRestResource

@RepositoryRestResource(collectionResourceRel = "illustrations", path = "illustrations")
interface IllustrationRepository : Neo4jRepository<Illustration, String>