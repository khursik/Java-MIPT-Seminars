package org.atp.exceptions;

public class MultipleExceptionHandler {
    private Viewer viewer;
    public void foo() {
        try {
            viewer.show();
            System.out.println(1/0);
        } catch (NullPointerException e) {
            e.printStackTrace();
        } catch (ArithmeticException ex) {
            System.out.println("������� �� ����!!!");
        }

        //  ���� ���� � ���� ������ catch ��������������� ���� � �� �� ������
        try {
            viewer.show();
            System.out.println(1/0);
        } catch (NullPointerException | ArithmeticException e) {
            e.printStackTrace();
        }
    }
}
