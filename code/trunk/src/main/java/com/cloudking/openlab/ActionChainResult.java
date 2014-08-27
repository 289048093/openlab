/**
 * Copyright(c) 2013 ShenZhen CloudKing Technology Co., Ltd.
 * All rights reserved.
 * Created on  Apr 28, 2013  10:58:25 AM
 */
package com.cloudking.openlab;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.ActionProxy;
import com.opensymphony.xwork2.ActionProxyFactory;
import com.opensymphony.xwork2.Result;
import com.opensymphony.xwork2.XWorkException;
import com.opensymphony.xwork2.inject.Inject;
import com.opensymphony.xwork2.util.TextParseUtil;
import com.opensymphony.xwork2.util.ValueStack;

/**
 * 
 * 重写了默认的chain拦截器com.opensymphony.xwork2.ActionChainResult 可以正确跳转actionName!method这种DMI型式的路径 可以带参数跳转 使用: <struts>
 * <package ... <result-types> <result-type name="chain" class="com.common.base.struts2.interceptor.ActionChainResult"></result-type>
 * </result-types> <result type="chain">...</result> </package> </struts>
 * 
 * @author Administrator
 * 
 */
@SuppressWarnings("unchecked")
public class ActionChainResult implements Result {

    /**
     * The result parameter name to set the name of the action to chain to.
     */
    public static final String DEFAULT_PARAM = "actionName";
    /**
     * The result parameter name to set the name of the action to chain to.
     */
    public static final String SKIP_ACTIONS_PARAM = "skipActions";
    /**
     * The action context key to save the chain history.
     */
    private static final String CHAIN_HISTORY = "CHAIN_HISTORY";

    /**
     * 
     */
    private static final long serialVersionUID = -5686117555149598153L;
    /**
     * 代理
     */
    private ActionProxy proxy;
    /**
     * action名字
     */
    private String actionName;
    /**
     * 命名空间
     */
    private String namespace;
    /**
     * 方法名字
     */
    private String methodName;

    /**
     * The list of actions to skip.
     */
    private String skipActions;
    /**
     * proxy fac
     */
    private ActionProxyFactory actionProxyFactory;

    /**
     * 默认构造器
     */
    public ActionChainResult(){
        super();
    }

    /**
     * ActionChainResult
     * 
     * @param namespace
     * @param actionName
     * @param methodName
     */
    public ActionChainResult(String namespace, String actionName, String methodName){
        this.namespace = namespace;
        this.actionName = actionName;
        this.methodName = methodName;
    }

    /**
     * ActionChainResult
     * 
     * @param namespace
     * @param actionName
     * @param methodName
     * @param skipActions
     */
    public ActionChainResult(String namespace, String actionName, String methodName, String skipActions){
        this.namespace = namespace;
        this.actionName = actionName;
        this.methodName = methodName;
        this.skipActions = skipActions;
    }

    /**
     * @param actionProxyFactory
     *            the actionProxyFactory to set
     */
    @Inject
    public void setActionProxyFactory(ActionProxyFactory actionProxyFactory) {
        this.actionProxyFactory = actionProxyFactory;
    }

    /**
     * Set the action name.
     * 
     * @param actionName
     *            The action name.
     */
    public void setActionName(String actionName) {
        this.actionName = actionName;
    }

    /**
     * sets the namespace of the Action that we're chaining to. if namespace is null, this defaults to the current
     * namespace.
     * 
     * @param namespace
     *            the name of the namespace we're chaining to
     */
    public void setNamespace(String namespace) {
        this.namespace = namespace;
    }

    /**
     * Set the list of actions to skip. To test if an action should not throe an infinite recursion, only the action
     * name is used, not the namespace.
     * 
     * @param actions
     *            The list of action name separated by a white space.
     */
    public void setSkipActions(String actions) {
        this.skipActions = actions;
    }

    public void setMethod(String method) {
        this.methodName = method;
    }

    public ActionProxy getProxy() {
        return proxy;
    }

    /**
     * Get the XWork chain history. The stack is a list of <code>namespace/action!method</code> keys.
     */
    public static LinkedList getChainHistory() {
        LinkedList chainHistory = (LinkedList) ActionContext.getContext().get(CHAIN_HISTORY);
        // Add if not exists
        if (chainHistory == null) {
            chainHistory = new LinkedList();
            ActionContext.getContext().put(CHAIN_HISTORY, chainHistory);
        }

        return chainHistory;
    }

    /**
     * @param invocation
     *            the DefaultActionInvocation calling the action call stack
     * @throws Exception
     *             exc
     */

