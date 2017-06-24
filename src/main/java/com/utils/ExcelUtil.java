package com.utils;

import org.apache.log4j.Logger;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by sky on 2017/6/22.
 */
public class ExcelUtil {
    private Logger logger = Logger.getLogger(ExcelUtil.class);

    public List<String[]> readExcel(String filePath) {
        List<String[]> dataList = new ArrayList<>();
        boolean isExcel2003 = true;
        if (isExcel2007(filePath)) {
            isExcel2003 = false;
        }
        File file = new File(filePath);
        InputStream is = null;
        try {
            is = new FileInputStream(file);
        } catch (FileNotFoundException e) {
            logger.error(e);
        }
        Workbook wb = null;
        try {
            wb = isExcel2003 ? new HSSFWorkbook(is) : new XSSFWorkbook(is);
        } catch (IOException e) {
            logger.error(e);
        }
        Sheet sheet = wb.getSheetAt(0);
        int totalRows = sheet.getPhysicalNumberOfRows();
        int totalCells = 0;
        if (totalRows >= 1 && sheet.getRow(0) != null) {
            totalCells = sheet.getRow(0).getPhysicalNumberOfCells();
        }
        for (int i = 0; i < totalRows; i++) {
            Row row = sheet.getRow(i);
            if (null == row) {
                continue;
            }
            String[] rowList = new String[totalCells];
            for (int j = 0; j < totalCells; j++) {
                Cell cell = row.getCell(j);
                String cellValue = "";
                if (null == cell) {
                    rowList[j] = cellValue;
                    continue;
                }
                cellValue = ConvertCellStr(cell, cellValue);
                rowList[j] = cellValue;
            }
            dataList.add(rowList);
        }
        return dataList;
    }

    private String ConvertCellStr(Cell cell, String cellStr) {
        switch (cell.getCellType()) {
            case Cell.CELL_TYPE_STRING:
                // 读取String
                cellStr = cell.getStringCellValue().toString();
                break;
            case Cell.CELL_TYPE_BOOLEAN:
                // 得到Boolean对象的方法
                cellStr = String.valueOf(cell.getBooleanCellValue());
                break;
            case Cell.CELL_TYPE_NUMERIC:
                // 先看是否是日期格式
//                if (DateUtil.isCellDateFormatted(cell)) {
//                    // 读取日期格式
//                    cellStr = formatTime(cell.getDateCellValue().toString());
//                } else {
                // 读取数字
                cellStr = String.valueOf(cell.getNumericCellValue());
//                }
                break;
            case Cell.CELL_TYPE_FORMULA:
                // 读取公式
                cellStr = cell.getCellFormula().toString();
                break;
        }
        return cellStr;
    }

    private boolean isExcel2007(String fileName) {
        return fileName.matches("^.+\\.(?i)(xlsx)$");
    }

    public static void main(String[] args) throws IOException {
        ExcelUtil re = new ExcelUtil();
//  List<String[]> list = re.readExcel("c:/群组.xls");
        List<String[]> list = re.readExcel("F:\\workstation\\网关\\网关服务.xlsx");
        if (list != null) {
            for (int i = 0; i < list.size(); i++) {
                System.out.println("第" + (i + 1) + "行");
                String[] cellList = list.get(i);
                for (int j = 0; j < cellList.length; j++) {
                    System.out.print("\t第" + (j + 1) + "列值：");
                    System.out.println(cellList[j]);
                }
            }
        }
    }
}
