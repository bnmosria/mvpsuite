package org.mvpsuite.repository;

import org.mvpsuite.model.Account;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface AccountRepository extends CrudRepository<Account, UUID> {
}
