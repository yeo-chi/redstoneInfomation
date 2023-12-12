package yeo.chi.redstoneInformation.service

import org.apache.poi.ss.usermodel.Cell
import org.apache.poi.xssf.usermodel.XSSFWorkbook
import org.springframework.stereotype.Service
import yeo.chi.redstoneInformation.persistant.entity.Item
import yeo.chi.redstoneInformation.persistant.entity.ItemKind
import yeo.chi.redstoneInformation.persistant.entity.ItemTag
import java.io.InputStream

@Service
class ExcelService {
    fun getItems(inputStream: InputStream): List<Item> {
        val workbook = XSSFWorkbook(inputStream)
        val sheet = workbook.getSheet("ITEM")
        val rows = sheet.iterator()

        return rows.asSequence().toList().map {
            it.iterator().asSequence().toList().let { cells ->
                Item(
                    kind = getKind(cells[0]),
                    tags = getTags(cells[1]),
                    name = getName(cells[2]),
                    options = getOptions(cells[3]),
                    subOptions = getSubOptions(cells[4]),
                    condition = getCondition(cells[5]),
                )
            }
        }.also { workbook.close() }
    }

    private fun getKind(kind: Cell): ItemKind = ItemKind.getItemKind(kind.stringCellValue)

    private fun getTags(tags: Cell): List<ItemTag> {
        return tags.stringCellValue
            .split(" ")
            .map(ItemTag::getItemTag)
            .toList()
    }

    private fun getName(name: Cell) = name.stringCellValue

    private fun getOptions(options: Cell): List<String> {
        return options.stringCellValue
            .split("\n")
            .filter(String::isNotBlank)
            .toList()
    }

    private fun getSubOptions(subOptions: Cell): List<String> {
        return subOptions.stringCellValue
            .split("\n")
            .filter(String::isNotBlank)
            .toList()
    }

    private fun getCondition(conditions: Cell): List<String> {
        return conditions.stringCellValue
            .split("\n")
            .filter(String::isNotBlank)
            .toList()
    }
}
