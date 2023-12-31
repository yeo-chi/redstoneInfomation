package yeo.chi.redstoneInformation.controller.api

import org.springframework.http.HttpStatus.CREATED
import org.springframework.http.HttpStatus.OK
import org.springframework.http.MediaType.APPLICATION_JSON_VALUE
import org.springframework.http.MediaType.MULTIPART_FORM_DATA_VALUE
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestPart
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.multipart.MultipartFile
import yeo.chi.redstoneInformation.controller.api.data.CreateItemRequest
import yeo.chi.redstoneInformation.controller.api.data.ItemResponse
import yeo.chi.redstoneInformation.controller.api.data.SearchItemCondition
import yeo.chi.redstoneInformation.service.ExcelService
import yeo.chi.redstoneInformation.service.ItemService

@RestController
@RequestMapping("api/v1/items")
class ItemApiController(
    private val itemService: ItemService,

    private val excelService: ExcelService,
) {
    @GetMapping
    @ResponseStatus(OK)
    fun getList(itemCondition: SearchItemCondition): List<ItemResponse> {
        return itemService.getList(itemCondition = itemCondition).map(::ItemResponse)
    }

    @GetMapping("{id}")
    @ResponseStatus(OK)
    fun get(@PathVariable("id") id: String) = itemService.get(id = id).let(::ItemResponse)

    @PostMapping
    @ResponseStatus(CREATED)
    fun create(
        @RequestBody request: CreateItemRequest,
    ): ItemResponse {
        return itemService.create(request = request).let(::ItemResponse)
    }

    @PostMapping("bulk", consumes = [APPLICATION_JSON_VALUE, MULTIPART_FORM_DATA_VALUE])
    @ResponseStatus(CREATED)
    fun createAll(
        @RequestPart request: MultipartFile,
    ): List<ItemResponse> {
        return excelService.getItems(inputStream = request.inputStream)
            .run { itemService.createAll(this) }
            .map { ItemResponse(it) }
    }
}
