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
                    kind = ItemKind.valueOf(cells[1].stringCellValue),
                    tags = getTags(cells[2]),
                    name = cells[3].stringCellValue,
                    options = getOptions(cells[4]),
                    subOptions = getSubOptions(cells[5]),
                    condition = getCondition(cells[6]),
                )
            }
        }.also { workbook.close() }
    }

    private fun getTags(tags: Cell): LinkedHashSet<ItemTag> {
        return tags.stringCellValue.split(" ").map(ItemTag::valueOf).toCollection(LinkedHashSet())
    }

    private fun getOptions(options: Cell): LinkedHashSet<String> {
        return options.stringCellValue.split("\n").toCollection(LinkedHashSet())
    }

    private fun getSubOptions(subOptions: Cell): LinkedHashSet<String> {
        return subOptions.stringCellValue.split("\n").toCollection(LinkedHashSet())
    }

    private fun getCondition(conditions: Cell): LinkedHashSet<String> {
        return conditions.stringCellValue.split("\n").toCollection(LinkedHashSet())
    }
}
