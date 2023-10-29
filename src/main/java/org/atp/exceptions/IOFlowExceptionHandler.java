package org.atp.exceptions;

import javax.swing.text.View;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class IOFlowExceptionHandler {
    public void foo() {
        // ����������� ������ FileInputStream ����������� FileNotFoundException.
        // ������ ���������� �������� "checked exception", �� ���� ����������� �� ������ ����������
        // ������� ������ ����� �� ������� ���� �� �� ������ ��������� ��� ��������� ���������� (FileNotFoundException):
//        FileInputStream fileInputStream = new FileInputStream("");
        // ���������� ����� ���� � ������� ��������� ����� throws (���, ��� �� ��� �� ��������,
        // �������� ��� ��� ��������������), ���� � ������� ������ try-catch-finally.
        // ����� ���������� ����������� try-catch-finally:
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
        !!! �� ���� ����� ���������� �����������, ������� ������� ��� ��� ��� ����,
        ����� ������ �������� � ������������ ������� ������ close(). ����� �� ��������� ����� ��������� �������:
*/
        try(FileInputStream fileInputStreamAnotherOne = new FileInputStream("")) {
            fileInputStreamAnotherOne.getChannel();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
