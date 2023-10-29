package org.atp.exceptions;

import javax.swing.text.View;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class IOFlowExceptionHandler {
    public void foo() {
        // Конструктор класса FileInputStream выбрасывает FileNotFoundException.
        // Данное исключение является "checked exception", то есть проверяемым на стадии компиляции
        // Поэтому данный метод со строкой ниже мы не сможем запустить без обработки исключения (FileNotFoundException):
//        FileInputStream fileInputStream = new FileInputStream("");
        // Обработать можем либо с помощью ключевого слова throws (тем, кто не был на семинаре,
        // почитать про это самостоятельно), либо с помощью блоков try-catch-finally.
        // Далее используем конструкцию try-catch-finally:
        FileInputStream fileInputStream = null;
        try {
            fileInputStream = new FileInputStream("");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                fileInputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
/*
        !!! Но есть более элегантная конструкция, которая создана как раз для того,
        чтобы решать проблему с обязательным вызовом метода close(). Тогда всё выглядеть будет следующим образом:
*/
        try(FileInputStream fileInputStreamAnotherOne = new FileInputStream("")) {
            fileInputStreamAnotherOne.getChannel();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
