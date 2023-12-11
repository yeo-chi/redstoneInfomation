package yeo.chi.redstoneInformation.service

import org.springframework.stereotype.Service
import yeo.chi.redstoneInformation.controller.api.data.CreateItemRequest
import yeo.chi.redstoneInformation.persistant.entity.Item
import yeo.chi.redstoneInformation.persistant.repository.ItemRepository

@Service
class ItemService(
    private val itemRepository: ItemRepository,
) {
    fun getList(): List<Item> {
        return itemRepository.findAll()
    }

    fun create(request: CreateItemRequest): Item {
        return itemRepository.save(request.toEntity())
    }

    fun createAll(items: List<Item>): List<Item> {
        return itemRepository.saveAll(items)
    }
}
