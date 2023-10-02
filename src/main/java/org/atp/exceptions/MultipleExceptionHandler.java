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
            System.out.println("Деление на ноль!!!");
        }

        //  либо если в двух блоках catch подразумевается одна и та же логика
        try {
            viewer.show();
            System.out.println(1/0);
        } catch (NullPointerException | ArithmeticException e) {
            e.printStackTrace();
        }
    }
}
