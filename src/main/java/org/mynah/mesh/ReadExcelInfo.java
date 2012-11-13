/*
 * Copyright 2012-2013 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.mynah.mesh;

import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadExcelInfo {
    private static Log logger = LogFactory.getLog(ReadExcelInfo.class);

    /**
     * 得到工作薄
     * 
     * @param filePath
     *            String 文件路径
     * @return HSSFWorkbook
     */
    public static HSSFWorkbook readExcel(String filePath) {
        logger.info("开始读取Excel文件");
        try {
            FileInputStream filein = new FileInputStream(filePath);
            HSSFWorkbook workbook = new HSSFWorkbook(filein);
            return workbook;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 获取行数据
     * 
     * @param row
     *            HSSFRow 行
     * @param columnEnd
     *            int 列，从0开始计算
     * @return List<String>
     */
    public static List<String> readRow(Row row, int columnEnd) {
        try {
            List<String> dataInfo = new ArrayList<String>();
            for (int k = 0; k <= columnEnd; k++) {
                String cellInfo = null;
                Cell cell = row.getCell(k);
                if (cell == null) {
                    cellInfo = null;
                } else {
                    if (cell.getCellType() == Cell.CELL_TYPE_NUMERIC) {
                        if (DateUtil.isCellDateFormatted(cell)) {
                            Double d = cell.getNumericCellValue();
                            Date dd = DateUtil.getJavaDate(d);
                            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                            cellInfo = sdf.format(dd);
                        } else {
                            cell.setCellType(Cell.CELL_TYPE_STRING);
                            cellInfo = cell.toString();
                        }
                    } else {
                        cellInfo = cell.toString();
                    }
                }
                dataInfo.add(cellInfo);
            }
            return dataInfo;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static List<String> readRow(Row row) {
        try {
            if (row == null)
                return null;
            List<String> dataInfo = new ArrayList<String>();
            for (int k = 0; k <= row.getLastCellNum(); k++) {
                String cellInfo = null;
                Cell cell = row.getCell(k);
                if (cell == null)
                    continue;
                if (cell.getCellType() == Cell.CELL_TYPE_NUMERIC) {
                    if (DateUtil.isCellDateFormatted(cell)) {
                        Double d = cell.getNumericCellValue();
                        Date dd = DateUtil.getJavaDate(d);
                        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                        cellInfo = sdf.format(dd);
                    } else {
                        cell.setCellType(Cell.CELL_TYPE_STRING);
                        cellInfo = cell.toString();
                    }
                } else {
                    cellInfo = cell.toString();
                }
                dataInfo.add(cellInfo);
            }
            return dataInfo;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 读取excel并且组装成信息文件
     * 
     * @param workbook
     *            HSSFWorkbook 读取到的Excel文件信息
     * @param sheetAt
     *            int 从第几个sheet开始读取信息，默认从0开始计算
     * @param rowAt
     *            int 从第几行开始读取数据，默认从0开始计算
     * @param columnAt
     *            int 止于第多少列，默认从0开始计算
     * @return List<List<String>>
     */
    public static List<List<String>> excelTOInfo(byte[] foByte, int sheetAt, int rowAt, int columnEnd) {
        try {
            InputStream is = new ByteArrayInputStream(foByte);
            Workbook wb = WorkbookFactory.create(is);
            Sheet sheet = wb.getSheetAt(sheetAt);
            if (sheet == null)
                return null;
            List<List<String>> allData = new ArrayList<List<String>>();
            for (int i = 0; i <= sheet.getLastRowNum(); i++) {
                Row row = sheet.getRow(i);
                if (i < rowAt) {
                    continue;
                }
                // 该行数据都为空时添加null
                if (row == null) {
                    List<String> dataInfo = new ArrayList<String>();
                    for (int a = 0; a <= columnEnd; a++) {
                        dataInfo.add(null);
                    }
                    allData.add(dataInfo);
                } else {
                    List<String> dataInfo = readRow(row, columnEnd);
                    allData.add(dataInfo);
                }
            }
            return allData;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