    public void execute(ActionInvocation invocation) throws Exception {
        // if the finalNamespace wasn't explicitly defined, assume the current
        // one
        if (this.namespace == null) {
            this.namespace = invocation.getProxy().getNamespace();
        }

        ValueStack stack = ActionContext.getContext().getValueStack();
        String finalNamespace = TextParseUtil.translateVariables(namespace, stack);
        String finalActionName = TextParseUtil.translateVariables(actionName, stack);
        String finalMethodName = this.methodName != null ? TextParseUtil.translateVariables(this.methodName, stack) : null;

        int index = -1;
        // 项目中用到的跳转前缀
        if (!finalActionName.startsWith("dispatcher.") && !finalActionName.startsWith("redirect.")) {
            index = finalActionName.indexOf('!');
        }

        if (index != -1) {
            finalMethodName = finalActionName.substring(index + 1).split("\\.")[0];
            finalActionName = finalActionName.substring(0, index).split("/")[finalActionName.substring(0, index).split(
                            "/").length - 1];
        } else {
            finalMethodName = this.methodName != null ? TextParseUtil.translateVariables(this.methodName, stack) : null;
        }
        index = finalMethodName != null ? finalMethodName.indexOf('?') : -1;
        String paramStr = null;
        if (index != -1) {
            paramStr = finalMethodName.substring(index + 1);
            finalMethodName = finalMethodName.substring(0, index);
        }

        Map paramMap = ActionContext.getContext().getParameters();
        if (paramStr != null) {
            String[] params = paramStr.split("&");
            for (String temp : params) {
                index = temp.indexOf('=');
                paramMap.put(temp.substring(0, index), temp.substring(index + 1));
            }
        }

        if (isInChainHistory(finalNamespace, finalActionName, finalMethodName)) {
            addToHistory(finalNamespace, finalActionName, finalMethodName);
            throw new XWorkException("Infinite recursion detected: " + ActionChainResult.getChainHistory().toString());
        }

        if (ActionChainResult.getChainHistory().isEmpty() && invocation != null && invocation.getProxy() != null) {
            addToHistory(finalNamespace, invocation.getProxy().getActionName(), invocation.getProxy().getMethod());
        }
        addToHistory(finalNamespace, finalActionName, finalMethodName);

        HashMap extraContext = new HashMap();
        extraContext.put(ActionContext.VALUE_STACK, ActionContext.getContext().getValueStack());
        extraContext.put(ActionContext.PARAMETERS, paramMap);
        extraContext.put(CHAIN_HISTORY, ActionChainResult.getChainHistory());

        proxy = actionProxyFactory.createActionProxy(finalNamespace, finalActionName, finalMethodName, extraContext);
        proxy.execute();
    }

    /**
     * 重写equals
     */
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        final ActionChainResult that = (ActionChainResult) o;

        if (actionName != null ? !actionName.equals(that.actionName) : that.actionName != null) {
            return false;
        }
        if (methodName != null ? !methodName.equals(that.methodName) : that.methodName != null) {
            return false;
        }
        if (namespace != null ? !namespace.equals(that.namespace) : that.namespace != null) {
            return false;
        }

        return true;
    }

    /**
     * 重写hashcode
     */
    public int hashCode() {
        int result;
        result = actionName != null ? actionName.hashCode() : 0;
        result = 31 * result + (namespace != null ? namespace.hashCode() : 0);
        result = 31 * result + (methodName != null ? methodName.hashCode() : 0);
        return result;
    }

    /**
     * isInChainHistory
     * 
     * @param namespace
     * @param actionName
     * @param methodName
     * @return
     */
    private boolean isInChainHistory(String namespace, String actionName, String methodName) {
        LinkedList chainHistory = ActionChainResult.getChainHistory();

        if (chainHistory == null) {
            return false;
        } else {
            // Actions to skip
            Set skipActionsList = new HashSet();
            if (skipActions != null && skipActions.length() > 0) {
                ValueStack stack = ActionContext.getContext().getValueStack();
                String finalSkipActions = TextParseUtil.translateVariables(this.skipActions, stack);
                skipActionsList.addAll(TextParseUtil.commaDelimitedStringToSet(finalSkipActions));
            }
            if (!skipActionsList.contains(actionName)) {
                // Get if key is in the chain history
                return chainHistory.contains(makeKey(namespace, actionName, methodName));
            }

            return false;
        }
    }

    /**
     * 加入到历史记录
     * 
     * @param namespace
     * @param actionName
     * @param methodName
     */
    private void addToHistory(String namespace, String actionName, String methodName) {
        LinkedList chainHistory = ActionChainResult.getChainHistory();
        chainHistory.add(makeKey(namespace, actionName, methodName));
    }

    /**
     * 生成key
     * 
     * @param namespace
     * @param actionName
     * @param methodName
     * @return
     */
    private String makeKey(String namespace, String actionName, String methodName) {
        if (null == methodName) {
            return namespace + "/" + actionName;
        }

        return namespace + "/" + actionName + "!" + methodName;
    }
}