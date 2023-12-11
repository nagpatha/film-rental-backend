package com.filmrental.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.filmrental.entity.Actor;
import com.filmrental.entity.Film;

public interface ActorRepo extends JpaRepository<Actor, Integer> {

       List<Actor> findByFirstName(String firstName);
       List<Actor> findByLastName(String lastName);
//
//    @Query("select a from Actor a join fetch a.filmActors fa where fa.actorId = ?1")
       
       @Query("select f from Actor f where f.actorId = ?1")
       List<Actor> getFilmsByActorId(int actorId);
       
       @Query("SELECT a.actorId, a.firstName, a.lastName, COUNT(fa.filmId) " +
               "FROM Actor a JOIN a.films fa " +
               "GROUP BY a.actorId, a.firstName, a.lastName " +
               "ORDER BY COUNT(fa.filmId) DESC")
        List<Object[]> findTopActorsByFilmCount();
       
        @Query("SELECT a.films FROM Actor a WHERE a.actorId = :actorId")
        List<Film> findFilmsByActorId(@Param("actorId") int actorId);
        
    	

    
}
