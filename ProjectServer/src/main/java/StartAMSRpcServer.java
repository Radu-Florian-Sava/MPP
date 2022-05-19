import network.utils.AbstractServer;
import network.utils.RpcAMSConcurrentServer;
import network.utils.ServerException;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class StartAMSRpcServer {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring-server.xml");
        AbstractServer server=context.getBean("projectTCPServer", RpcAMSConcurrentServer.class);
        try {
            server.start();
        } catch (ServerException e) {
            System.err.println("Error starting the server" + e.getMessage());
        }
    }
}