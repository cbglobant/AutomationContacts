package com.globant.util;

import com.google.i18n.phonenumbers.NumberParseException;
import com.google.i18n.phonenumbers.PhoneNumberUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UtilFormat {

    private static final Logger logger = LoggerFactory.getLogger(UtilFormat.class);

    public static String formatPhoneNumber(String phoneNumber){
        PhoneNumberUtil phoneUtil = PhoneNumberUtil.getInstance();
        try {
            return phoneUtil.format(phoneUtil.parse(phoneNumber, "CL"), PhoneNumberUtil.PhoneNumberFormat.INTERNATIONAL);
        } catch (NumberParseException e) {
            logger.error("NumberParseException was thrown: ", e);
            return null;
        }
    }
}
