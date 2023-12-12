package com.example.batchprocessing;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemProcessor;

public class EmployeeItemProcessor implements ItemProcessor<Employee, Employee> {
    // ログ出力用のオブジェクトを生成します
    private static final Logger log = LoggerFactory.getLogger(EmployeeItemProcessor.class);

    // ItemProcessorの処理を定義します
    @Override
    public Employee process(final Employee employee) throws Exception {
        // 名前をすべて大文字にします
        final String name = employee.getName().toUpperCase();
        // フィールドを差し替えた新しいEmployeeオブジェクトを生成します
        final Employee transformedEmployee = new Employee(name, employee.getDepartment());
        // 差分をログに出力します
        log.info("変換結果 (" + employee + ") => (" + transformedEmployee + ")");
        // 変換後のオブジェクトを返却します
        return transformedEmployee;
    }
}