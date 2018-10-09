package sut.sa.g21.repository;

import sut.sa.g21.entity.StatusPreorder;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;


@RepositoryRestResource
    public
    interface StatusPreorderRepository extends JpaRepository<StatusPreorder, Long> {
        StatusPreorder findByStatusName(String statusName);
    }