/**
 * @author lixiangyu
 * @title: servlet
 * @projectName untitled
 * @description: TODO
 * @date 2021/5/64:31 下午
 */

/**：
 * sun公司指定的javaEE规范：servlet规范
 * Servlet接口是Servlet规范中的核心接口
 * 接口要注意 调用者和实现者 分别是谁？
 * 实现者当然是 我们 调用者 是 Web容器
 */
//服务器端的java程序必须实现servlet接口
public interface servlet {
    //必须实现service()方法
            void service();
}
//好了 规范定义好了
