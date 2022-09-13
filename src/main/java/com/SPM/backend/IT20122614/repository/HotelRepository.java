package com.SPM.backend.IT20122614.repository;

import com.SPM.backend.IT20122614.model.Hotel;
<<<<<<< HEAD
=======
import org.bson.types.ObjectId;
>>>>>>> 1cadc05 (IT20122096 - Payment Done)
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
<<<<<<< HEAD
public interface HotelRepository extends MongoRepository<Hotel, Integer> {

    Hotel findHotelById(String name);

    void deleteHotelById(String name);
//    void findByIdAndUpdate(String id, Hotel hotel);
//    void findAndModify({query: {id: id})
=======
public interface HotelRepository extends MongoRepository<Hotel, ObjectId> {

>>>>>>> 1cadc05 (IT20122096 - Payment Done)
}
