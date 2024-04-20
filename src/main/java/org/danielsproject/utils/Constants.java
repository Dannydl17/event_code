package org.danielsproject.utils;

import org.danielsproject.model.Category;

public class Constants {

    public static final String EMAIL_PATTERN = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
    public static final String PASSWORD_PATTERN = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@#$%^&+=])(?=.*[a-zA-Z]).{8,15}$";
    public static final String BLANK_FIELD_MESSAGE = "This Field Cannot Be Blank";
    public static final String INVALID_EMAIL_MESSAGE = """
                Invalid Email: Email Should Pass The Following Criteria
                1. Email Domain Must Be A Valid Domain e.g. gmail.com, outlook.com e.t.c.
                2. Email Must Contain One "@" character
                """;
    public static final String INVALID_PASSWORD_MESSAGE = """
                Invalid Password: Password Should Pass The Following Criteria.
                1. Password Must Contain At Least 1 Lowercase Alphabet.
                2. Password Must Contain At Least 1 Uppercase Alphabet.
                3. Password Must Contain At Least 1 Special Character from these: @#$%^&+=.
                4. Password Must Contain At Least 1 Digit.
                5. Password Must Not Be Lesser Than 8 Characters
                6. Password Must Not Be More Than 15 Characters
                """;
    public static final String DUPLICATE_USER_MESSAGE = "Duplicate entry 'email@native.semicolon.africa";
    public static final String USER_REGISTRATION_SUCCESSFUL_MESSAGE = "Registration Was Successful";
    public static final String AUTHENTICATOR_USERNAME = "AUTHENTICATOR_USERNAME";
    public static final String AUTHENTICATOR_PASSWORD = "AUTHENTICATOR_PASSWORD";
    public static final String TEMPLATE_LOAD_FAILED = "Error Loading Template";
    public static final String REG_TEMP_PATH = "/templates/registration-successful.html";
    public static final String REG_MAIL_SUBJECT = "Registration Successful";
    public static final String EVENT_BOOKING_SUCCESSFUL = "Booking Successful";

}
