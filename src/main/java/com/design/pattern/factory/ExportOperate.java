package com.design.pattern.factory;

/**
 * Created by wm on 18-1-6.
 */
public abstract class ExportOperate {
    /**
     * 导出文件
     * @param data
     * @return
     */
    public boolean export(String data) {
        //使用工厂方法
        ExportFileApi api = factoryMethod();
        return api.export(data);
    }

    /**
     * 工厂方法，创建导出的文件对象的接口对象
     * @return 导出的文件对象的接口对象
     */
    protected abstract ExportFileApi factoryMethod();
}
