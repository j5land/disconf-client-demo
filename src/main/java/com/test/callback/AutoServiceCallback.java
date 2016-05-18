package com.test.callback;

import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.baidu.disconf.client.common.annotations.DisconfUpdateService;
import com.baidu.disconf.client.common.update.IDisconfUpdate;
import com.test.util.CallbackUtil;

/**
 * 这是 autoconfig.properties 的回调函数类
 * <p/>
 * Created by knightliao on 15/3/21.
 */
@Service
@Scope("singleton")
@DisconfUpdateService(confFileKeys = {"autoconfig.properties"})
public class AutoServiceCallback implements IDisconfUpdate {

    protected static final Logger LOGGER = LoggerFactory.getLogger(AutoServiceCallback.class);

    public void reload() throws Exception {
    	Properties properties = CallbackUtil.getProperties("autoconfig.properties");
    	if(properties!=null){
    		LOGGER.info("reload autoconfig.properties :"+properties.entrySet());
    	}
        
    }
}
