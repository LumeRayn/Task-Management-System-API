package com.example.task_management_system_api.security;

public interface Constants {

    interface Roles {
        String ROLE_ADMIN_NAME = "ADMIN";
        String ROLE_USER_NAME = "USER";
        String ROLE_MODERATOR_NAME = "MODERATOR";
    }

    interface Extensions {
        String XLSX = "xlsx";
        String XLS = "xls";
    }

    String USER_NOT_FOUND_MESSAGE = "Пользователь не найден";
    String BAD_CREDENTIALS_MESSAGE = "Неверный пароль";
    String USER_PAGE_URL = "/user";
    String ADMIN_PAGE_URL = "/admin";

    String ERROR_PACKAGE_SAVING = "Не удалось сохранить пакет сущностей";
    String PACKAGE_SAVING_RESULT_MSG = "Сохранено %s записей.%s";
    String ERRORS_IN_ROWS = "\nОшибки в строках: %s";
    String PACKAGE_SAVING_NO_RESULT_MSG = "Нет сохраненных записей.%s";


}
