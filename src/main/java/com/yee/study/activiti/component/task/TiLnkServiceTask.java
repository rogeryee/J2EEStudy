package com.yee.study.activiti.component.task;

import com.yee.andpay.demo.api.tilnk.callback.LnkServiceCallee;
import com.yee.andpay.demo.api.tilnk.callback.LnkSrvCallback;
import com.yee.andpay.demo.api.tilnk.hello.HelloWorldRespHandler;
import com.yee.andpay.demo.api.tilnk.hello.HelloWorldResponse;
import com.yee.study.activiti.LnkSrvCallbackImpl;
import me.andpay.ti.lnk.annotaion.Lnkwired;
import me.andpay.ti.lnk.api.LnkClientContextAccessor;
import org.activiti.engine.impl.bpmn.behavior.TaskActivityBehavior;
import org.activiti.engine.impl.el.FixedValue;
import org.activiti.engine.impl.pvm.delegate.ActivityExecution;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class TiLnkServiceTask extends TaskActivityBehavior {

	private static final Logger logger = LoggerFactory.getLogger(TiLnkServiceTask.class);

    @Autowired
    private LnkServiceCaller lnkServiceCaller;

    /**
     * 服务接口类
     */
    private FixedValue serviceInterface;

    /**
     * 方法
     */
    private FixedValue methodName;

    @Lnkwired
    private LnkServiceCallee lnkServiceCallee;

	@Override
	public void signal(ActivityExecution execution, String signalName, Object signalData) throws Exception
    {
		logger.debug("receive data prepared signal executionId [{}] businessKey [{}] signalName [{}] signalData [{}]",
				execution.getId(), execution.getProcessBusinessKey(), signalName, signalData);
		execute(execution);
	}

	@Override
	public void execute(final ActivityExecution execution) throws Exception
    {
        logger.info("Enter execution : id = 1" + execution.getId() + ", instId = " + execution.getProcessInstanceId());

        Object ret = invokeCallbackService();

        leave(execution);
		logger.info("TiLnkServiceTask executed.");
	}

    private Object invokeCallbackService()
    {
        LnkSrvCallback obj = LnkClientContextAccessor.newCallbackForLnkService(LnkSrvCallback.class, LnkSrvCallbackImpl.class);

        String token = UUID.randomUUID().toString();
        logger.info("In execution and token = " + token);

        TiLnkCallbackHandler handler = new TiLnkCallbackHandler();
        handler.setObj(obj);
        handler.setToken(token);

        LnkSrvCallback callback = (LnkSrvCallback)Proxy.newProxyInstance(this.getClass().getClassLoader(), new java.lang.Class[]{LnkSrvCallback.class}, handler);


        Object ret = lnkServiceCallee.invoke("Roger", callback);
        return ret;
    }

    private Object invokeCallback() throws ClassNotFoundException
    {
        List<Object> args = new ArrayList<>();
        args.add("Roger");

        HelloWorldRespHandler obj = new HelloWorldRespHandler(){

            @Override
            public void onSuccess(HelloWorldResponse helloWorldResponse)
            {
                logger.info("Callback invoked : " + helloWorldResponse.getRespMessage());
            }
        };

        String token = UUID.randomUUID().toString();
        logger.info("In execution and token = " + token);

        TiLnkCallbackHandler handler = new TiLnkCallbackHandler();
        handler.setObj(obj);
        handler.setToken(token);

        HelloWorldRespHandler callback = (HelloWorldRespHandler)Proxy.newProxyInstance(this.getClass().getClassLoader(), new java.lang.Class[]{HelloWorldRespHandler.class}, handler);

        args.add(callback);

        LnkServiceCallDefine callDefine = new LnkServiceCallDefine();
        callDefine.setServiceInterface(Class.class.forName(serviceInterface.getExpressionText()));
        callDefine.setMethodName(methodName.getExpressionText());

        Object ret = lnkServiceCaller.call(callDefine, args);

        return ret;
    }

    // Getters and Setters
    public FixedValue getServiceInterface()
    {
        return serviceInterface;
    }

    public void setServiceInterface(FixedValue serviceInterface)
    {
        this.serviceInterface = serviceInterface;
    }

    public FixedValue getMethodName()
    {
        return methodName;
    }

    public void setMethodName(FixedValue methodName)
    {
        this.methodName = methodName;
    }

    public LnkServiceCaller getLnkServiceCaller()
    {
        return lnkServiceCaller;
    }

    public void setLnkServiceCaller(LnkServiceCaller lnkServiceCaller)
    {
        this.lnkServiceCaller = lnkServiceCaller;
    }
}
