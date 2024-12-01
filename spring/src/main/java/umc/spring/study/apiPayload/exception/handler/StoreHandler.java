package umc.spring.study.apiPayload.exception.handler;

import umc.spring.study.apiPayload.code.BaseErrorCode;
import umc.spring.study.apiPayload.exception.GeneralException;

public class StoreHandler extends GeneralException {

    public StoreHandler(BaseErrorCode code) {
        super(code);
    }
}
