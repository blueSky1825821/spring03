package com.utils;

import com.google.common.collect.Lists;
import org.apache.log4j.Logger;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by sky on 2017/6/22.
 */
public class ExcelUtil {
    private Logger logger = Logger.getLogger(ExcelUtil.class);

    /**
     *
     * @Title: readXls
     * @Description: 处理xls文件
     * @param @param path
     * @param @return
     * @param @throws Exception    设定文件
     * @return List<List<String>>    返回类型
     * @throws
     *
     * 1.先用InputStream获取excel文件的io流
     * 2.然后穿件一个内存中的excel文件HSSFWorkbook类型对象，这个对象表示了整个excel文件。
     * 3.对这个excel文件的每页做循环处理
     * 4.对每页中每行做循环处理
     * 5.对每行中的每个单元格做处理，获取这个单元格的值
     * 6.把这行的结果添加到一个List数组中
     * 7.把每行的结果添加到最后的总结果中
     * 8.解析完以后就获取了一个List<List<String>>类型的对象了
     *
     */
    private List<List<String>> readXls(String path) throws Exception {
        InputStream is = new FileInputStream(path);
        // HSSFWorkbook 标识整个excel
        HSSFWorkbook hssfWorkbook = new HSSFWorkbook(is);
        List<List<String>> result = new ArrayList<List<String>>();
        int size = hssfWorkbook.getNumberOfSheets();
        // 循环每一页，并处理当前循环页
        for (int numSheet = 0; numSheet < size; numSheet++) {
            // HSSFSheet 标识某一页
            HSSFSheet hssfSheet = hssfWorkbook.getSheetAt(numSheet);
            if (hssfSheet == null) {
                continue;
            }
            // 处理当前页，循环读取每一行
            for (int rowNum = 1; rowNum <= hssfSheet.getLastRowNum(); rowNum++) {
                // HSSFRow表示行
                HSSFRow hssfRow = hssfSheet.getRow(rowNum);
                int minColIx = hssfRow.getFirstCellNum();
                int maxColIx = hssfRow.getLastCellNum();
                List<String> rowList = new ArrayList<String>();
                // 遍历改行，获取处理每个cell元素
                for (int colIx = minColIx; colIx < maxColIx; colIx++) {
                    // HSSFCell 表示单元格
                    HSSFCell cell = hssfRow.getCell(colIx);
                    if (cell == null) {
                        continue;
                    }
                    rowList.add(getStringVal(cell));
                }
                result.add(rowList);
            }
        }
        return result;
    }

    /**
     *
     * @Title: readXlsx
     * @Description: 处理Xlsx文件
     * @param @param path
     * @param @return
     * @param @throws Exception    设定文件
     * @return List<List<String>>    返回类型
     * @throws
     */
    private List<List<String>> readXlsx(String path) throws Exception {
        InputStream is = new FileInputStream(path);
        XSSFWorkbook xssfWorkbook = new XSSFWorkbook(is);
        List<List<String>> result = new ArrayList<List<String>>();
        // 循环每一页，并处理当前循环页
        for (Sheet xssfSheet : xssfWorkbook) {
            if (xssfSheet == null) {
                continue;
            }
            // 处理当前页，循环读取每一行
            for (int rowNum = 1; rowNum <= xssfSheet.getLastRowNum(); rowNum++) {
                XSSFRow xssfRow = (XSSFRow) xssfSheet.getRow(rowNum);
                int minColIx = xssfRow.getFirstCellNum();
                int maxColIx = xssfRow.getLastCellNum();
                List<String> rowList = new ArrayList<String>();
                for (int colIx = minColIx; colIx < maxColIx; colIx++) {
                    XSSFCell cell = xssfRow.getCell(colIx);
                    if (cell == null) {
                        continue;
                    }
                    rowList.add(getStringVal(cell));
                }
                result.add(rowList);
            }
        }
        return result;
    }


    /**
     * 改造poi默认的toString（）方法如下
     * @Title: getStringVal
     * @Description: 1.对于不熟悉的类型，或者为空则返回""控制串
     *               2.如果是数字，则修改单元格类型为String，然后返回String，这样就保证数字不被格式化了
     * @param @param cell
     * @param @return    设定文件
     * @return String    返回类型
     * @throws
     */

    public static String getStringVal(Cell cell) {
        switch (cell.getCellType()) {
            case Cell.CELL_TYPE_BOOLEAN:
                return cell.getBooleanCellValue() ? "TRUE" : "FALSE";
            case Cell.CELL_TYPE_FORMULA:
                return cell.getCellFormula();
            case Cell.CELL_TYPE_NUMERIC:
                cell.setCellType(Cell.CELL_TYPE_STRING);
                return cell.getStringCellValue();
            case Cell.CELL_TYPE_STRING:
                return cell.getStringCellValue();
            default:
                return "";
        }
    }

