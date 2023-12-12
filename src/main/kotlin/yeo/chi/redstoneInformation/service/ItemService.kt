package yeo.chi.redstoneInformation.service

import io.micrometer.common.util.StringUtils
import org.springframework.data.mongodb.core.MongoTemplate
import org.springframework.data.mongodb.core.query.Criteria
import org.springframework.data.mongodb.core.query.Query
import org.springframework.stereotype.Service
import yeo.chi.redstoneInformation.controller.api.data.CreateItemRequest
import yeo.chi.redstoneInformation.controller.api.data.SearchItemCondition
import yeo.chi.redstoneInformation.persistant.entity.Item
import yeo.chi.redstoneInformation.persistant.repository.ItemRepository

@Service
class ItemService(
    private val mongoTemplate: MongoTemplate,

    private val itemRepository: ItemRepository,
) {
    fun getList(itemCondition: SearchItemCondition): List<Item> {
        return mongoTemplate.find(getQuery(itemCondition = itemCondition), Item::class.java)
    }

    fun create(request: CreateItemRequest): Item {
        return itemRepository.save(request.toEntity())
    }

    fun createAll(items: List<Item>): List<Item> {
        return itemRepository.saveAll(items)
    }

    private fun getQuery(itemCondition: SearchItemCondition): Query {
        return with(Criteria.where("id").ne(null)) {
            if (itemCondition.kind != null) {
                and("kind").`is`(itemCondition.kind)
            }

            if (itemCondition.tags.isNotEmpty()) {
                and("tags").`in`(itemCondition)
            }

            if (!StringUtils.isBlank(itemCondition.name)) {
                and("name").regex(".*${itemCondition.name}.*")
            }

            if (!StringUtils.isBlank(itemCondition.option)) {
                and("options").regex(".*${itemCondition.option}.*")
            }

            Query(this)
        }
    }
}
