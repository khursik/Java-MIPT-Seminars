package org.atp.exceptions;

public class NpeExceptionHandler {
    private Viewer viewer;

    public void foo() {
        // обработка исключения с помощью блока try-catch
        try {
            viewer.show();
        } catch (NullPointerException e) {
            System.out.println("Деление на ноль");
        }
        // обработка исключения без использования блока try-catch
        if (viewer == null) {
            System.out.println("Null pointer");
        } else {
            viewer.show();
        }
        /*
        !!! Обработка NPE и вообще данные ошибки простого типа через try-catch считается плохой практикой
            и так делать нежелательно. Это вещи, которые нужно знать как обойти их другим способом,
            поэтому нужно всегда в голове держать может ли мы вызвать какой-то метод у объекта, который null,
            и должна быть соответствующая логика по обработке.
         */
    }
}
