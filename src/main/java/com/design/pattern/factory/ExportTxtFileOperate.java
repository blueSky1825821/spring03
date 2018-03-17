package com.design.pattern.factory;

/**
 * Created by wm on 18-1-6.
 * 具体的创建器实现对象，实现创建导出成文本格式的对象
 */
public class ExportTxtFileOperate extends ExportOperate{
    @Override
    protected ExportFileApi factoryMethod() {
        //创建导出成文本格式的对象
        return new ExportTxtFile();
    }
}
