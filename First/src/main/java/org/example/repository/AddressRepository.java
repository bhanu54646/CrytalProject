package org.example.repository;

import org.example.model.Address;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


public interface AddressRepository extends MongoRepository<Address,String> {
}
