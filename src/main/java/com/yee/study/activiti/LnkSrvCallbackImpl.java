package com.yee.study.activiti;

import com.yee.andpay.demo.api.tilnk.callback.CallbackResult;
import com.yee.andpay.demo.api.tilnk.callback.LnkSrvCallback;
import me.andpay.ti.lnk.annotaion.LnkService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Author: RogerYee
 * Create: 12/23/15
 */
@LnkService(serviceGroup = "andpay-client.srv", serviceInterface = LnkSrvCallback.class)
public class LnkSrvCallbackImpl implements LnkSrvCallback
{
    static Logger logger = LoggerFactory.getLogger(LnkSrvCallbackImpl.class);

    public void onComplete(CallbackResult result)
    {
        logger.info("#### LnkSrvCallbackImpl onCompleted start ####");
        logger.info("LnkSrvCallbackImpl result = " + result.getResult());
        logger.info("#### LnkSrvCallbackImpl onCompleted end ####");
    }
}
