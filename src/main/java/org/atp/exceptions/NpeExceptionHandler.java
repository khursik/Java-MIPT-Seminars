package org.atp.exceptions;

public class NpeExceptionHandler {
    private Viewer viewer;

    public void foo() {
        // ��������� ���������� � ������� ����� try-catch
        try {
            viewer.show();
        } catch (NullPointerException e) {
            System.out.println("������� �� ����");
        }
        // ��������� ���������� ��� ������������� ����� try-catch
        if (viewer == null) {
            System.out.println("Null pointer");
        } else {
            viewer.show();
        }
        /*
        !!! ��������� NPE � ������ ������ ������ �������� ���� ����� try-catch ��������� ������ ���������
            � ��� ������ ������������. ��� ����, ������� ����� ����� ��� ������ �� ������ ��������,
            ������� ����� ������ � ������ ������� ����� �� �� ������� �����-�� ����� � �������, ������� null,
            � ������ ���� ��������������� ������ �� ���������.
         */
    }
}
