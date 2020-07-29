package de.appsfactory.todoservice.adapter.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

interface TodoRepository extends JpaRepository<TodoJpaEntity, Long>  {
}
