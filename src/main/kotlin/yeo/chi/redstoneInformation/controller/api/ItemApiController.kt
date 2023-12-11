package yeo.chi.redstoneInformation.controller.api

import org.springframework.http.HttpStatus.CREATED
import org.springframework.http.HttpStatus.OK
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController
import yeo.chi.redstoneInformation.controller.api.data.CreateItemRequest
import yeo.chi.redstoneInformation.controller.api.data.ItemResponse
import yeo.chi.redstoneInformation.service.ItemService

@RestController
@RequestMapping("api/v1/items")
class ItemApiController(
    private val itemService: ItemService,
) {
    @GetMapping
    @ResponseStatus(OK)
    fun getList(): List<ItemResponse> {
        return itemService.getList().map(::ItemResponse)
    }

    @PostMapping
    @ResponseStatus(CREATED)
    fun create(
        @RequestBody request: CreateItemRequest,
    ): ItemResponse {
        return itemService.create(request = request).let(::ItemResponse)
    }
}