    /**
     * 导出 execl
     *
     * @param title     列名
     * @param content   数据
     * @param sheetName 导出文件名
     */
    public void excelExport(String firstRow, Workbook wb, List<String> title, List<String[]> content, int sheetNum, String sheetName) {
        // 生成一个表格
        Sheet sheet = wb.createSheet();
        wb.setSheetName(sheetNum, sheetName);

        Row overviewRow = sheet.createRow((short) 0);
        Cell overviewCell = overviewRow.createCell(0);
        overviewCell.setCellValue(firstRow);
        //title 样式设置
        Row titleRow = sheet.createRow((short) 1);
        for (int i = 0; i < title.size(); i++) {
            sheet.setColumnWidth(i, 3000);
            titleRow.setHeightInPoints(50F);

            CreationHelper ch = wb.getCreationHelper();
            DataFormat textFormat = wb.createDataFormat();

            Cell cell = titleRow.createCell((short) i);
            cell.setCellType(HSSFCell.CELL_TYPE_STRING);

            CellStyle cellStyle = wb.createCellStyle();
            cellStyle.setWrapText(true);
//            cellStyle.setBorderLeft(new HBORDER_THIN);
//            cellStyle.setBorderRight(HSSFCellStyle.BORDER_THIN);
//            cellStyle.setBorderTop(HSSFCellStyle.BORDER_THICK);
//            cellStyle.setBorderBottom(HSSFCellStyle.BORDER_THIN);
//            cellStyle.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
//            cellStyle.setFillForegroundColor(HSSFColor.AQUA.index);
//            cellStyle.setAlignment(CellStyle.ALIGN_CENTER);
//            cellStyle.setVerticalAlignment(CellStyle.VERTICAL_CENTER);
            cellStyle.setDataFormat(textFormat.getFormat("@"));
            cell.setCellStyle(cellStyle);
            cell.setCellValue(ch.createRichTextString(title.get(i)));
        }

        //数据内容设置
        int i = 0;
        for (String[] contentRow : content) {
            i++;
            Row row = sheet.createRow((short) (i + 1));
            for (int j = 0; j < contentRow.length; j++) {
                Cell cell = row.createCell((short) (j));
                CreationHelper ch = wb.getCreationHelper();
                cell.setCellValue(ch.createRichTextString(contentRow[j]));
            }
        }
    }

    // 存在的问题
    /*
     * 其实有时候我们希望得到的数据就是excel中的数据，可是最后发现结果不理想
     * 如果你的excel中的数据是数字，你会发现Java中对应的变成了科学计数法。
     * 所以在获取值的时候就要做一些特殊处理来保证得到自己想要的结果
     * 网上的做法是对于数值型的数据格式化，获取自己想要的结果。
     * 下面提供另外一种方法，在此之前，我们先看一下poi中对于toString()方法:
     *
     * 该方法是poi的方法，从源码中我们可以发现，该处理流程是：
     * 1.获取单元格的类型
     * 2.根据类型格式化数据并输出。这样就产生了很多不是我们想要的
     * 故对这个方法做一个改造。
     */
    /*public String toString(){
        switch(getCellType()){
            case CELL_TYPE_BLANK:
                return "";
            case CELL_TYPE_BOOLEAN:
                return getBooleanCellValue() ? "TRUE" : "FALSE";
            case CELL_TYPE_ERROR:
                return ErrorEval.getText(getErrorCellValue());
            case CELL_TYPE_FORMULA:
                return getCellFormula();
            case CELL_TYPE_NUMERIC:
                if(DateUtil.isCellDateFormatted(this)){
                    DateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy")
                    return sdf.format(getDateCellValue());
                }
                return getNumericCellValue() + "";
            case CELL_TYPE_STRING:
                return getRichStringCellValue().toString();
            default :
                return "Unknown Cell Type:" + getCellType();
        }
    }*/

    public static void main(String[] args) throws Exception {
        ExcelUtil excelUtil = new ExcelUtil();
        List<List<String>> list = excelUtil.readXlsx("/person/upload/tmp/罗湖妇幼字典_加编码.xlsx");
        List<String[]> ar = new ArrayList<>(list.size());
        for (int i = 0; i<list.size(); i++) {
            List<String> l = list.get(i);
            String[] sa = new String[l.size() + 2];
            for (int j=0; j<l.size(); j++) {
                sa[j] = l.get(j);
                if (j==1) {
                    sa[l.size() + 1] = Pinyin4jUtil.getPinYinHeadChar(l.get(j)).toUpperCase();
                }
            }
            ar.add(sa);
        }
        Workbook wb = new HSSFWorkbook();
        List<String> title = Lists.newArrayList();
        title.add("ResultCode");
        title.add("SimpleName");
        title.add("Name");
        title.add("Price");
        title.add("Unit");
        title.add("Internal_code");
        excelUtil.excelExport("firstRow",wb, title, ar, 0,"sheetName");
        File f = new File("a.xlsx");
        FileOutputStream out = new FileOutputStream(f);
        wb.write(out);
        out.flush();
        System.out.println();
    }
}
