package jp.insaaf.fintech.data.repository;

import jp.insaaf.fintech.data.entity.Address;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AddressRepository extends MongoRepository<Address, String> {
}
