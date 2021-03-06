package com.kalix.tools.command;

import com.kalix.tools.command.internal.InitActivator;
import org.apache.karaf.shell.api.action.Action;
import org.apache.karaf.shell.api.action.Command;
import org.apache.karaf.shell.api.action.Completion;
import org.apache.karaf.shell.api.action.lifecycle.Service;
import org.osgi.framework.BundleContext;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLDecoder;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Set;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

/**
 * Created by sunlf on 2015/12/4.
 * 获得当前目录下的全部script列表
 */
@Command(scope = "kalix", name = "permit", description = "init permit sql script")
@Service
public class PermissionScriptCommand implements Action
{
    @Completion(MyCompleter.class)
    String arg = null;

    @Override
    public Object execute() throws Exception {
        try {
            PermissionInit permissionInit=new PermissionInit();
            permissionInit.init();

        } catch (Exception e) {
            System.out.println("init permit sql script");
            e.printStackTrace();
        }

        return null;
    }
}
