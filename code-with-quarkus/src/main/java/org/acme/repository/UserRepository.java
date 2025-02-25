package org.acme.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import org.acme.entity.UserEntity;

@ApplicationScoped
public class UserRepository implements PanacheRepository<UserEntity> {
    }
