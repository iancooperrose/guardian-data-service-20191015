package com.houserose.guardiandataservice.repositories

import com.houserose.guardiandataservice.domain.Image
import org.springframework.data.neo4j.repository.Neo4jRepository
import org.springframework.data.rest.core.annotation.RepositoryRestResource

@RepositoryRestResource(collectionResourceRel = "images", path = "images")
interface ImageRepository : Neo4jRepository<Image, String>