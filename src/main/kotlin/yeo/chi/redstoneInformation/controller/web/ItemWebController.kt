package yeo.chi.redstoneInformation.controller.web

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping

@Controller
@RequestMapping("web/v1")
class ItemWebController {
    @GetMapping("items")
    fun getItems(): String {
        return "web/item"
    }
}
