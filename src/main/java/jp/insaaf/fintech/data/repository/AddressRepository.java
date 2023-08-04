package jp.insaaf.fintech.data.repository;

import jp.insaaf.fintech.data.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, String> {
}
