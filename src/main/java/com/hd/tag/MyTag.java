package com.hd.tag;

import org.apache.taglibs.standard.lang.support.ExpressionEvaluatorManager;
import org.apache.taglibs.standard.tag.common.core.OutSupport;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import java.io.IOException;
import java.io.StringWriter;

public class MyTag extends OutSupport {
    private String number;

    public void setNumber(String number) throws JspException {
        // 对el表达式的处理
        Object num = ExpressionEvaluatorManager.evaluate("number", number.toString(), Object.class, this, pageContext);
        String number1 = (String) num;
        StringBuffer buffer = new StringBuffer(number1);
        int length = buffer.length();
        // 每隔4位数字插入一个空格
        for (int cnt = 4;cnt < length;cnt+=4){
            buffer.insert(cnt, ' ');
            cnt++; //插入空格时，需要偏移一位
            length++; //插入时长度也会改变
        }
        this.number = buffer.toString();
    }

    StringWriter sw = new StringWriter();

    @Override
    public int doStartTag() throws JspException {
        JspWriter out = pageContext.getOut();
        try {
            out.write(number);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return SKIP_BODY;
    }
}
