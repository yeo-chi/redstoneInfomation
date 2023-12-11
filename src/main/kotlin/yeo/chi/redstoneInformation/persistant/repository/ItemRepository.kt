package yeo.chi.redstoneInformation.persistant.repository

import org.bson.types.ObjectId
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository
import yeo.chi.redstoneInformation.persistant.entity.Item

@Repository
interface ItemRepository : MongoRepository<Item, ObjectId> {

}
