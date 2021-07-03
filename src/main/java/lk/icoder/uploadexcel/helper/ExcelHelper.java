package lk.icoder.uploadexcel.helper;

import lk.icoder.uploadexcel.entity.Adjustment;
import lk.icoder.uploadexcel.entity.Tutorial;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class ExcelHelper {
    public static String TYPE = "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet";
    static String[] HEADERs = {"Id", "Title", "Description", "Published"};
    static String SHEET = "tutorials";

    public static boolean hasExcelFormat(MultipartFile file) {

        if (!TYPE.equals(file.getContentType())) {
            return false;
        }

        return true;
    }

    public static ByteArrayInputStream tutorialsToExcel(List<Tutorial> tutorials) {

        try (Workbook workbook = new XSSFWorkbook(); ByteArrayOutputStream out = new ByteArrayOutputStream();) {
            Sheet sheet = workbook.createSheet(SHEET);

            // Header
            Row headerRow = sheet.createRow(0);

            for (int col = 0; col < HEADERs.length; col++) {
                Cell cell = headerRow.createCell(col);
                cell.setCellValue(HEADERs[col]);
            }

            int rowIdx = 1;
            for (Tutorial tutorial : tutorials) {
                Row row = sheet.createRow(rowIdx++);

                row.createCell(0).setCellValue(tutorial.getId());
                row.createCell(1).setCellValue(tutorial.getTitle());
                row.createCell(2).setCellValue(tutorial.getDescription());
                row.createCell(3).setCellValue(tutorial.getPublished());
            }

            workbook.write(out);
            return new ByteArrayInputStream(out.toByteArray());
        } catch (IOException e) {
            throw new RuntimeException("fail to import data to Excel file: " + e.getMessage());
        }
    }

    public static List<Adjustment> excelToTutorials(InputStream is) {
        try {
            Workbook workbook = new XSSFWorkbook(is);

//      Sheet sheet = workbook.getSheet(SHEET);
            System.out.println("Workbook has " + workbook.getNumberOfSheets() + " Sheets : ");
            System.out.println("Retrieving Sheets using for-each loop");
            List<Adjustment> adjustmentList = new ArrayList<>();

            Sheet sheet = workbook.getSheetAt(0);
            System.out.println("=> " + sheet.getSheetName());

            for (int index = 0; index < sheet.getPhysicalNumberOfRows(); index++) {
                Adjustment adjustment = new Adjustment();

                if (index > 0) {
                    Row row = sheet.getRow(index);

                    adjustment.setCurCaseStage(row.getCell(1).getStringCellValue());
                    adjustment.setCaseNumber(row.getCell(2).getStringCellValue());
                    adjustment.setStageExpDate(row.getCell(3).getStringCellValue());
                    adjustment.setPan(row.getCell(4).getStringCellValue());
                    adjustment.setCaseUpdated(row.getCell(5).getStringCellValue());
                    adjustment.setCurrency(row.getCell(6).getStringCellValue());
                    adjustment.setTranAmount(row.getCell(7).getStringCellValue());
                    adjustment.setReasonCode(row.getCell(8).getStringCellValue());
                    adjustment.setAdjustmentAmount(row.getCell(9).getStringCellValue());
                    adjustment.setIssReconInstId(row.getCell(10).getStringCellValue());
                    adjustment.setTranLocalDateTime(row.getCell(11).getStringCellValue());
                    adjustment.setAcqReconInstId(row.getCell(12).getStringCellValue());
                    adjustment.setRetrievalRef(row.getCell(13).getStringCellValue());
                    adjustment.setProcNtwk(row.getCell(14).getStringCellValue());
                    adjustment.setActToIss(row.getCell(15).getStringCellValue());
                    adjustment.setCardAcptTermId(row.getCell(16).getStringCellValue());
                    adjustment.setCardAcptName(row.getCell(17).getStringCellValue());
                    adjustment.setMerchRptingLevel(row.getCell(18).getStringCellValue());

                    adjustmentList.add(adjustment);
                }
            }
            workbook.close();

            return adjustmentList;
        } catch (IOException e) {
            throw new RuntimeException("fail to parse Excel file: " + e.getMessage());
        }
    }
}
